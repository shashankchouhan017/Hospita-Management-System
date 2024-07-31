package com.entity;

public class User {

	
	private String fullname;
	private String email;
	private String pass;
	
	
	public User() {
		super();
	}
	public User(String fullname, String email, String pass) {
		
		this.fullname = fullname;
		this.email = email;
		this.pass = pass;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
