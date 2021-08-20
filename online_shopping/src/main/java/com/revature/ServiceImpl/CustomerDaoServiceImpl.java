package com.revature.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.dbutil.MySqlDBConnection;
import com.app.exception.BusinessException;
import com.revature.Service.CustomerDaoService;
import com.revature.dao.CustomerDao;
import com.revature.dao.impl.CustomerDaoImpl;
import com.revature.model.Cart;
import com.revature.model.Customer;
import com.revature.model.Order;
import com.revature.model.Product;

public class CustomerDaoServiceImpl implements CustomerDaoService{
	
	Logger log = Logger.getLogger(CustomerDaoServiceImpl.class);
	CustomerDao customerDao= new CustomerDaoImpl();
	@Override
	public int addCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
	
		c=customerDao.addCustomer(customer);
		return c;
	}

	@Override
	public int addToCart(Product product, Customer customer, int pro_price) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		//CustomerDao customerDao= new CustomerDaoImpl();
		try {
		c=customerDao.addToCart(product,customer,pro_price);
		}
		catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return c;
	}

	@Override
	public int placeOrder(int crP_id, Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		int r=0;
		CustomerDao customerDao= new CustomerDaoImpl();
		try {
		  r= customerDao.placeOrder(crP_id,customer);
			}
		catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return r;
	}

	@Override
	public List<Cart> showCart(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerDao customerDao= new CustomerDaoImpl();
		try {
		customerDao.showCart(customer);
		}
		catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return null;
	}

	@Override
	public String validEmail(String email) throws BusinessException {
		// TODO Auto-generated method stub
		String getPass=null;
		int res=0;
	
		getPass=customerDao.validEmail(email);
		return getPass;
	}

	@Override
	public void viewOrder(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		List<Order> orderList= new ArrayList<>();
	
		customerDao.viewOrder(customer);
		
	}
	
	public boolean validEmailForNewCustomer(String email){
		if(email.contains("@"))
			return true;
		else {
			log.info("Please enter a valid email id\n");
			return false;
		}
	}
	@Override
	public boolean validPasswordForNewCustomer(String pass){
		if (pass.contains("@") || pass.contains("#")|| pass.contains("$") || pass.contains("%")|| pass.contains("!") || pass.contains("~")
	              || pass.contains(")") || pass.contains("-")
	              || pass.contains("+") || pass.contains("/")
	              || pass.contains("^") || pass.contains("&")
	              || pass.contains("*") || pass.contains("(")
	             )
			return true;
		else {
			log.info("Ypur password should contain at least one special character id\n");
			return false;
		}
	}
}
