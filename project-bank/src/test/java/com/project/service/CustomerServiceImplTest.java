package com.project.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.project.model.Customer;
import com.project.dao.CustomerDAO;
import com.project.dao.impl.CustomerDAOImpl;



public class CustomerServiceImplTest {
	CustomerService customerService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customerService = new CustomerServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCustomer() {
//		Customer customer = new Customer(14,"Arun2","886720533", "tufailahmedkha@gmail.com", 5000, "neha@123t", new Date());
//		assertEquals(14, customerService.addCustomer(customer));
	}

	@Test
	public void testDeleteCustomer() {
//		int customerId=2;
//		
//		assertEquals(true, customerService.deleteCustomer(customerId));
	}

	@Test
	public void testDeposit() {
//		int customerId=3;
//		int amount=20;
//		assertEquals(true, customerService.withdraw(customerId,amount));
		
	}

	@Test
	public void testWithdraw() {
//		int customerId=3;
//		int amount=20;
//		assertEquals(true, customerService.withdraw(customerId,amount));
	}

	@Test
	public void testTransferAmount() {
//		int senderId=1;
//		int receiverId=3;
//		int amount=1;
//		assertEquals(true, customerService.transferAmount(senderId, receiverId, amount));
	}

	@Test
	public void testValideCustomer() {
//		String emailId="r@gamil.com";
//		String password="pass";
//		assertEquals(true, customerService.valideCustomer(emailId, password));
	}

}
