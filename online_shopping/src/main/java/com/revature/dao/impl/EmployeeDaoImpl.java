package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.dbutil.MySqlDBConnection;
import com.app.exception.BusinessException;
import com.revature.dao.EmployeeDao;
import com.revature.dao.ProductDao;
import com.revature.model.Product;

public class EmployeeDaoImpl implements EmployeeDao {
	Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	@Override
	public boolean validEmpEmail(String emp_email) throws BusinessException {
		try(Connection connection=MySqlDBConnection.getConnection()){
			String sql="select emp_emailId from employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			while(resultSet.next()) {
				if(emp_email.matches(resultSet.getString("emp_emailId")))
					return true;
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact your System administrator");
		}
		return false;
		
	}
/*
 public Player getPlayerById(int id) throws BusinessException {
		Player player=null;
		try(Connection connection=MySqlDBConnection.getConnection()){
			String sql="select p.id,name,age,city,gender,sportsName,contact,teamName,teamId from player p JOIN team t on p.teamid=t.id where p.id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				player=new Player();
				player.setId(id);
				player.setName(resultSet.getString("name"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setSportsName(resultSet.getString("sportsName"));
				player.setContact(resultSet.getLong("contact"));
				Team team=new Team();
				team.setId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("teamName"));
				player.setTeam(team);
			}else {
				throw new BusinessException("Entered player id "+id+" doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		//System.out.println(player);
		return player;
	}

 */
	@Override
	public boolean validEmpPass(String emp_pass) throws BusinessException {
		try(Connection connection=MySqlDBConnection.getConnection()){
			String sql="select emp_pass from employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			while(resultSet.next()) {
				if(emp_pass.matches(resultSet.getString("emp_emailPass")))
					return true;
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact your System administrator");
		}
		return false;
		
		
	}

	@Override
	public int markStatus(int order_id) throws BusinessException {
		int status;
		try(Connection connection=MySqlDBConnection.getConnection()){
			String sql="update orders set o_status=? where o_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,"Shipped");
			preparedStatement.setInt(2,order_id);
		    status= preparedStatement.executeUpdate();
			}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact your System administrator");
		}
		
		return status;
	}

	@Override
	public int addProductByEmp(Product product)throws BusinessException{
		int c=0;
		try {
		ProductDao productDao = new ProductDaoImpl();
		c=productDao.addProduct(product);
		} 
		
		catch (BusinessException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact your System administrator");
		}
		return c;
	}
	}
	
	
	

