package com.revature.model;

public class Order {
	private String o_status;
	private int o_id;
	private int oc_id;
	@Override
	public String toString() {
		return "Order [o_status=" + o_status + ", o_id=" + o_id + "]";
	}
	public Order(String o_status, int o_id) {
		super();
		this.o_status = o_status;
		this.o_id = o_id;
	}
	public Order() {
		
	}
	public String getO_status() {
		return o_status;
	}
	public void setO_status(String o_status) {
		this.o_status = o_status;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
}
