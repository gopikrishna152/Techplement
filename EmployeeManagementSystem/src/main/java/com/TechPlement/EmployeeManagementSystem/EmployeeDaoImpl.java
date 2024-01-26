package com.TechPlement.EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl  implements EmployeeDaoInterf{ 
		Connection con;
	 
	 @Override
		public void createEmployee(Employee emp) {
			// TODO Auto-generated method stub   
		 con=DBConnection.createDBConnection();
		 String query="insert into employee values(?,?,?,?)";
		 try {
			PreparedStatement ps=con.prepareStatement(query);  
			ps.setInt(1, emp.getId()); 
			ps.setString(2, emp.getName()); 
			ps.setDouble(3, emp.getSalary()); 
			ps.setInt(4, emp.getAge());
			int count=ps.executeUpdate();
			if(count!=0) {
				System.out.println("*Employee inserted successfully*");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 
	 }

	

	@Override
	public void showAllEmployee() {
		// TODO Auto-generated method stub 
		Connection con=DBConnection.createDBConnection();  
		String query="select * from employee"; 
		System.out.println("Employee Details"); 
		System.out.format("%s\t %s \t %s \t %s\n","ID","Name","Salary","Age"); 
		System.out.println("====================================================");
		try {
			Statement stm=con.createStatement(); 
			 ResultSet rs=stm.executeQuery(query); 
			 while(rs.next()) {
				 System.out.format("%d\t %s \t %f \t %d", rs.getInt(1),
						 rs.getString(2),rs.getDouble(3),rs.getInt(4)
						 );  
				 System.out.println();
//				 System.out.println("----------------------------------------------------");
			 }
			 System.out.println("----------------------------------------------------");
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

	@Override
	public void showEmployeeById(int id) {
		// TODO Auto-generated method stub 
		Connection con=DBConnection.createDBConnection();   
		String query="select * from employee where id=?"; 
		
		try {
			PreparedStatement ps=con.prepareStatement(query); 
			ps.setInt(1, id); 
			ResultSet rs=ps.executeQuery();  
				System.out.println("Employee Details"); 
				System.out.format("%s\t %s \t %s \t %s\n","ID","Name","Salary","Age"); 
				System.out.println("====================================================");
//				String format = "| %-4s | %-10s | %-14.6f | %-3s |%n";
			 while(rs.next()) {
				 System.out.format("%d\t %s \t %f \t %d", rs.getInt(1),
						 rs.getString(2),rs.getDouble(3),rs.getInt(4)
						 ); 
				 System.out.println();
			 }
			 System.out.println("----------------------------------------------------"); 
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void updateEmployee(int id,String name,Double sal,int age) {
		// TODO Auto-generated method stub  
		Connection con=DBConnection.createDBConnection();  
		String query="update employee set name=?, salary=?, age=? where id=?"; 
		try {
			PreparedStatement ps=con.prepareStatement(query); 
			ps.setInt(4, id); 
			ps.setString(1, name); 
			ps.setDouble(2, sal); 
			ps.setInt(3, age);
			int res=ps.executeUpdate(); 
			if(res>0) {
				System.out.println("Updated Successful!!!!");
			}
			else {
				System.out.println("Unable to update the employee--->Failed");
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub  
		Connection con=DBConnection.createDBConnection();  
		String query="delete from employee where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			int res=ps.executeUpdate(); 
			if(res>0) {
				System.out.println("Deleted successfully!!");
			}
			else {
				System.out.println("Error Occured Not deleted");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	
	
}
