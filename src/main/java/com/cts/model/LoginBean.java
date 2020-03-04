package com.cts.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class LoginBean implements Serializable{
	
	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "Password is Mandatory")
	private String password;
	
	
	private String loginAs;
	
	
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getLoginAs() {
		return loginAs;
	}



	public void setLoginAs(String loginAs) {
		this.loginAs = loginAs;
	}



	public LoginBean(String username, String password, String loginAs) {
		super();
		this.username = username;
		this.password = password;
		this.loginAs = loginAs;
	}
	
	

}
