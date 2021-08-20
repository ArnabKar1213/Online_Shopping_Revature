package com.revature.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.revature.model.Product;

public interface ProductDao {

	
	public int addProduct(Product product)throws BusinessException;
	
	public void getAllProducts()throws BusinessException;
	
	public int getProductPrice(String p_name)throws BusinessException;

	public int existsProduct(String p_name) throws BusinessException;
	
}
