package com.learn.mvc.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;
import nl.martijndwars.webpush.Subscription;

import com.learn.mvc.beans.SendMsgBean;
import com.learn.mvc.beans.LogDebug;

@Controller
public class NotificationCtrller {
	
	@Autowired
	private WebApplicationContext webContext;

	@PostMapping(path="/notify.html")
	public void accSubEntity(@RequestBody Subscription sub) throws GeneralSecurityException, IOException, JoseException, ExecutionException, InterruptedException {
		
		LogDebug log = new LogDebug();
		log.showloc("accSub");
		SendMsgBean sendBean = (SendMsgBean)webContext.getBean("notifyBean");
		sendBean.createResp(sub); 
		
	}
	

}
