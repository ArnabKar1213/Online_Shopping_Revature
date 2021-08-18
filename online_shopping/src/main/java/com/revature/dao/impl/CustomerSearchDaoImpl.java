package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.dbutil.MySqlDBConnection;
import com.app.exception.BusinessException;
import com.revature.dao.CustomerSearchDao;
import com.revature.model.Customer;

public class CustomerSearchDaoImpl implements CustomerSearchDao {
	Logger log= Logger.getLogger(CustomerSearchDaoImpl.class);
      
	public Customer searchByOrderId(int orderId)throws BusinessException{
		Customer customer= new Customer();
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select c_id,c_fname,c_lname,c_emailId,c_pass from customer inner join cart"
					+ " on customer.c_id=cart.cus_id where cart.or_id=";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,orderId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer.setC_id((resultSet.getInt("c_id")));
				customer.setC_fname(resultSet.getString("c_fname"));
				customer.setC_lname(resultSet.getString("c_lname"));
				customer.setC_emailId(resultSet.getString("c_emailId"));
				customer.setC_pass(resultSet.getString("c_pass"));
			}
			System.out.println(customer);		
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
		
	
		//throw new BusinessException("Entered order id "+order_Id+" doesnt exist");
		
		return null;
}

	
	public List<Customer> searchByFname(String fname)throws BusinessException{
		List<Customer> cusList= new ArrayList<>();
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select c_id,c_fname,c_lname,c_emailId,c_pass from customer where c_emailId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,fname);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setC_id((resultSet.getInt("c_id")));
				customer.setC_fname(resultSet.getString("c_fname"));
				customer.setC_lname(resultSet.getString("c_lname"));
				customer.setC_emailId(resultSet.getString("c_emailId"));
				customer.setC_pass(resultSet.getString("c_pass"));
				cusList.add(customer);
			}
			for(Customer customer:cusList)
				System.out.println(customer);
			
			
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
		return cusList;
	}
	
	public List<Customer> searchByLname(String lname)throws BusinessException{
		List<Customer> cusList= new ArrayList<>();
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select c_id,c_fname,c_lname,c_emailId,c_pass from customer where c_lname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,lname);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setC_id((resultSet.getInt("c_id")));
				customer.setC_fname(resultSet.getString("c_fname"));
				customer.setC_lname(resultSet.getString("c_lname"));
				customer.setC_emailId(resultSet.getString("c_emailId"));
				customer.setC_pass(resultSet.getString("c_pass"));
				cusList.add(customer);
			}
			for(Customer customer:cusList)
				System.out.println(customer);
			
			
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
		return cusList;
	}
	
	public Customer searchByEmailId(String email)throws BusinessException{
		Customer customer = new Customer();
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select c_id,c_fname,c_lname,c_emailId,c_pass from customer where c_emailId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer.setC_id((resultSet.getInt("c_id")));
				customer.setC_fname(resultSet.getString("c_fname"));
				customer.setC_lname(resultSet.getString("c_lname"));
				customer.setC_emailId(resultSet.getString("c_emailId"));
				customer.setC_pass(resultSet.getString("c_pass"));
			}
			
			
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
		return customer;
	}


	@Override
	public Customer searchById(int customer_id) throws BusinessException {
		Customer customer = new Customer();
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select c_id,c_fname,c_lname,c_emailId,c_pass from customer where c_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,customer_id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer.setC_id((resultSet.getInt("c_id")));
				customer.setC_fname(resultSet.getString("c_fname"));
				customer.setC_lname(resultSet.getString("c_lname"));
				customer.setC_emailId(resultSet.getString("c_emailId"));
				customer.setC_pass(resultSet.getString("c_pass"));
			}
			
			
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
		
		return customer;
	}
	
}
