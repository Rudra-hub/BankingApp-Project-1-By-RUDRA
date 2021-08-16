<%@page import="com.project.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='background-color:ghostwhite ;'>
	<h2 align="center">Customer details</h2>
	<%
	List<Customer> customers = (List<Customer>) session.getAttribute("allCustomers");
	%>
	<table align="center">
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Balance</th>
		<th>Registration Date</th>
		<%
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
		%>
		<tr>
			<td><%= customer.getCustomerId() %></td>
			<td><%= customer.getCustomerName() %></td>
			<td><%= customer.getEmailId() %></td>
			<td><%= customer.getMobileNumber() %></td>
			<td><%= customer.getBalance() %></td>
			<td><%= customer.getRegistrationDate() %></td>
		</tr>
		<%
		}
		%>

	</table>
	<a href=EmployeeAccess.html>Back</a>
</body>
</html>