package com.learn.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.learn.mvc.beans.SqlUpdateBean;
//change this to notification bean

@Controller
public class PushNotifyController{

    /* Autowired the web application context object. */
    @Autowired
    private WebApplicationContext webContext;

    public static final String STATUS_MESSAGE = "STATUS_MESSAGE";

    // This method map to http://localhost:8080/SpringMVCXmlBased/doNotify.html
    @RequestMapping("/doNotify.html")
    public String showUpdatePage() {
        return "push_not"; 	
    }

    // This method map to http://localhost:8080/SpringMVCXmlBased/notify.html
    @RequestMapping("/notify.html")
    public String doNotify(Model model, @ModelAttribute("userid")
            String userid, @ModelAttribute("groupid") String groupid, 
                          @ModelAttribute("notetype") String notetype,
                          @ModelAttribute("custommsg") String custommsg,
                          HttpServletRequest req) {
        
        //Get spring bean from the autowired web application context.
/*        SqlUpdateBean updateDBean = (SqlUpdateBean)webContext.getBean("updateDBean");
        
        
        updateDBean.updateDB(userid, groupid, password);
*/
        return "login_success";
    }
    
}