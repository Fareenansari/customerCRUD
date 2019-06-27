<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.lti.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ page import=" java.util.List" %> --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession sessionObj= request.getSession(true);
	int timeout=20;
	sessionObj.setMaxInactiveInterval(timeout);
	response.setHeader("Refresh",timeout+"; URL=timeout.jsp");
%>

<a href="ViewCustomer.html">Add New Customer</a><br><br>
<h1>Customer List</h1>
<% List <Customer> list=customerDAO.getAllEmployees();%>
<table border=1 width="100%">
<tr>
<th>Customer Id</th>
<th>Customer Name</th>
<th>Password</th>
<th>EMail</th>
<th>Country</th>
<th>Edit</th>
<th>Delete</th>

</tr>
<% for(Customer i:list){ %>
<tr>
<td><%= i.getId() %></td>
<td><%= i.getName() %></td>
<td><%= i.getPassword() %></td>
<td><%= i.getEmail() %></td>
<td><%= i.getCountry() %></td>
<td><a href='EditCustomer.jsp?id=<%= i.getId() %> '>Edit</a></td>
<td><a href='DeleteServlet?id=<%= i.getId() %> '>Delete</a></td>


</tr>

<%} %>
</table>
</body>

</html>




