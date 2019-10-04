package com.learn.mvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.learn.mvc.beans.SqlSearchBean;
import com.learn.mvc.beans.SqlRegisterBean;
import com.learn.mvc.beans.SqlUpdateBean;
import com.learn.mvc.beans.SqlDeleteBean;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.learn.mvc")

public class CustomDispatcherConfig {

    public static final String ENCODING_UTF = "UTF";
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final long MAX_UPLOAD_FILE_SIZE = 52428807;
    public static final long MAX_UPLOAD_PER_FILE_SIZE = 5242880;

    /* This configuration will use InternalResourceViewResolver to resolve jsp pages back to client user.
     * All the pages will be located in src/main/webapp/pages.
     *  */
    @Bean
    public InternalResourceViewResolver getJspViewResolver() {

        InternalResourceViewResolver ret = new InternalResourceViewResolver();
        ret.setPrefix("/pages/");
        ret.setSuffix(".jsp");
        ret.setOrder(1);
        return ret;

    }


    /* messageSource method name can not be change to others, else there will has errors when browse web page.
     * messageSource is used to make page text internalization. The message file is saved in src/main/resources/config/messages_en_US.preoperties
     * You should create config folder by yourself if it dose not exist.
     * */
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
        ret.setBasename("classpath:config/messages_en_US");
        ret.setCacheSeconds(1);
        ret.setUseCodeAsDefaultMessage(true);
        ret.setDefaultEncoding(ENCODING_UTF_8);
        return ret;
    }

    /* Register the UserAccountBean.
    @Bean(name = "accountBean")
    public UserAccountBean getUserAccountBean() {
        UserAccountBean ret = new UserAccountBean();
        return ret;
    } */

    /*Register the SqlSearchBean. */
    @Bean(name = "searchDBean")
    public SqlSearchBean getSqlSearchBean() {
        SqlSearchBean search = new SqlSearchBean();
        return search;
    }
    
    @Bean(name = "registerDBean")
    public SqlRegisterBean getSqlRegisterBean() {
    	SqlRegisterBean register = new SqlRegisterBean();
    	return register;
    }
    
    @Bean(name = "updateDBean")
    public SqlUpdateBean getSqlUpdateBean() {
    	SqlUpdateBean update = new SqlUpdateBean();
    	return update;
    }
    
    @Bean(name = "deleteDBean")
    public SqlDeleteBean getSqlDeleteBean() {
    	SqlDeleteBean delete = new SqlDeleteBean();
    	return delete;
    }

}