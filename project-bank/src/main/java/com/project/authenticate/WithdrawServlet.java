package com.project.authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.service.CustomerService;
import com.project.service.CustomerServiceImpl;

/**
 * Servlet implementation class WithdrawServlet
 */
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int amount= Integer.parseInt(request.getParameter("amount"));
		CustomerService customerService = new CustomerServiceImpl();
		customerService.withdraw(customerId,amount);
		PrintWriter out = response.getWriter();
		out.println("<h3 align=\'center' style=\'background-color:aqua;\'>Amount "+amount+"Withdrawn Successfully</h3>");
		out.println("<br><br><a href=CustomerAccess.html>Back</a>                                                     ");
		out.print("<a href=\"LogoutServlet\"><button class=\"button\">Logout</button></a>");
	}

}
