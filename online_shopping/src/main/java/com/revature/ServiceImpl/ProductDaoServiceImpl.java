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
import com.revature.dao.impl.ProductDaoImpl;
import com.revature.model.Product;

public class ProductDaoServiceImpl implements ProductDaoService{

	 Logger log = Logger.getLogger(ProductDaoServiceImpl.class);
	@Override
	public int addProduct(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		try(Connection connection = MySqlDBConnection.getConnection()){
	
    String sql ="insert into product(p_id,p_name,p_price,p_category,p_quantity)values(?,?,?,?,?)";
    
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    
    preparedStatement.setInt(1, product.getP_id());
	preparedStatement.setString(2, product.getP_name());
	preparedStatement.setInt(3, product.getP_price());
	preparedStatement.setString(4, product.getP_category());
	preparedStatement.setInt(5, product.getP_quantity());
	
	

	c=preparedStatement.executeUpdate();
	
	
	}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);//This will be replaced by logger
			throw new BusinessException("Internal error occurred,please contact support");
		}
		return c;
	}

	@Override
	public void getAllProducts() throws BusinessException {
		// TODO Auto-generated method stub
List<Product> productList = new ArrayList<>();
		
		try(Connection connection = MySqlDBConnection.getConnection()){
			
			String sql="select p_id,p_name,p_price,p_category,p_quantity from product";
					
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet =  preparedStatement.executeQuery();
		while(resultSet.next()) {
			Product product=new Product();
			product.setP_id(resultSet.getInt("p_id"));
			product.setP_name(resultSet.getString("p_name"));
			product.setP_price(resultSet.getInt("p_price"));
			product.setP_category(resultSet.getString("p_category"));
			product.setP_quantity(resultSet.getInt("p_quantity"));
			
			productList.add(product);
			
		}
		for(Product product:productList)
			System.out.println(product);
			
		}
		catch(ClassNotFoundException | SQLException e) {
				//System.out.println(e);//This will be replaced by logger
				throw new BusinessException("Internal error occurred,please contact System administrator");
			}
		
	}

	@Override
	public int getProductPrice(String p_name) throws BusinessException {
		// TODO Auto-generated method stub
		int pro_price=0;
		try(Connection connection = MySqlDBConnection.getConnection()){
			
			String sql="select p_price from product where p_name=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,p_name);
			ResultSet resultSet =  preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				pro_price=resultSet.getInt("p_price");
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			//System.out.println(e);//This will be replaced by logger
			throw new BusinessException("Internal error occurred,please contact System administrator");
		}
		
		return pro_price;
		}
	
	
}
