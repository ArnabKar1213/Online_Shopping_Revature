package com.revature.Service;

import com.app.exception.BusinessException;
import com.revature.model.Employee;
import com.revature.model.Product;

public interface EmployeeDaoService {
public String validEmpEmail(String emp_email)throws BusinessException;
	
	public boolean validEmpPass(String emp_pass)throws BusinessException;
	
	public int markStatus(int order_id)throws BusinessException;
	
	
	//public boolean searchCustomer()throws BusinessException;

	public int addProductByEmp(Product product)throws BusinessException;
	
	public Employee getEmpByEmailId(String email)throws BusinessException;
}
