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
 * Servlet implementation class TransferServlet
 */
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		int receiverId= Integer.parseInt(request.getParameter("receiverId"));
		int amount= Integer.parseInt(request.getParameter("amount"));
		CustomerService customerService = new CustomerServiceImpl();
		customerService.transferAmount(senderId,receiverId,amount);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("TransferAmount.html");
//		dispatcher.forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("<h3 align=\'center' style=\'background-color:aqua;\'>Amount "+amount+" Transfered Successfully</h3>");
		out.println("<br><br><a href=CustomerAccess.html align=\'center'>Back</a>                                                     ");
		out.print("<a href=\"LogoutServlet\"><button class=\"button\">Logout</button></a>");
	}

}
