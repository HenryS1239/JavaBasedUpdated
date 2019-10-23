package com.learn.mvc.beans;

public class CompareDataBean {
	
	private String userAcc;
	private String option;
	private String transVal;
	
	public CompareDataBean() {
		
	}
	
	public void createComp(String userAcc, String option, String transVal) {
		this.userAcc = userAcc;
		this.option = option;
		this.transVal = transVal;
		
	}
	
	public boolean compare(String setAcc, String option, String setVal) {
		
		if(setAcc.compareToIgnoreCase(userAcc) == 0 && 
				option.compareToIgnoreCase(this.option) == 0 && 
				Integer.parseInt(setVal) >= Integer.parseInt(transVal))
			return true;
		else
			return false;
	}

}
