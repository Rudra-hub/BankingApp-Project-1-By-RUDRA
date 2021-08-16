package com.project.authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.service.EmployeeService;
import com.project.service.EmployeeServiceImpl;







/**
 * Servlet implementation class DeleteByIdServlet
 */
public class DeleteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		 response.setContentType("text/html");
	     PrintWriter out=response.getWriter();

	     EmployeeService employeeService=new EmployeeServiceImpl();
			employeeService.deleteCustomer(customerId);
			
			
			out.println("<br/><br/><br/><h3 align=center> Customer for Customer ID:"+" "+customerId+"  "+"deleted Succesfully");
			out.println("<br><br><a href=EmployeeAccess.html>Back</a>");
			out.print("<a href=\"LogoutServlet\"><button class=\"button\">Logout</button></a>");
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
