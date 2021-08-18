package com.revature.model;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class Cart {

	private int crP_id;
	private String cp_name;
	private int cp_price;
	private int cus_id;
	
	public Cart() {
		
	}
	@Override
	public String toString() {
		return "Cart [crP_id=" + crP_id + ", cp_name=" + cp_name + ", cp_price=" + cp_price + ", cus_id=" + cus_id + "]";
	}
	public Cart(int crP_id, String cp_name, int cp_price, int cus_id) {
		super();
		this.crP_id = crP_id;
		this.cp_name = cp_name;
		this.cp_price = cp_price;
		this.cus_id = cus_id;
	}
	public int getCrP_id() {
		return crP_id;
	}
	public void setCrP_id(int crP_id) {
		this.crP_id = crP_id;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public int getCp_price() {
		return cp_price;
	}
	public void setCp_price(int cp_price) {
		this.cp_price = cp_price;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	
}
