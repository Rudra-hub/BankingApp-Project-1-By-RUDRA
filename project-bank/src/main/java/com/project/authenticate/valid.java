package com.project.authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.service.CustomerService;
import com.project.service.CustomerServiceImpl;

/**
 * Servlet implementation class valid
 */
public class valid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public valid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		CustomerService customerService = new CustomerServiceImpl();
		if(customerService.valideCustomer(emailId, password)) 
		{
//			out.println("<h2>You have logged in at : " + new java.util.Date());
			out.println("Your EMAIL is : " + emailId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeAccess.html");
			dispatcher.forward(request, response);
//			out.println("<br><a href = DeleteCustomerById.html>Delete Customer Data</a>");
//			out.println("<br><a href = DisplayAllCustomers.html>Display all Customer Data</a>");
//			out.println("<br><a href = Registration.html>Registeration Access</a>");
			
			
		}else {
			out.println("<h1 align='center' style='color:red'>SOMETHING WENT WRONG. TRY AGAIN!!!</h1>");
			out.println("<br/><br/><h3 align='center'><a href=CustomerLoginForm.html>Back to Login Page</a></h3>");
		
		}
		out.println("</body></html>");
	}

	}

