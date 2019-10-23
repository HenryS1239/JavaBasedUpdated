package com.learn.mvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.google.firebase.messaging.FirebaseMessagingException;

import com.learn.mvc.beans.SendMsgBean;
import com.learn.mvc.beans.UserDataBean;
import com.learn.mvc.beans.ValidateBean;
import com.learn.mvc.beans.CompareDataBean;

@Controller
public class PNControllerTemp {

	/* Autowired the web application context object. */
	@Autowired
	private WebApplicationContext webContext;

	private boolean sent = false;

	public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

	// This method map to http://localhost:8080/SpringMVCXmlBased/showLogin.html
	@RequestMapping("/doNotify.html")
	public String showLoginPage() {
		return "push_not";
	}

	@RequestMapping(value = "/token.html", method = RequestMethod.POST, consumes = { "application/json" })
	public String registerToken(@RequestBody String token) throws ServletException, IOException {
		SendMsgBean sendBean = (SendMsgBean) webContext.getBean("notifyBean");

		if (sendBean.tokenRec(sent))
			return "push_not";
		else {
			sendBean.init(token);
			sendBean.tokenRec(sent);
			return "push_not";
		}
	}

	@RequestMapping(value = "/sent.html")
	ResponseEntity<String> checkSent() {
		SendMsgBean sendBean = (SendMsgBean) webContext.getBean("notifyBean");
		sent = sendBean.tokenRec(sent);
		return ResponseEntity.ok(String.valueOf(sent));
	}
	
	@RequestMapping("/result.html")
	public String showResult() {
		return "show_userdata";
	}

	@RequestMapping(value = "/notify.html", method = RequestMethod.POST, 
			consumes = { "application/json" }, produces= "text/html;charset=UTF-8")
	ResponseEntity<String> sendMsg(@RequestBody Map<String, String> payload)
			throws FirebaseMessagingException, ServletException, IOException {
		
		String acc_no = payload.get("acc_no");
		String option = payload.get("option");
		String amount = payload.get("amount");
		
		ValidateBean checkBean = (ValidateBean) webContext.getBean("validBean");
		CompareDataBean compBean = (CompareDataBean) webContext.getBean("compareBean");
		UserDataBean userDBean = (UserDataBean) webContext.getBean("userDBean");
		SendMsgBean sendBean = (SendMsgBean) webContext.getBean("notifyBean");
		
		if(payload.size() == 5) {
			if (checkBean.validateVal(amount)) {
				if (checkBean.validateAcc(acc_no)) {
					compBean.createComp(acc_no, option, amount);
					return ResponseEntity.ok("localhost:8080/Facebook/update.html");
				}
			}	
			return ResponseEntity.ok("localhost:8080/Facebook/update.html");
		} else {
			userDBean.userDB(acc_no, option, amount);
			boolean result = compBean.compare(acc_no, option, amount);
			if (result) {
				sendBean.sendMsg();
				return ResponseEntity.ok("localhost:8080/Facebook/result.html");
			} else {
				return ResponseEntity.ok("localhost:8080/Facebook/result.html");
			}
				
		}
	}

}