package com.learn.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.learn.mvc.beans.UserDataBean;
import com.learn.mvc.beans.ValidateBean;
import com.learn.mvc.messaging.ClientInputBean;
import com.learn.mvc.beans.SqlTransactionBean;

@Controller
@Component
public class ClientDataController {

	/* Autowired the web application context object. */
	@Autowired
	private WebApplicationContext webContext;
	public static List<String> usersAvailable;

	@Autowired
	private SimpMessagingTemplate template;

	public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

	// This method map to http://localhost:8080/Facebook/showLogin.html
	@RequestMapping("/showData.html")
	public String showLoginPage() {
		return "user_data";
	}

	// This method map to http://localhost:8080/Facebook/doLogin.html

	@RequestMapping("/doData.html")
	public String doData(Model model, @ModelAttribute("acc_no") String acc_no, @ModelAttribute("option") String option,
			@ModelAttribute("amount") String value) throws Exception {

		ValidateBean validBean = (ValidateBean) webContext.getBean("validBean");
		if (validBean.checkType(option) != null) {
			UserDataBean userDBean = (UserDataBean) webContext.getBean("userDBean");
			ClientInputBean clientBean = (ClientInputBean) webContext.getBean("clientBean");
			SqlTransactionBean transBean = (SqlTransactionBean) webContext.getBean("transBean");

			usersAvailable = clientBean.searchUsers(option, value);
			this.template.convertAndSend("/topic/checknotify", "Notification_Available");
			userDBean.userDB(acc_no, option, value);
			transBean.transDB(option, value);
			return "user_data";
		} else
			return "user_data";
	}

	@MessageMapping("/checknotify")
	public String check(@Payload String string) {
		if (string.equalsIgnoreCase("Check")) {
			if (usersAvailable != null) {
				return "Notification_Available";
			} else {
				return "Notification_Unavailable";
			}
		} else if (string.equalsIgnoreCase("Send_Notification")) {
			String msg = usersAvailable.size() + " user(s) requesting approval";
			return msg;
		} else {
			return "error";
		}
	}
}