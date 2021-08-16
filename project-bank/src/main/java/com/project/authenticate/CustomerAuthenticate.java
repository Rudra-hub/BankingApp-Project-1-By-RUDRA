package com.project.authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.service.CustomerService;
import com.project.service.CustomerServiceImpl;



/**
 * Servlet implementation class CustomerAuthenticate
 */
public class CustomerAuthenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static CustomerAuthenticate customerAuthenticate = new CustomerAuthenticate();

	public static CustomerAuthenticate getInstance() {
		return customerAuthenticate;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAuthenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
////		int customerId = Integer.parseInt(request.getParameter("customerId"));
//		String emailId = request.getParameter("emailId");
//		String password = request.getParameter("password");
//		
////		HttpSession session = request.getSession();
////		session.setAttribute("customerId", customerId);
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		CustomerService customerService = new CustomerServiceImpl();
//		if(customerService.valideCustomer(emailId, password)) 
//		{
////			out.println("<h2>You have logged in at : " + new java.util.Date());
////			out.println("Your EMAIL is : " + emailId);
//			out.println("<br><a href = ViewBalance.html>balance</a>");
//			out.println("<br><a href = DisplayAllCustomers.html>Delete Customer Data</a>");
//			out.println("<br><a href=\"LogoutServlet\">Logout</a>");
//			
//			
//		}else {
//		out.println("<br/><br/><a href=productForm.html>Add Product</a>");
//		
//		}
//		out.println("</body></html>");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		CustomerService customerService = new CustomerServiceImpl();
		if(customerService.valideCustomer(emailId, password)) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerAccess.html");
			dispatcher.forward(request, response);
			
		}else {
			out.println("<h1 align='center' style='color:red'>SOMETHING WENT WRONG. TRY AGAIN!!!</h1>");
		out.println("<br/><br/><h3 align='center'><a href=CustomerLoginForm.html>Back to Login Page</a></h3>");
		
		}
		out.println("</body></html>");
	}

}
