package com.revature.Service;

import java.util.List;

import com.app.exception.BusinessException;
import com.revature.model.Customer;

public interface CustomerSearchDaoService {
public Customer searchByOrderId(int orderId)throws BusinessException;
	
	public List<Customer> searchByFname(String fname)throws BusinessException;
	
	public List<Customer> searchByLname(String lname)throws BusinessException;
	
	public Customer searchByEmailId(String email)throws BusinessException;
	
	public Customer searchById(int customer_id)throws BusinessException;
}
