package com.TechPlement.EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection { 
	static Connection con; 
	public static Connection createDBConnection() {  
		String url="jdbc:mysql://localhost:3306/employeeDB";
		String username="root";
		String pass="Gopi@911";
		
		
		
//		loading the driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con=DriverManager.getConnection(url, username, pass); 
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
