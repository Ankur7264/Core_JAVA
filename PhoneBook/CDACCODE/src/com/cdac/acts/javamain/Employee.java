package com.cdac.acts.javamain;

import java.time.LocalDate;
import java.util.List;

public class Employee {

	private List<Integer> phoneNo;
	private String name;
	private LocalDate date;
	private String email;
	public Employee(List<Integer> phoneNo, String name, LocalDate date, String email) {
		super();
		this.phoneNo = phoneNo;
		this.name = name;
		this.date = date;
		this.email = email;
	}
	public List<Integer> getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(List<Integer> phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [phoneNo=" + phoneNo + ", name=" + name + 
				", date=" + date + ", email=" + email + "]";
	}
	
	

}
