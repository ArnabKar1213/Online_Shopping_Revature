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
	
	@Override
	public int addCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		
		try(Connection connection=MySqlDBConnection.getConnection()){
			String sql="insert into customer(c_fname,c_lname,c_emailId,c_pass)values(?,?,?,?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);		
					preparedStatement.setString(1,customer.getC_fname());
					preparedStatement.setString(2,customer.getC_lname());
					preparedStatement.setString(3,customer.getC_emailId());
					preparedStatement.setString(4,customer.getC_pass());
					c =  preparedStatement.executeUpdate();				
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException  ("Internal error occured contact your System administrator");
			}
		return c;
	}

	@Override
	public int addToCart(Product product, Customer customer, int pro_price) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerDao customerDao= new CustomerDaoImpl();
		try {
		customerDao.addToCart(product,customer,pro_price);
		}
		catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return 0;
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
	
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select emp_pass from customer where c_emailId=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1,email);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					getPass=resultSet.getString("c_pass");
				}
				if(getPass==null) {
					log.info("Invalid email id");
					res=1;
				}
		}
				catch(ClassNotFoundException | SQLException e) {
					log.error(e);
					throw new BusinessException("Internal error occured , kindly contact your system administrator");
				}
		return getPass;
	}

	@Override
	public void viewOrder(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		List<Order> orderList= new ArrayList<>();
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select o_status,o_id from orders where oc_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,customer.getC_id());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Order order = new Order();
				order.setO_status(resultSet.getString("o_status"));
				order.setO_id((resultSet.getInt("o_id")));
				orderList.add(order);
			}
			for(Order order:orderList) {
				System.out.println(order);
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
	}

}
