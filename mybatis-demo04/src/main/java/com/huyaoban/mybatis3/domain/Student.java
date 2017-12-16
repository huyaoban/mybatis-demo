package com.huyaoban.mybatis3.domain;

import java.util.Date;

public class Student {
	private Integer studId;
	private String name;
	private String email;
	private PhoneNumber phone;
	private Date dob;
	
	public Integer getStudId() {
		return studId;
	}
	
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "[" + studId + "," + name + "," + email + "," + phone + "," + dob + "]";
	}
	
}
