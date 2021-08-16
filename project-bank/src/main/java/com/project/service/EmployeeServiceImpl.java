package com.project.service;

import java.util.List;
import com.project.dao.CustomerDAO;
import com.project.dao.impl.CustomerDAOImpl;
import com.project.dao.impl.EmployeeDAOImpl;
import com.project.model.Customer;
import com.project.model.Employee;
import com.project.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Override
	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}

	public boolean updateCustomer(Customer customer) {
		// TODO Autoenerated method stub
		return employeeDAO.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return employeeDAO.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return employeeDAO.getCustomers();
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		// TODO Auto-generated method stub
		return employeeDAO.isCustomerExists(customerId);
	}

	@Override
	public boolean isEmployeeExists(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.isCustomerExists(employeeId);
	}
	
	@Override
	public boolean valideEmployee(String emailId, String password) {
		// TODO Auto-generated method stub
		return employeeDAO.valideEmployee(emailId, password);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return employeeDAO.deleteCustomer(customerId);
	}



}
