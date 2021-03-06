package com.revature.Service;

import java.util.List;

import com.app.exception.BusinessException;
import com.revature.model.Cart;
import com.revature.model.Customer;
import com.revature.model.Product;

public interface CustomerDaoService {

	public int addCustomer(Customer customer)throws BusinessException;
	
	//public Customer searchCustomer(Customer customer)throws BusinessException;
	
	public int addToCart(Product product,Customer customer,int pro_price)throws BusinessException;
	
	
	public int placeOrder(int crP_id,Customer customer)throws BusinessException;
	
	public List<Cart> showCart(Customer customer)throws BusinessException;
	
	public String validEmail(String email)throws BusinessException;
	
	public void viewOrder(Customer customer)throws BusinessException;
	
	public boolean validEmailForNewCustomer(String email);

	public boolean validPasswordForNewCustomer(String password);
}
