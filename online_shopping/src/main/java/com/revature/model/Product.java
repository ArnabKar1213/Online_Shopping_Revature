package com.revature.model;

public class Product {

	private int p_id;
	private String p_name;
	private int p_price;
	private String p_category;
	private int p_quantity;
	
	public Product() {
		
	}
	public Product(String p_name) {
		this.p_name=p_name;
	}
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_price=" + p_price + ", p_category=" + p_category
				+ ", p_quantity=" + p_quantity + "]";
	}
	public Product(String p_name, int p_price, String p_category, int p_quantity) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_category = p_category;
		this.p_quantity = p_quantity;
	}
	public Product(int p_id, String p_name, int p_price, String p_category, int p_quantity) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_category = p_category;
		this.p_quantity = p_quantity;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public int getP_quantity() {
		return p_quantity;
	}
	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}
}
