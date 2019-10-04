package com.learn.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.learn.mvc.beans.SqlSearchBean;

@Controller
public class LoginController {

    /* Autowired the web application context object. */
    @Autowired
    private WebApplicationContext webContext;

    public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

    // This method map to http://localhost:8080/SpringMVCXmlBased/showLogin.html
    @RequestMapping("/showLogin.html")
    public String showLoginPage() {
        return "show_login"; 	
    }

    // This method map to http://localhost:8080/SpringMVCXmlBased/doLogin.html
    @RequestMapping("/doLogin.html")
    public String doLogin(Model model, @ModelAttribute("userid")
            String userid, @ModelAttribute("groupid") String groupid, 
                          @ModelAttribute("password") String password,
                          HttpServletRequest req) {
        
        //Get spring bean from the autowired web application context.
        //UserAccountBean accountBean = (UserAccountBean)webContext.getBean("userAccountBean");
        SqlSearchBean searchDBean = (SqlSearchBean)webContext.getBean("searchDBean");

        //boolean checkResult = accountBean.checkUserLogin(userid, groupid, password);
        boolean result = searchDBean.searchDB(userid, groupid, password);

        if (result) { //result)
            return "login_success";
        } 
        else {
            model.addAttribute(STATUS_MESSAGE, "Invalid Login. Please Try Again.");
            return "show_login";
        }
    }
    
}