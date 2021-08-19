package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.revature.Service.CustomerDaoService;
import com.revature.Service.CustomerSearchDaoService;
import com.revature.Service.EmployeeDaoService;
import com.revature.Service.ProductDaoService;
import com.revature.ServiceImpl.CustomerDaoServiceImpl;
import com.revature.ServiceImpl.CustomerSearchDaoServiceImpl;
import com.revature.ServiceImpl.EmployeeDaoServiceImpl;
import com.revature.ServiceImpl.ProductDaoServiceImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerSearchDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.ProductDao;
import com.revature.dao.impl.CustomerDaoImpl;
import com.revature.dao.impl.CustomerSearchDaoImpl;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.dao.impl.ProductDaoImpl;
import com.revature.model.Customer;
import com.revature.model.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Logger log = Logger.getLogger(Main.class);
			log.info("=======================================================================");
			log.info("Hello User, Welcome to Arnab's Console Based Online Shopping App");
			log.info("=======================================================================");
			Scanner sc = new Scanner(System.in);
			int choice=0;
			CustomerDaoService customerDaoService = new CustomerDaoServiceImpl();
			CustomerSearchDaoService customerSearchDaoService = new CustomerSearchDaoServiceImpl();
			EmployeeDaoService employeeDaoService = new EmployeeDaoServiceImpl();
			ProductDaoService productDaoService = new ProductDaoServiceImpl();
			do {
			log.info("Enter 1 to login as an Employee\n");
			log.info("Enter 2 to login as an Customer\n");
			log.info("Enter 3 to register as a Customer\n");
			log.info("Enter 4 to exit\n");
			
			choice=sc.nextInt();
			
			switch(choice) {
			
				case 1:
					int choice1=0;
					String emp_email_Id,emp_password,getEmpPass=null;
					//boolean email;
					EmployeeDao empDao = new EmployeeDaoImpl();
					log.info("Enter your email id\n");
					emp_email_Id=sc.next();
					String emp_emailId1=emp_email_Id;
					try {
					getEmpPass=employeeDaoService.validEmpEmail(emp_email_Id);
					if(getEmpPass==null) {
					log.info("Enter \"Yes\" if you wish to continue \n");
					log.info("Enter \"No\" if you do not wish to continue\n");
					String c=sc.nextLine();
					if(c.equals("No")) {
						System.out.println("Thanks for using the Console-based app\n");
						System.exit(0);
					}
					if(c.equals("Yes"))
						continue;
					}
					
					while(true) {
					log.info("Enter your password\n");
					emp_password=sc.next();
					if(!(emp_password.equals(getEmpPass))) {
						log.info("Invalid Password\n");
						log.info("Enter \"Yes\" if you wish to continue \n");
						log.info("Enter \"No\" if you do not wish to continue\n");
						String c=sc.nextLine();
						if(c.equals("No")) {
							log.info("Thanks for using the Console-based app\n");
							System.exit(0);
						}
						else if(c.equals("Yes"))
						continue;
					}
					else if(emp_password.equals(getEmpPass))
						break;
					}
					}
					catch(BusinessException e){
						log.warn(e.getMessage());
					}
								
				/*	
					try {
					emp_email_Id=sc.nextLine();
					email=emp.validEmpEmail(emp_email_Id);
					if(!email)
						log.warn("Please enter correct username");
					}
					catch(BusinessException e) {
						log.warn(e.getMessage());
					}
					
					log.info("Enter your password\n");*/
					do {
					log.info("Welcome, what you want to do today?\n");
					
					log.info("Enter 1 to add a product\n");
					
					log.info("Enter 2 to search a customer\n");
					
					log.info("Enter 3 to mark the status of an order as shipped\n");
					
					log.info("Enter 4 to log out\n");
					//Service service = new ServiceImpl();
					try {
					choice1=sc.nextInt();
					}
					catch(NumberFormatException e) {
						
					}
					switch(choice1) {
						case 1:
								String pro_Name,pro_Category;
								int pro_Id,pro_Price,pro_Quantity;
								log.info("Enter the name of new product");
								pro_Name=sc.next();
								log.info("Enter the price of new product");
								pro_Price=sc.nextInt();
								log.info("Enter the category of new product");
								pro_Category=sc.next();
								log.info("Enter the quantity of new product");
								pro_Quantity=sc.nextInt();
								Product product = new Product(pro_Name,pro_Price,pro_Category,pro_Quantity);
					
								EmployeeDao employee= new EmployeeDaoImpl();
					//			Service service = new ServiceImpl();
								try {
									int c=employeeDaoService.addProductByEmp(product);
									if(c==1) 
										log.info("Product added successfully");
							
									else
										log.info("Try once again");
								}
								catch(BusinessException e){
									log.warn(e.getMessage());
								}
							break;
						case 2:
							int choiceSearch=0;
							do {
								
								log.info("Enter 1 to search by Order Id\n");
								
								log.info("Enter 2 to search by First name\n");
								
								log.info("Enter 3 to search by Last name \n");
								
								log.info("Enter 4 to search by Email id\n");
								
								log.info("Enter 5 if you want to do some other task\n");
								
								choiceSearch=sc.nextInt();
								
								switch(choiceSearch) {
									case 1:
										log.info("Enter the Order Id\n");
										int orderId=sc.nextInt();
										try {
											customerSearchDaoService.searchByOrderId(orderId);									}
										catch(BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
							       case 2:
										log.info("Enter the First name\n");
										String fname=sc.next();
										try {
											customerSearchDaoService.searchByFname(fname);
										}
										catch(BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
							      case 3:
										log.info("Enter the Last name\n");
										String lname=sc.next();
										try {
											customerSearchDaoService.searchByLname(lname);
										}
										catch(BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
							      case 4:
										log.info("Enter the Email Id\n");
										String emailId=sc.next();
										try {
											customerSearchDaoService.searchByEmailId(emailId);
										}
										catch(BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
							     
								 default:
									 break;
								}
								
							}while(choiceSearch!=5);
							break;
						case 3:
							int order_id=0;
							EmployeeDao employeeDao = new EmployeeDaoImpl();
							log.info("Dear employee please enter the order id\n");
							order_id=sc.nextInt();
							try {
							int status=employeeDaoService.markStatus(order_id);
							if(status==1) {
								log.info("Order Shipped");
							}
							}
							catch(BusinessException e) {
								log.warn(e.getMessage());
							}
							break;
						case 4:
							log.info("Thank you dear Employee\n");
							break;
						}
					}while(choice1!=4);
					//sc.nextLine();
					break;
					
				case 2:
					String cus_emailId1;
					int res;
					
					log.info("Dear customer,enter your email id\n");
					String cus_email_Id,cus_password,getPass=null;
					CustomerDao customerDao= new CustomerDaoImpl();
					cus_email_Id=sc.next();
					cus_emailId1=cus_email_Id;
					try {
					getPass=customerDaoService.validEmail(cus_email_Id);
					if(getPass==null) {
					log.info("Enter \"Yes\" if you wish to continue \n");
					log.info("Enter \"No\" if you do not wish to continue\n");
					String c=sc.next();
					if(c.equals("No")) {
						System.out.println("Thanks for shopping\n");
						System.exit(0);
					}
					if(c.equals("Yes"))
						continue;
					}
					
					while(true) {
					log.info("Enter your password\n");
					cus_password=sc.next();
					if(!(cus_password.equals(getPass))) {
						log.info("Invalid Password\n");
						log.info("Enter \"Yes\" if you wish to continue \n");
						log.info("Enter \"No\" if you do not wish to continue\n");
						String c=sc.next();
						if(c.equals("No")) {
							log.info("Thank you for shopping\n");
							System.exit(0);
						}
						else if(c.equals("Yes"))
						continue;
					}
					else if(cus_password.equals(getPass))
						break;
					}
					}
					catch(BusinessException e){
						log.warn(e.getMessage());
					}
								
					CustomerSearchDao customerSearchDao= new CustomerSearchDaoImpl();
					
					int ch;
					do {
						log.info("Welcome, what you want to do today?\n");
						
						log.info("Enter 1 to view the list of products available\n");
						
						log.info("Enter 2 to add a product to the cart\n");
						
						log.info("Enter 3 to view your cart\n");
						
						log.info("Enter 4 to place an order\n");
						
						log.info("Enter 5 to view your orders\n");
						
						log.info("Enter 6 to log out\n");
						
						ProductDao productDao = new ProductDaoImpl();
						
						ch=sc.nextInt();
						switch(ch) {
							case 1:
							try {
							//productDao.getAllProducts();
							productDaoService.getAllProducts();
							}
							catch(BusinessException e){
								log.warn(e.getMessage());
							}
							break;
						case 2:
							log.info("Enter the name of the product you want to add to the cart\n");
							String p_name;
							p_name=sc.next();
							Product addProductCart = new Product(p_name);
						//CustomerDao customerDao= new CustomerDaoImpl();
							int pro_price;
							while(true) {
								try {
									int c1;
									Customer customer=customerSearchDaoService.searchByEmailId(cus_emailId1);
									pro_price= productDao.getProductPrice(p_name);
									
									c1=customerDaoService.addToCart(addProductCart,customer,pro_price);
									if(c1==1) {
										log.info("Product added to cart successfully");
										break;
									}
									else if(c1!=1){
										log.info("Oops!....Please try again\n");
										log.info("Enter \"Yes\" if you wish to continue to add product to your cart\n");
										log.info("Enter \"No\" if you do not wish to continue\n");
										String c=sc.next();
										if(c.equals("No")) {
											ch=5;
											break;
										}
										else if(c.equals("Yes"))
											continue;
							
									}
							
								}
							catch(BusinessException e){
							log.warn(e.getMessage());
						    }
							
					     }
							break;
						case 3:
						//CustomerDao customerDaoc= new CustomerDaoImpl();
							try {
								Customer customer=customerSearchDao.searchByEmailId(cus_emailId1);
								customerDaoService.showCart(customer);
							}
							catch(BusinessException e){
							log.warn(e.getMessage());
							}
						
						break;
						//ch=Integer.parseInt(sc.nextLine());
						
						case 4:
							int crP_Id=0;
							log.info("Enter the respective product Id shown in the cart"
									+ " for the item you want to order\n");
							
							try {
								crP_Id=sc.nextInt();
								Customer customer=customerSearchDao.searchByEmailId(cus_emailId1);
								//int r=customerDao.placeOrder(crP_Id,customer);
								int r=customerDaoService.placeOrder(crP_Id,customer);
								
								if(r==1) {
									log.info("Congo...your order has been successfully placed");
								//break;
								}
								else {
									log.info("Oops!....Please try again\n");
									
								}	
							}
							catch(BusinessException e){
								log.warn(e.getMessage());
							}
						break;
						case 5:
							try {
							   Customer customer=customerSearchDao.searchByEmailId(cus_emailId1);
							   customerDaoService.viewOrder(customer);
							}
							catch(BusinessException e)
							{
								log.warn(e.getMessage());
							}
						break;
						default:
							break;
						
					   }
					}while(ch!=6);
					break;
				case 3:
					log.info("Enter your first name\n");
					int p;
					String cus_email_Id1,cus_password1,cus_fname,cus_lname;
					cus_fname=sc.next();
					log.info("Enter your last name\n");
					cus_lname=sc.next();
					while(true) {
						log.info("Enter your email id\n");
						cus_email_Id1=sc.next();
					if(customerDaoService.validEmailForNewCustomer(cus_email_Id1))
						break;
					else
						continue;
					}
					while(true) {
						log.info("Enter a password\n");
						cus_password1=sc.next();
						if(customerDaoService.validPasswordForNewCustomer(cus_password1))
							break;
						else
							continue;
						}
					Customer customer=new Customer(cus_fname,cus_lname,cus_email_Id1,cus_password1);
					CustomerDao customerDao1 = new CustomerDaoImpl();
					try {
					p=customerDaoService.addCustomer(customer);
					if(p==1) {
						log.info("You have successfully signed up");
					}
					}
					catch(BusinessException e) {
						log.warn(e.getMessage());
					}
					break;
				case 4:
					log.warn("Thank you for using the Console based application\n");
					break;
			}
			}while(choice!=4);
	}
	
			
}


