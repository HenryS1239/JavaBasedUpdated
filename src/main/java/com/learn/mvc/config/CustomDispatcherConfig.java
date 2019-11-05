package com.learn.mvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.learn.mvc.beans.SqlDeleteBean;
import com.learn.mvc.beans.SqlRegisterBean;
import com.learn.mvc.beans.SqlSearchBean;
import com.learn.mvc.beans.SqlUpdateBean;
import com.learn.mvc.beans.UserDataBean;
import com.learn.mvc.beans.ValidateBean;
import com.learn.mvc.messaging.ClientInputBean;
import com.learn.mvc.messaging.NewStaffNotBean;
import com.learn.mvc.beans.SqlTransactionBean;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.learn.mvc")

public class CustomDispatcherConfig implements WebMvcConfigurer {

	public static final String ENCODING_UTF = "UTF";
	public static final String ENCODING_UTF_8 = "UTF-8";
	public static final long MAX_UPLOAD_FILE_SIZE = 52428807;
	public static final long MAX_UPLOAD_PER_FILE_SIZE = 5242880;

	/*
	 * This configuration will use InternalResourceViewResolver to resolve jsp pages
	 * back to client user. All the pages will be located in src/main/webapp/pages.
	 */

	@Bean
	public InternalResourceViewResolver getJspViewResolver() {
		InternalResourceViewResolver ret = new InternalResourceViewResolver();
		ret.setPrefix("/pages/");
		ret.setSuffix(".jsp");
		ret.setOrder(1);
		return ret;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/resources/**").addResourceLocations("META-INF/");
	}

	/*
	 * messageSource method name can not be change to others, else there will has
	 * errors when browse web page. messageSource is used to make page text
	 * internalization. The message file is saved in
	 * src/main/resources/config/messages_en_US.preoperties You should create config
	 * folder by yourself if it dose not exist.
	 */
	@Bean(name = "messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
		ret.setBasename("classpath:config/messages_en_US");
		ret.setCacheSeconds(1);
		ret.setUseCodeAsDefaultMessage(true);
		ret.setDefaultEncoding(ENCODING_UTF_8);
		return ret;
	}

	/* Register the SqlSearchBean. */
	@Bean(name = "searchDBean")
	public SqlSearchBean getSqlSearchBean() {
		SqlSearchBean search = new SqlSearchBean();
		return search;
	}

	/* Register the SqlRegisterBean. */
	@Bean(name = "registerDBean")
	public SqlRegisterBean getSqlRegisterBean() {
		SqlRegisterBean register = new SqlRegisterBean();
		return register;
	}

	/* Register the SqlUpdateBean. */
	@Bean(name = "updateDBean")
	public SqlUpdateBean getSqlUpdateBean() {
		SqlUpdateBean update = new SqlUpdateBean();
		return update;
	}

	/* Register the SqlDeleteBean. */
	@Bean(name = "deleteDBean")
	public SqlDeleteBean getSqlDeleteBean() {
		SqlDeleteBean delete = new SqlDeleteBean();
		return delete;
	}

	/* Register the SendMsgBean. */
	@Bean(name = "validBean")
	public ValidateBean getValidateBean() {
		ValidateBean vld = new ValidateBean();
		return vld;
	}

	@Bean(name = "userDBean")
	public UserDataBean getUserDataBean() {
		UserDataBean uDB = new UserDataBean();
		return uDB;
	}

	@Bean(name = "clientBean")
	@Scope(value = "singleton")
	public ClientInputBean getClientInputBean() {
		ClientInputBean clientB = new ClientInputBean();
		return clientB;
	}

	@Bean(name = "staffBean")
	public NewStaffNotBean getNewStaffNotBean() {
		NewStaffNotBean staffB = new NewStaffNotBean();
		return staffB;
	}

	@Bean(name = "transBean")
	public SqlTransactionBean getSqlTransactionBean() {
		SqlTransactionBean transB = new SqlTransactionBean();
		return transB;
	}
}