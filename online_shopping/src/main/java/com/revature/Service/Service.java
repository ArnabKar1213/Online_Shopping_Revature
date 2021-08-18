package com.revature.Service;

import java.util.List;

import com.app.exception.BusinessException;
import com.revature.model.Cart;
import com.revature.model.Customer;
import com.revature.model.Product;

public interface Service {
	
public int addCustomer(Customer customer)throws BusinessException;
	
	//public Customer searchCustomer(Customer customer)throws BusinessException;
	
	public int addToCart(Product product,Customer customer,int pro_price)throws BusinessException;
	
	
	public int placeOrder(int crP_id)throws BusinessException;
	
	public List<Cart> showCart(Customer customer)throws BusinessException;
	
	public String validEmail(String email)throws BusinessException;
	
	public Customer searchByOrderId(int orderId)throws BusinessException;
	
	public List<Customer> searchByFname(String fname)throws BusinessException;
	
	public List<Customer> searchByLname(String lname)throws BusinessException;
	
	public Customer searchByEmailId(String email)throws BusinessException;
	
	public boolean validEmpEmail(String emp_email)throws BusinessException;
	
	public boolean validEmpPass(String emp_pass)throws BusinessException;
	
	public boolean markStatus(Product product)throws BusinessException;
	
	
	//public boolean searchCustomer()throws BusinessException;

	public int addProductByEmp(Product product)throws BusinessException;
	
	public int addProduct(Product product)throws BusinessException;
	
	public void getAllProducts()throws BusinessException;
	
	public int getProductPrice(String p_name)throws BusinessException;
	
	
}
