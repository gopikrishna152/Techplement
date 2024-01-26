package com.TechPlement.EmployeeManagementSystem;

public interface EmployeeDaoInterf { 
	
	public void createEmployee(Employee emp);
	public void showAllEmployee(); 
	public void showEmployeeById(int id);
//	public void updateEmployee(int id); 
	public void deleteEmployee(int id);
	public void updateEmployee(int id, String name, Double sal, int age); 
	

}
