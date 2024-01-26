 
package com.TechPlement.EmployeeManagementSystem;

import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		System.out.println("***********************Welcome to Employee Management Application***********************");
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		Scanner sc=new Scanner(System.in);
		do { 
			System.out.println("1. Add Employee \n"+"2. Show All Employees \n"+"3. ShowEmployee By ID \n"+"4. Update the Employee  \n"+"5. Delete the  Employee \n"+"6. To exit");
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1: 
				Employee emp=new Employee(); 
				System.out.println("Enter the Id: ");
				int ide=sc.nextInt(); 
				System.out.println("Enter name: "); 
				String name=sc.next();
				System.out.println("Enter Salary: "); 
				Double sal=sc.nextDouble(); 
				System.out.println("Enter Age: ");
				int age=sc.nextInt();
				emp.setId(ide);
				emp.setName(name); 
				emp.setSalary(sal); 
				emp.setAge(age);
				
				 dao.createEmployee(emp);
				 break;
			case 2: 
				
				dao.showAllEmployee();
				break;
			case 3: 
				System.out.println("enter the Id of the employee");
				int id=sc.nextInt();
				dao.showEmployeeById(id); 
				break;
			case 4: 
				System.out.println("enter the Id of the employee to Update");
				int id1=sc.nextInt();  
				System.out.println("enter the name of employee"); 
				String name1=sc.next();
				System.out.println("enter the salary  of employee"); 
				Double sal1=sc.nextDouble(); 
				System.out.println("enter the age of employee"); 
				int age1=sc.nextInt();
				dao.updateEmployee(id1,name1,sal1,age1);
				break; 
			case 5:
				System.out.println("enter the Id of the employee to delete");
				int id2=sc.nextInt(); 
				
				dao.deleteEmployee(id2);
				break; 
			case 6:
				System.out.println("Thanks for using the employee Management System");
				
				return;
			default:
				System.out.println("Enter valid choice");
				
			}
			
			
			
		}
		while(true);
	}

}
