package com.revature.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.dbutil.MySqlDBConnection;
import com.app.exception.BusinessException;
import com.revature.Service.EmployeeDaoService;
import com.revature.dao.ProductDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.dao.impl.ProductDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Product;

public class EmployeeDaoServiceImpl implements EmployeeDaoService {

	Logger log = Logger.getLogger(EmployeeDaoServiceImpl.class);
	@Override
	public String validEmpEmail(String emp_email) throws BusinessException {
		// TODO Auto-generated method stub
		String getPass=null;
		int res=0;
	
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select emp_pass from employee where emp_emailId=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1,emp_email);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					getPass=resultSet.getString("emp_pass");
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
	public boolean validEmpPass(String emp_pass) throws BusinessException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	public int addProductByEmp(Product product) throws BusinessException {
		// TODO Auto-generated method stub
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

	@Override
	public Employee getEmpByEmailId(String email) throws BusinessException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		try(Connection connection = MySqlDBConnection.getConnection()){
			String sql = "select emp_id,emp_fname,emp_lname,emp_emailId,emp_pass from employee where emp_emailId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				employee.setEmp_id((resultSet.getInt("emp_id")));
				employee.setEmp_fname(resultSet.getString("emp_fname"));
				employee.setEmp_lname(resultSet.getString("emp_lname"));
				employee.setEmp_emailId(resultSet.getString("emp_emailId"));
				employee.setEmp_pass(resultSet.getString("emp_pass"));
			}
			System.out.println(employee);
			
			
		}
		catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured , kindly contact your system administrator");
		}
		return employee;
	}

}
