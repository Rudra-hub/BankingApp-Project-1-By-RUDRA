package com.project.dao;

import java.util.List;

import com.project.model.Customer;
import com.project.model.Employee;

public interface EmployeeDAO {
	
	public int addEmployee(Employee employee);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean isCustomerExists(int customerId);
	public boolean isEmployeeExists(int employeeId);
	public boolean valideEmployee(String emailId, String password);

}
