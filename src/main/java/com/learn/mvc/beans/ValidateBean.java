package com.learn.mvc.beans;

public class ValidateBean {
	private String patt1 = "\\d{9}";
	private String patt2 = "^[0-9]*$";
	
	public boolean validateAcc(String acc) {
		return acc.matches(patt1);
	}
	
	public boolean validateVal(String val) {
		return val.matches(patt2);
	}
}
