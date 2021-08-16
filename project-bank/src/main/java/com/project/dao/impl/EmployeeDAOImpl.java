package com.project.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.EmployeeDAO;
import com.project.model.Customer;
import com.project.model.Employee;
import com.project.util.HibernateUtil;


public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger logger = Logger.getLogger("CustomerDAOImpl");
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	@Override
	public int addEmployee(Employee employee) {
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		int employeeId=employee.getEmployeeId();
		transaction.commit();
		return employeeId;
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
		Query query = session.createQuery("from com.revature.pms.model.Customer");
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
	public boolean isEmployeeExists(int employeeId) {
		Employee employee =  (Employee) session.get(Employee.class, employeeId);
		if(employee ==null)
			return false;
		else
			return true;
	}
	
	@Override
	public boolean valideEmployee(String emailId, String password) {
		Query query = session.createQuery("from com.project.model.Employee where emailId ='"+emailId+"' and password ='"+password+"'");
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
