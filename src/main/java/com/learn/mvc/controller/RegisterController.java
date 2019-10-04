package com.learn.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.learn.mvc.beans.SqlRegisterBean;


@Controller
public class RegisterController
{
	@Autowired
	private WebApplicationContext webContext;
	
	public static final String STATUS_MESSAGE = "STATUS_MESSAGE";
	
	@RequestMapping("/doRegister.html")
	public String showRegPage() {
		return "show_register";
	}
	
	@RequestMapping("/register.html")
	public String showRegisterAction(Model model, @ModelAttribute("userid")
	    String userid, @ModelAttribute("groupid") String groupid,
	    @ModelAttribute("password") String password,
	    HttpServletRequest req) {
		
	 SqlRegisterBean registerDBean = (SqlRegisterBean)webContext.getBean("registerDBean");
	 
	 registerDBean.registerDB(userid, groupid, password);
	 
	 return "login_success";
	 
	}

}