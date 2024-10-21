package com.cdac.acts.javamain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Validation {

	public static Integer phoneNumberValidation(Integer phno, List<Employee> list) throws MyException {
		
		for(Employee emp:list) {
			if(emp.getPhoneNo().contains(phno)) {
				throw new MyException("enter valid number....!!");
			}
		}
		
		
		return phno;
		
		
	}

	public static List<Employee> ageValidation(List<Employee> list) throws MyException {
	List<Employee> emp=new ArrayList<Employee>();
	
		for(Employee emp1: list ) {
			if (emp1.getDate().isBefore(LocalDate.now().minusYears(80))) {
				
			}else {
				emp.add(emp1);
			}
			
		}
		return emp;
		
	}

	
}
