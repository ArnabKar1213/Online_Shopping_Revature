package com.revature.model;

public class Employee {

	private int emp_id;
	private String emp_fname;
	private String emp_lname;
	private String emp_emailId;
	private String emp_pass;
	
	public Employee(){
		
	}
	
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_fname=" + emp_fname + ", emp_lname=" + emp_lname + ", emp_emailId="
				+ emp_emailId + ", emp_pass=" + emp_pass + "]";
	}

	
}
