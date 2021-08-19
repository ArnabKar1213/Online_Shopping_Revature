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
import com.revature.dao.CustomerDao;
import com.revature.model.Cart;
import com.revature.model.Customer;
import com.revature.model.Order;
import com.revature.model.Product;

public class CustomerDaoImpl implements CustomerDao {
	Logger log = Logger.getLogger(CustomerDaoImpl.class);
	@Override
	public int addCustomer(Customer customer) throws BusinessException {
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
	public int addToCart(Product product,Customer customer,int pro_price) throws BusinessException {
		int c=0,d=0;
		System.out.println(product.getP_name());
		System.out.println(pro_price);
		//System.out.println(customer.getC_id());
		try(Connection connection=MySqlDBConnection.getConnection()){
			String sql="insert into cart(cp_name,cp_price,cus_id)values(?,?,?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1,product.getP_name());
			 preparedStatement.setInt(2,pro_price);
			 preparedStatement.setInt(3,customer.getC_id()); 
			 c=preparedStatement.executeUpdate(); 
		}
		catch(ClassNotFoundException | SQLException e) {
		log.error(e);
		//e.printStackTrace();
		throw new BusinessException  ("Internal error occured");
		}
		return c;
	}

	@Override
	public int placeOrder(int crP_id,Customer customer) throws BusinessException {
		int r;
		try(Connection connection=MySqlDBConnection.getConnection()){
			String sql="insert into orders(o_status,o_id,oc_id) values(?,?,?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1,"Processing");
			 preparedStatement.setInt(2,crP_id);
			 preparedStatement.setInt(3,customer.getC_id());
			 r=preparedStatement.executeUpdate();
			 
			 sql="delete from cart where or_id = ?";
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setInt(1,crP_id);
			 preparedStatement.executeUpdate();	 
			 
		}
		
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException  ("Internal error occured");
			}
		return r;
	}

	@Override
public List<Cart> showCart(Customer customer) throws BusinessException {
		
		List<Cart> cartList=new ArrayList<>();
	try(Connection connection = MySqlDBConnection.getConnection()){
		String sql = "select or_id,cp_name,cp_price,cus_id from cart where cus_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,customer.getC_id());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Cart cart = new Cart();
				cart.setCrP_id((resultSet.getInt("or_id")));
				cart.setCp_name(resultSet.getString("cp_name"));
				cart.setCp_price(resultSet.getInt("cp_price"));
				cart.setCus_id(resultSet.getInt("cus_id"));
				cartList.add(cart);
			}
			for(Cart cart:cartList) {
				System.out.println(cart);
			}
int totalPriceCart=cartList.stream().map(e -> e.getCp_price()).reduce(0,(sum, element) -> sum + element);
				System.out.println("Total : "+ totalPriceCart);
		}
	catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
		return cartList;
	}

	@Override
	public String validEmail(String email) throws BusinessException {
		String getPass=null;
		int res=0;
	
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select c_pass from customer where c_emailId=?";
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
