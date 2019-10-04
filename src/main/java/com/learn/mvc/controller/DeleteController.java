package com.learn.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.learn.mvc.beans.SqlDeleteBean;

@Controller
public class DeleteController {
	@Autowired
	private WebApplicationContext webContext;

	public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

	@RequestMapping("/doDelete.html")
	public String showRegPage() {
		return "show_delete";
	}

	@RequestMapping("/delete.html")
	public String showRegisterAction(Model model, @ModelAttribute("userid") String userid,
			HttpServletRequest req) {

		SqlDeleteBean deleteDBean = (SqlDeleteBean) webContext.getBean("deleteDBean");

		deleteDBean.deleteDB(userid);

		return "login_success";

	}

}