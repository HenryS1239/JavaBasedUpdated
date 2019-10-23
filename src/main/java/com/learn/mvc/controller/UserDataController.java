package com.learn.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.learn.mvc.beans.CompareDataBean;
import com.learn.mvc.beans.SendMsgBean;
import com.learn.mvc.beans.UserDataBean;

@Controller
public class UserDataController {

	/* Autowired the web application context object. */
	@Autowired
	private WebApplicationContext webContext;

	public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

	// This method map to http://localhost:8080/Facebook/showLogin.html
	@RequestMapping("/showData.html")
	public String showLoginPage() {
		return "user_data";
	}


	/*
	 * // This method map to http://localhost:8080/Facebook/doLogin.html
	 * 
	 * @RequestMapping("/doData.html") public String doData(Model
	 * model, @ModelAttribute("acc_no") String acc_no,
	 * 
	 * @ModelAttribute("option") String option, @ModelAttribute("amount") String
	 * amount, HttpServletRequest req) throws FirebaseMessagingException {
	 * 
	 * UserDataBean userDBean = (UserDataBean) webContext.getBean("userDBean");
	 * 
	 * userDBean.userDB(acc_no, option, amount); SendMsgBean sendBean =
	 * (SendMsgBean) webContext.getBean("notifyBean"); sendBean.sendMsg(); return
	 * "user_data"; }
	 */
}