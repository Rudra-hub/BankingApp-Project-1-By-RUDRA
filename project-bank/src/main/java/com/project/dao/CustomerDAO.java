package com.project.dao;

import java.util.List;

import com.project.model.Customer;

public interface CustomerDAO {
	
	public int  addCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean isCustomerExists(int customerId);
	public int viewBalance(int customerId);
	public boolean deposit(int customerId,int amount);
	public boolean withdraw(int customerId,int amount);
	public boolean transferAmount(int senderId,int receiverId,int amount);
	public boolean valideCustomer(String emailId, String password);

}
