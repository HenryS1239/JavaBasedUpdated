package com.learn.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {


   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message)
         throws Exception {
	   
	  List<String> uA = ClientDataController.usersAvailable;
      String clientMessage = message.getPayload();
      
      if (clientMessage.startsWith("Request_Notification")) {
    	  if(uA != null) {
    		  session.sendMessage(new TextMessage("Notification_Available"));
    	  } else 
    		  session.sendMessage(new TextMessage("Notification_Unavailable"));
      } else if (clientMessage.startsWith("Send_Notification")) {
    	  int count = uA.size();
          session.sendMessage(new TextMessage(count + " user(s) have requested approval for registration"));
      } else {
    	  session.sendMessage(new TextMessage("error"));
      }
   }
   
}