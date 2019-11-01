package com.learn.mvc.beans;

public class ValidateBean {
	private String patt1 = "\\d{9}";
	private String patt2 = "^[0-9]*$";
	private String patt3 = "Deposit";
	private String patt4 = "Withdraw";
	
	
	public boolean validateAcc(String acc) {
		return acc.matches(patt1);
	}
	
	public boolean validateVal(String val) {
		return val.matches(patt2);
	}
	
	public String checkType(String option) {
		if(option.compareToIgnoreCase(patt3) == 0) {
			return option;
		} else if(option.compareToIgnoreCase(patt4) == 0) {
			return option;
		} else
			return null;
	}
}
