package com.project.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Customer;
import com.project.service.CustomerService;
import com.project.service.CustomerServiceImpl;



/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerName = request.getParameter("customerName");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailId = request.getParameter("emailId");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String password = request.getParameter("password");
		
		Customer customer = new Customer(0 , customerName, mobileNumber, emailId, balance, password, new Date());
		
		CustomerService customerService = new CustomerServiceImpl();
		customerService.addCustomer(customer);
		response.setContentType("text/html");
		response.getWriter().println("<h1 style=\"background-color: lightblue\" align=center>"+customerName + ", congrats you have successfully opened an account in our bank with balance of INR "+balance);
		response.getWriter().println("<form action=\"Home.html\" align=center>\r\n"
				+ "            <input type=\"submit\" style=\"color: #f70202\" value=\"Go_Back_to_Home_Page\" />\r\n"
				+ "        </form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
