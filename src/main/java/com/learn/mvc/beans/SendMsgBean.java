package com.learn.mvc.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class SendMsgBean {

	private String registrationToken = "";
	private String REGEX = "\"";

	public boolean tokenRec(boolean sent) {

		if (registrationToken == "") {
			return sent;
		} else {
			sent = true;
			return sent;
		}
	}

	public void init(String token) throws ServletException, IOException {

		Pattern p = Pattern.compile(REGEX);

		// get a matcher object
		Matcher m = p.matcher(token);
		registrationToken = m.replaceAll("");

		FileInputStream serviceAccount = new FileInputStream(
				"C:\\Users\\user\\Downloads\\pushnotification-ff078-firebase-adminsdk-7l9n8-73c9197f8b.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://pushnotification-ff078.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

	}

	public void sendMsg() throws FirebaseMessagingException {

		// create dynamic payload

		// See documentation on defining a message payload.
		Message message = Message.builder().putData("details" ,"Event triggered. Click for" + 
		"more details.")
				.setToken(registrationToken).build();

		// Send a message to the device corresponding to the provided
		// registration token.
		FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
	}

}
