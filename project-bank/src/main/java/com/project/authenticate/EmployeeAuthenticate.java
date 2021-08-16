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
import com.project.service.EmployeeService;
import com.project.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeAuthenticate
 */
public class EmployeeAuthenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static EmployeeAuthenticate employeeAuthenticate = new EmployeeAuthenticate();

	public static EmployeeAuthenticate getInstance() {
		return employeeAuthenticate;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAuthenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		EmployeeService employeeService = new EmployeeServiceImpl();
		if(employeeService.valideEmployee(emailId, password))
		{
//			RequestDispatcher dispatcher = request.getRequestDispatcher("NewFile1.html");
//			dispatcher.forward(request, response);
//			out.println("<br><a href = DeleteCustomerById.html>Delete Customer Data</a>");
			out.println("<br><a href = DisplayAllDataServlet>Display all Customer Data</a>");
//			out.println("<br><a href = Registration.html>Registeration Access</a>");
			
			
		}else {
			out.println("<h1 align='center' style='color:red'>SOMETHING WENT WRONG. TRY AGAIN!!!</h1>");
			out.println("<br/><br/><h3 align='center'><a href=CustomerLoginForm.html>Back to Login Page</a></h3>");
		
		}
		out.println("</body></html>");
	}
}
