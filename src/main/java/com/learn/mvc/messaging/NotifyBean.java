package com.learn.mvc.messaging;

public class NotifyBean {
	
	private String userid;
	private String groupid;
	private String token;
	private String option;
	private String value;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token= token;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getValue() {
		return value;
	}
	public void setAmount(String value) {
		this.value = value;
	}

	
}
