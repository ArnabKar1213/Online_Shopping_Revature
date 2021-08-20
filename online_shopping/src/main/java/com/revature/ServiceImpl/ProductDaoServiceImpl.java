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
import com.revature.Service.ProductDaoService;
import com.revature.dao.ProductDao;
import com.revature.dao.impl.ProductDaoImpl;
import com.revature.model.Product;

public class ProductDaoServiceImpl implements ProductDaoService{

	 Logger log = Logger.getLogger(ProductDaoServiceImpl.class);
	 ProductDao productDao = new ProductDaoImpl();
	@Override
	public int addProduct(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
	
		c=productDao.addProduct(product);
		return c;
	}

	@Override
	public void getAllProducts() throws BusinessException {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		
		productDao.getAllProducts();
	}

	@Override
	public int getProductPrice(String p_name) throws BusinessException {
		// TODO Auto-generated method stub
		int pro_price=0;
	
		pro_price=productDao.getProductPrice(p_name);
		return pro_price;
		}

	@Override
	public int existsProduct(String p_name) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		c=productDao.existsProduct(p_name);
		return c;
	}
	
	
}
