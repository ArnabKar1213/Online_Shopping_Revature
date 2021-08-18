package com.revature.model;

public class Customer {

	private int c_id;
	private String c_fname;
	private String c_lname;
	private String c_emailId;
	private String c_pass;
	public Customer() {
		
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_fname() {
		return c_fname;
	}
	public void setC_fname(String c_fname) {
		this.c_fname = c_fname;
	}
	public String getC_lname() {
		return c_lname;
	}
	public void setC_lname(String c_lname) {
		this.c_lname = c_lname;
	}
	public String getC_emailId() {
		return c_emailId;
	}
	public void setC_emailId(String c_emailId) {
		this.c_emailId = c_emailId;
	}
	public String getC_pass() {
		return c_pass;
	}
	public void setC_pass(String c_pass) {
		this.c_pass = c_pass;
	}
	public Customer(int c_id, String c_fname, String c_lname, String c_emailId, String c_pass) {
		
		this.c_id = c_id;
		this.c_fname = c_fname;
		this.c_lname = c_lname;
		this.c_emailId = c_emailId;
		this.c_pass = c_pass;
	}
	public Customer(String c_fname, String c_lname, String c_emailId, String c_pass) {
		
		
		this.c_fname = c_fname;
		this.c_lname = c_lname;
		this.c_emailId = c_emailId;
		this.c_pass = c_pass;
	}
	
}
