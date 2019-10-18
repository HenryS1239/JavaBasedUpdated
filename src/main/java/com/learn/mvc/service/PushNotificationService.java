package com.learn.mvc.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
@Service
public class PushNotificationService {
 
  private static final String FIREBASE_SERVER_KEY = "AAAApPJRSpA:APA91bELafdHmE0ISWzWpwLSy-3OS-A0fTYhBxo5X9Pc-q1Tp2wPofgVQOcKHh390NTw_cpJIxDVcDYBN5Sb-dEAsUwl74pLftTNtzx9MQWKSU2DPBqiEV__mMQLYDhsbGi3D9u75M_p";
  private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
  
  @Async
  public CompletableFuture<String> send(HttpEntity<String> entity) {
 
    RestTemplate restTemplate = new RestTemplate();
 
    /**
    https://fcm.googleapis.com/fcm/send
    Content-Type:application/json
    Authorization:key=FIREBASE_SERVER_KEY*/
 
    ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
    restTemplate.setInterceptors(interceptors);
 
    String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
 
    return CompletableFuture.completedFuture(firebaseResponse);
  }
}
