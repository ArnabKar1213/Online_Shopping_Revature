package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
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
			do {
			log.info("Enter 1 to login as an Employee\n");
			log.info("Enter 2 to login as an Customer\n");
			log.info("Enter 3 to register as a Customer\n");
			log.info("Enter 4 to exit\n");
			try {
			choice=Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				log.warn("Please enter valid number\n");
			}
			switch(choice) {
			
				case 1:
					int choice1=0;
					log.info("Enter your email id\n");
					String emp_email_Id,emp_password;
					//boolean email;
					EmployeeDao emp = new EmployeeDaoImpl();
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
					
					log.info("Enter 3 modify the status of an order\n");
					
					log.info("Enter 4 to log out\n");
					choice1=Integer.parseInt(sc.nextLine());
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
								try {
									int c=employee.addProductByEmp(product);
									if(c==1) 
										log.info("Product added successfully");
							
									else
										log.info("Try once again");
								}
								catch(BusinessException e){
									log.warn(e.getMessage());
								}
						case 2:
							
						case 3:
							int order_id=0;
							EmployeeDao employeeDao = new EmployeeDaoImpl();
							log.info("Dear employee please enter the order id\n");
							order_id=Integer.parseInt(sc.nextLine());
							try {
							int status=employeeDao.markStatus(order_id);
							if(status==1) {
								log.info("Order Shipped");
							}
							}
							catch(BusinessException e) {
								log.warn(e.getMessage());
							}
						}
					}while(choice1!=4);
					//try {
					//emp_password = sc.nextLine();
					//if(validEmpPass!=1)	
					//}
				//	catch(BusinessException e) {
					//	log.warn("Please enter correct password");
					//}
				case 2:
					String cus_emailId1;
					int res;
					
					log.info("Enter your email id\n");
					String cus_email_Id,cus_password,getPass=null;
					CustomerDao customerDao= new CustomerDaoImpl();
					cus_email_Id=sc.nextLine();
					cus_emailId1=cus_email_Id;
					try {
					getPass=customerDao.validEmail(cus_email_Id);
					if(getPass==null) {
					log.info("Enter \"Yes\" if you wish to continue \n");
					log.info("Enter \"No\" if you do not wish to continue\n");
					String c=sc.nextLine();
					if(c.equals("No")) {
						System.out.println("Thanks for shopping\n");
						System.exit(0);
					}
					if(c.equals("Yes"))
						continue;
					}
					
					while(true) {
					log.info("Enter your password\n");
					cus_password=sc.nextLine();
					if(!(cus_password.equals(getPass))) {
						log.info("Invalid Password\n");
						log.info("Enter \"Yes\" if you wish to continue \n");
						log.info("Enter \"No\" if you do not wish to continue\n");
						String c=sc.nextLine();
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
						
						log.info("Enter 5 to log out\n");
						
						ProductDao productDao = new ProductDaoImpl();
						
						ch=Integer.parseInt(sc.nextLine());
						switch(ch) {
						
							default:
							log.warn("Dear customer...to proceed , please enter a valid choice between 1-5\n");
						
							case 1:
							
							try {
							productDao.getAllProducts();
							}
							catch(BusinessException e){
								log.warn(e.getMessage());
							}
							
						case 2:
							log.info("Enter the name of the product you want to add to the cart\n");
							String p_name;
							p_name=sc.nextLine();
					//	Customer customer=new Customer("ABS","PQR","emailld","ayugg");
							Product addProductCart = new Product(p_name);
						//CustomerDao customerDao= new CustomerDaoImpl();
							int pro_price;
							while(true) {
								try {
									int c1;
									Customer customer=customerSearchDao.searchByEmailId(cus_emailId1);
									pro_price= productDao.getProductPrice(p_name);
									c1=customerDao.addToCart(addProductCart,customer,pro_price);
									if(c1==1) {
										log.info("Product added to cart successfully");
										break;
									}
									else {
										log.info("Oops!....Please try again\n");
										log.info("Enter \"Yes\" if you wish to continue to add product to your cart\n");
										log.info("Enter \"No\" if you do not wish to continue\n");
										String c=sc.nextLine();
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
						case 3:
						//CustomerDao customerDaoc= new CustomerDaoImpl();
							try {
								Customer customer=customerSearchDao.searchByEmailId(cus_emailId1);
								customerDao.showCart(customer);
							}
							catch(BusinessException e){
							log.warn(e.getMessage());
							}
						
						
						//ch=Integer.parseInt(sc.nextLine());
						
						case 4:
							int crP_Id=0;
							log.info("Enter the respective product Id shown in the cart"
									+ " for the item you want to order\n");
							try {
							crP_Id=Integer.parseInt(sc.nextLine());
							}
							catch(NumberFormatException e){
								log.warn("Enter a valid number\n");
							}
							//while(true) {
							try {
								Customer customer=customerSearchDao.searchByEmailId(cus_emailId1);
								int r=customerDao.placeOrder(crP_Id);
								if(r==1) {
									log.info("Congo...your order has been successfully placed");
								//break;
								}
								else {
									log.info("Oops!....Please try again\n");
									/*log.info("Enter \"Yes\" if you wish to continue to place an order\n");
									log.info("Enter \"No\" if you do not wish to continue\n");
									String c=sc.nextLine();
									if(c.equals("No"))
						        	break;
									else if(c.equals("Yes"))
										continue; */
									
								}
							
								
							}
							catch(BusinessException e){
								log.warn(e.getMessage());
							}
							
						}	
						
					}while(ch!=5);
				
					
					
				
					
				case 3:
					log.info("Enter your first name\n");
					int p;
					String cus_email_Id1,cus_password1,cus_fname,cus_lname;
					cus_fname=sc.nextLine();
					log.info("Enter your last name\n");
					cus_lname=sc.nextLine();
					log.info("Enter your email id\n");
					cus_email_Id1=sc.nextLine();
					log.info("Enter a password\n");
					cus_password1=sc.nextLine();
					Customer customer=new Customer(cus_fname,cus_lname,cus_email_Id1,cus_password1);
					CustomerDao customerDao1 = new CustomerDaoImpl();
					try {
					p=customerDao1.addCustomer(customer);
					if(p==1) {
						log.info("You have successfully signed up");
					}
					}
					catch(BusinessException e) {
						log.warn(e.getMessage());
					}
				default:
					log.warn("Hey...please enter a valid choice between 1-4\n");
			}
			}while(choice!=4);
	}
	
			
}


