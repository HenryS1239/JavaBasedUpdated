package com.learn.mvc.controller;

import java.sql.Array;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.learn.mvc.messaging.ClientInputBean;
import com.learn.mvc.messaging.NewStaffNotBean;
import com.learn.mvc.messaging.NotifyBean;

@Controller
public class PNControllerTemp {

	/* Autowired the web application context object. */
	@Autowired
	private WebApplicationContext webContext;

	private boolean sent = false;

	public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

	// This method map to http://localhost:8080/SpringMVCXmlBased/showLogin.html
	@RequestMapping(value = "/doNotify.html", method = RequestMethod.GET)
	public ModelAndView showLoginPage(Model model) {
		return new ModelAndView("push_not", "command", new NotifyBean());
	}

	@RequestMapping(value = "/reqtoken.html", method=RequestMethod.POST, consumes= {"application/json"})
	ResponseEntity<String> registerToken(HttpServletResponse resp){
		
		NewStaffNotBean staffNotBean = (NewStaffNotBean) webContext.getBean("staffBean");
	    
		String token = staffNotBean.genToken();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("token", token);
		resp.setHeader("Content-Type", token);
		return ResponseEntity.ok(token);
	}

	@RequestMapping("/result.html")
	public String showResult() {
		//return "show_userdata";
		return "show_update";
	}
	
	@RequestMapping(value="/checknotify.html")
	ResponseEntity<String> checkNotification(@RequestBody String token) {
		ClientInputBean clientBean = (ClientInputBean) webContext.getBean("clientBean");
		Array usersAvailable = clientBean.getUsers();
		if(usersAvailable != null) {
			String users = usersAvailable.toString();
			if(users.contains(token))
				return new ResponseEntity<String>("Notification Found",HttpStatus.OK);
			else
				return new ResponseEntity<String>("", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("", HttpStatus.OK);
		
	}
	
	@RequestMapping("/notify.html")
	public String registerNotify(Model model, 
			@ModelAttribute("userid") String userid,
			@ModelAttribute("groupid") String groupid,
			@ModelAttribute("option") String option,
			@ModelAttribute("amount") String value,
			@ModelAttribute("token") String token) {
		
		NotifyBean staff = new NotifyBean();
		staff.setUserid(userid);
		staff.setGroupid(groupid);
		staff.setToken(token);
		staff.setOption(option);
		staff.setAmount(value);
		
		NewStaffNotBean staffNotBean = (NewStaffNotBean) webContext.getBean("staffBean");
		staffNotBean.registerNotify(staff);
		
		return "login_success";
	}

}