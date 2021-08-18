package com.app.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {
	private static Connection connection=null;
	private MySqlDBConnection() {
		
	}
	public static Connection getConnection() throws ClassNotFoundException , SQLException {
		//try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		//System.out.println("Driver loaded successfully");
		//
		String url="jdbc:mysql://localhost:3306/online_shopping";
		String user="root";
		String pass="Mys199hkm@";
	
		//try {
			connection=DriverManager.getConnection(url,user,pass);
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		//System.out.println("Connection established");
			return connection;
		
	}
}
