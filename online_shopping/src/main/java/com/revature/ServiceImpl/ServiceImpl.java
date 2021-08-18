package com.revature.ServiceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.revature.Service.Service;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerSearchDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.ProductDao;
import com.revature.dao.impl.CustomerDaoImpl;
import com.revature.dao.impl.CustomerSearchDaoImpl;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.dao.impl.ProductDaoImpl;
import com.revature.model.Cart;
import com.revature.model.Customer;
import com.revature.model.Product;

public class ServiceImpl implements Service {
	
	Logger log = Logger.getLogger(ServiceImpl.class);
	@Override
	public int addCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addToCart(Product product, Customer customer, int pro_price) throws BusinessException {
		// TODO Auto-generated method stub
		
		CustomerDao customerDao= new CustomerDaoImpl();
		customerDao.addToCart(product,customer,pro_price);
		return 0;
	}

	@Override
	public int placeOrder(int crP_id) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerDao customerDao= new CustomerDaoImpl();
		//try {
		//customerDao.placeOrder(crP_id);
		//}
		//catch(BusinessException e) {
		//	log.warn(e.getMessage());
		//}
		return 0;
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
		return null;
	}

	@Override
	public Customer searchByOrderId(int orderId) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerSearchDao customersearchDao = new CustomerSearchDaoImpl();
		Customer customer=customersearchDao.searchByOrderId(orderId);

		return customer;
	}

	@Override
	public List<Customer> searchByFname(String fname) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerSearchDao customersearchDao = new CustomerSearchDaoImpl();
		try {
		customersearchDao.searchByFname(fname);
		}
		catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Customer> searchByLname(String lname) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerSearchDao customersearchDao = new CustomerSearchDaoImpl();
		try {
		customersearchDao.searchByLname(lname);
		}catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return null;
	}

	@Override
	public Customer searchByEmailId(String email) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerSearchDao customersearchDao = new CustomerSearchDaoImpl();
		try {
		customersearchDao.searchByEmailId(email);
		}catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean validEmpEmail(String emp_email) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validEmpPass(String emp_pass) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int markStatus(int order_Id) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		try {
		c=employeeDao.markStatus(order_Id);
		}
		catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		
		return c;
	}

	@Override
	public int addProductByEmp(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		EmployeeDao employeeDao= new EmployeeDaoImpl();
		int c=employeeDao.addProductByEmp(product);
		return c;
	}

	@Override
	public int addProduct(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getAllProducts() throws BusinessException {
		// TODO Auto-generated method stub
		ProductDao productDao = new ProductDaoImpl();
		try {
			productDao.getAllProducts();
			}
			catch(BusinessException e){
				log.warn(e.getMessage());
			}
		
	}

	@Override
	public int getProductPrice(String p_name) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		ProductDao productDao = new ProductDaoImpl();
		try {
		c=productDao.getProductPrice(p_name);
		}
		catch(BusinessException e){
			log.warn(e.getMessage());
		}
		return c;
	}

	@Override
	public Customer searchById(int customer_id) throws BusinessException {
		// TODO Auto-generated method stub
		CustomerSearchDao customersearchDao = new CustomerSearchDaoImpl();
		try {
		customersearchDao.searchById(customer_id);
		}catch(BusinessException e) {
			log.warn(e.getMessage());
		}
		return null;
	}

	@Override
	public void viewOrder() throws BusinessException {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		try {
		customerDao.viewOrder();
		}catch(BusinessException e) {
			log.warn(e.getMessage());
		}
	}
	
}
