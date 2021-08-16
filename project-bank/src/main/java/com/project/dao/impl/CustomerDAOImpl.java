package com.project.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.CustomerDAO;
import com.project.model.Customer;
import com.project.util.HibernateUtil;


public class CustomerDAOImpl implements CustomerDAO {
	
	private static Logger logger = Logger.getLogger("CustomerDAOImpl");

	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	@Override
	public int  addCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		int customerId=customer.getCustomerId();
		transaction.commit();
		return customerId;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		session.delete(customer);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.update(customer);
		transaction.commit();
		return true;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer =  (Customer) session.load(Customer.class, customerId);
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		Query query = session.createQuery("from com.project.model.Customer");
		List<Customer> customers = query.list();
		System.out.println(customers);
		return customers;
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		Customer customer =  (Customer) session.get(Customer.class, customerId);
		if(customer ==null)
			return false;
		else
			return true;
	}

	@Override
	public int viewBalance(int customerId) 
	{
		Query query = session.createQuery("select amount from Customer where customerId = "+customerId);
		int balance = (int) query.list().get(0);
		logger.info("The balance for :"+customerId + " is "+balance);
		return balance;
	}

	@Override
	public boolean deposit(int customerId,int amount) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update com.project.model.Customer set balance=balance+"+amount+"where customerId="+customerId);
		query.executeUpdate();
		transaction.commit();
		return true;
		
	}

	@Override
	public boolean withdraw(int customerId,int amount) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update com.project.model.Customer set balance=balance-"+amount+"where customerId="+customerId);
		query.executeUpdate();
		transaction.commit();
		return true;
	}

	@Override
	public boolean transferAmount(int senderId, int receiverId, int amount) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update com.project.model.Customer set balance=balance-"+amount+"where customerId="+senderId);
		Query query1 = session.createQuery("update com.project.model.Customer set balance=balance+"+amount+"where customerId="+receiverId);
		query.executeUpdate();
		query1.executeUpdate();
		transaction.commit();
		return true;
	}

	@Override
	public boolean valideCustomer(String emailId, String password) {
		Query query = session.createQuery("from com.project.model.Customer where emailId='"+emailId+"' and password ='"+password+"'");
        if (query.list().size() == 0)
        {
          return false;
        }
        else
        {
          return true;
        }
		}
	}

	


