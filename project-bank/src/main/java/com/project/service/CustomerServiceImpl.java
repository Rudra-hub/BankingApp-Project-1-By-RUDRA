package com.project.service;

import java.util.List;

import com.project.dao.CustomerDAO;
import com.project.dao.impl.CustomerDAOImpl;
import com.project.model.Customer;


public class CustomerServiceImpl implements CustomerService {
	
	CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.isCustomerExists(customerId);
	}

	@Override
	public int viewBalance(int customerId) 
	{
		return customerDAO.viewBalance(customerId);
	}

	@Override
	public boolean deposit(int customerId,int amount) {
		// TODO Auto-generated method stub
		return customerDAO.deposit(customerId, amount);
	}

	@Override
	public boolean withdraw(int customerId,int amount) {
		// TODO Auto-generated method stub
		return customerDAO.withdraw(customerId,amount);
	}

	@Override
	public boolean transferAmount(int senderId, int receiverId, int amount) {
		// TODO Auto-generated method stub
		return customerDAO.transferAmount(senderId, receiverId, amount);
	}
	
	@Override
	public boolean valideCustomer(String emailId, String password) {
		// TODO Auto-generated method stub
		return customerDAO.valideCustomer(emailId, password);
	}

}
