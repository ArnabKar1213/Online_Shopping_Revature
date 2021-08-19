package com.revature.model;

public class Employee {

	private int emp_id;
	private String emp_fname;
	private String emp_lname;
	private String emp_emailId;
	private String emp_pass;
	
	public Employee(int emp_id, String emp_fname, String emp_lname, String emp_emailId, String emp_pass) {
		super();
		this.emp_id = emp_id;
		this.emp_fname = emp_fname;
		this.emp_lname = emp_lname;
		this.emp_emailId = emp_emailId;
		this.emp_pass = emp_pass;
	}


	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getEmp_fname() {
		return emp_fname;
	}


	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}


	public String getEmp_lname() {
		return emp_lname;
	}


	public void setEmp_lname(String emp_lname) {
		this.emp_lname = emp_lname;
	}


	public String getEmp_emailId() {
		return emp_emailId;
	}


	public void setEmp_emailId(String emp_emailId) {
		this.emp_emailId = emp_emailId;
	}


	public String getEmp_pass() {
		return emp_pass;
	}


	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}


	public Employee(){
		
	}
	
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_fname=" + emp_fname + ", emp_lname=" + emp_lname + ", emp_emailId="
				+ emp_emailId + ", emp_pass=" + emp_pass + "]";
	}

	
}
