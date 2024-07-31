package com.entity;

public class Appointment {
	
	private String userName;
	private String fullname;
	private String gender;
	private String age;
	private String appoinDate;
	private String email;
	private	String phno;
	private String Disease;
	private String docName;
	private String address;
	private String status;
	
	
	
	
	
	
	public Appointment() {
		super();
	}






	





	public Appointment(String userName, String fullname, String gender, String age, String appoinDate, String email,
			String phno, String disease, String docName, String address, String status) {
		super();
		this.userName = userName;
		this.fullname = fullname;
		this.gender = gender;
		this.age = age;
		this.appoinDate = appoinDate;
		this.email = email;
		this.phno = phno;
		Disease = disease;
		this.docName = docName;
		this.address = address;
		this.status = status;
	}












	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}






	public String getFullname() {
		return fullname;
	}






	public void setFullname(String fullname) {
		this.fullname = fullname;
	}






	public String getGender() {
		return gender;
	}






	public void setGender(String gender) {
		this.gender = gender;
	}






	public String getAge() {
		return age;
	}






	public void setAge(String age) {
		this.age = age;
	}






	public String getAppoinDate() {
		return appoinDate;
	}






	public void setAppoinDate(String appoinDate) {
		this.appoinDate = appoinDate;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getPhno() {
		return phno;
	}






	public void setPhno(String phno) {
		this.phno = phno;
	}






	public String getDisease() {
		return Disease;
	}






	public void setDisease(String disease) {
		Disease = disease;
	}






	public String getDocName() {
		return docName;
	}






	public void setDocName(String docName) {
		this.docName = docName;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public String getStatus() {
		return status;
	}






	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
