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
import com.revature.Service.CustomerSearchDaoService;
import com.revature.dao.CustomerSearchDao;
import com.revature.dao.impl.CustomerSearchDaoImpl;
import com.revature.model.Customer;

public class CustomerSearchDaoServiceImpl implements CustomerSearchDaoService {

	Logger log = Logger.getLogger(CustomerDaoServiceImpl.class);
	CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();
	@Override
	public Customer searchByOrderId(int orderId) throws BusinessException {
		// TODO Auto-generated method stub
		Customer customer= new Customer();
		
		customerSearchDao.searchByOrderId(orderId);
		
		return null;
	}

	@Override
	public List<Customer> searchByFname(String fname) throws BusinessException {
		// TODO Auto-generated method stub
		List<Customer> cusList= new ArrayList<>();
		
		cusList=customerSearchDao.searchByFname(fname);
		return cusList;
	}

	@Override
	public List<Customer> searchByLname(String lname) throws BusinessException {
		// TODO Auto-generated method stub
		List<Customer> cusList= new ArrayList<>();
		
		cusList=customerSearchDao.searchByLname(lname);
		return cusList;
	}

	@Override
	public Customer searchByEmailId(String email) throws BusinessException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
	
		customer=customerSearchDao.searchByEmailId(email);
		return customer;
	}

	@Override
	public Customer searchById(int customer_id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
