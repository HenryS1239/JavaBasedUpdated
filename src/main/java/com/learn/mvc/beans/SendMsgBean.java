package com.learn.mvc.beans;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.concurrent.ExecutionException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jose4j.lang.JoseException;

import nl.martijndwars.webpush.*;

public class SendMsgBean {
	
	private String pubK = "BNl3JhXqE--qvGuiIgXfobXKxmvq98WB4jtNxMmo5BNFa-hbjrj2M3rPYUBr5glPwBA1s8Mc4Wf-tWJFA3y7qoY";
	private String priK = "SlTOWOH3T5iDZkrpBMwwaWV5gu4Q41wyCR-LEzvg0og";
	
	private String notBody = "Test Check I want food"; 
	
	public void createResp(Subscription sub) {
		try {
			Security.addProvider(new BouncyCastleProvider());
			PushService push = new PushService(pubK, priK, "");
			Notification not = new Notification(sub, notBody);
			
			System.out.println("Sent notification in sendMessageBean");
			push.send(not);
		}catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}catch (InterruptedException e2) {
			e2.printStackTrace();
		}catch (ExecutionException e3) {
			e3.printStackTrace();
		}catch (JoseException e4) {
			e4.printStackTrace();
		}catch (IOException e5) {
			e5.printStackTrace();
		}
	}

}
