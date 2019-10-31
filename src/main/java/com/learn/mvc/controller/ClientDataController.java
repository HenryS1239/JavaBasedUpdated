package com.learn.mvc.controller;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.learn.mvc.beans.UserDataBean;
import com.learn.mvc.messaging.ClientInputBean;

@Controller
public class ClientDataController{

	/* Autowired the web application context object. */
	@Autowired
	private WebApplicationContext webContext;

	public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

	// This method map to http://localhost:8080/Facebook/showLogin.html
	@RequestMapping("/showData.html")
	public String showLoginPage() {
		return "user_data";
	}

	//This method map to http://localhost:8080/Facebook/doLogin.html

	@RequestMapping("/doData.html")
	public String doData(Model model,
			@ModelAttribute("acc_no") String acc_no,
			@ModelAttribute("option") String option, 
			@ModelAttribute("amount") String value) throws Exception{

		
		UserDataBean userDBean = (UserDataBean) webContext.getBean("userDBean");
		ClientInputBean clientBean = (ClientInputBean) webContext.getBean("clientBean");
		clientBean.searchUsers(option, value);
		userDBean.userDB(acc_no, option, value);
		return "user_data";
	}
	
	public ResultSet getResults() {
		ClientInputBean clientBean = (ClientInputBean) webContext.getBean("clientBean");
		return clientBean.getResults();
	}

}