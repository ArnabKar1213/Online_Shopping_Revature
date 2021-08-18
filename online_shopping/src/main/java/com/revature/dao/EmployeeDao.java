package com.revature.dao;

import com.app.exception.BusinessException;
import com.revature.model.Product;

public interface EmployeeDao {

	public boolean validEmpEmail(String emp_email)throws BusinessException;
	
	public boolean validEmpPass(String emp_pass)throws BusinessException;
	
	public int markStatus(int order_id)throws BusinessException;
	
	
	//public boolean searchCustomer()throws BusinessException;

	public int addProductByEmp(Product product)throws BusinessException;
}
