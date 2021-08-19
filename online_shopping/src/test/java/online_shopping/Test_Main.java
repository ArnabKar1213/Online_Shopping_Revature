package online_shopping;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.revature.dao.CustomerSearchDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.impl.CustomerSearchDaoImpl;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.model.Customer;
import com.revature.model.Employee;
class Test_Main {
	static Logger log = Logger.getLogger(Test_Main.class);
	static Scanner scanner =new Scanner(System.in);
	static String cus_emailId="";
	static String em_emailId="";
	static CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();
	static EmployeeDao employeeDao = new EmployeeDaoImpl();
	static Customer customer;
	static Employee employee;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//final CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();
		int choice=0;
		
				log.info("Please Enter the email Id of Customer\n");
				cus_emailId=scanner.next();
				try {
				customer=customerSearchDao.searchByEmailId(cus_emailId);
				}
				catch(BusinessException e) {
					log.warn(e.getMessage());
			}
				
		
				log.info("Please Enter the email Id of Employee\n");
				em_emailId=scanner.next();
				try {
					employee=employeeDao.getEmpByEmailId(em_emailId);
				}
				catch(BusinessException e) {
					log.warn(e.getMessage());
				}
			
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCusFname()throws BusinessException{
		
		//CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();
		//Customer customer=customerSearchDao.searchByEmailId("murray@gmail.com");
		
		
		//Test_Case 1
		Assertions.assertEquals("Andy", customer.getC_fname(),"fail");
		
		
	}
	
	@Test
	void testCusLname() throws BusinessException{
		//Test_Case 2
		Assertions.assertEquals("Murray", customer.getC_lname(),"fail");
	}
	@Test
	void testCusEmail() throws BusinessException{
		//Test_Case 3
		Assertions.assertEquals("murray@gmail.com", customer.getC_emailId(),"fail");
	}
	@Test
	void testCusId() throws BusinessException{
		//Test_Case 4
		Assertions.assertEquals(3, customer.getC_id(),"fail");
	}
	@Test
	void testEmpFname()throws BusinessException{
		//Test_Case 5
		Assertions.assertEquals("Arnab", employee.getEmp_fname(),"fail");	
	}
	
	@Test
	void testEmpLname() throws BusinessException{
		//Test_Case 6
		Assertions.assertEquals("Kar", employee.getEmp_lname(),"fail");
	}
	@Test
	void testEmpEmail() throws BusinessException{
		//Test_Case 7
		Assertions.assertEquals("arnab@onlineshopping.com", employee.getEmp_emailId(),"fail");
	}
	@Test
	void testEmpId() throws BusinessException{
		//Test_Case 8
		Assertions.assertEquals(1, employee.getEmp_id(),"fail");
	}
}
