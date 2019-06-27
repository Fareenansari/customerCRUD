package com.lti;


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String country=request.getParameter("country");
			
			Customer c=new Customer();
			c.setName(name);
			c.setPassword(password);
			c.setEmail(email);
			c.setCountry(country);
			
			int status=customerDAO.insertCustomer(c);  //customerDAO is class and insertCustomer is static method of the same class so we can call it through class name.
			if(status>0)								//c is passes to status
			{
				out.print("<p> Record Saved Successfully</p>");
				request.getRequestDispatcher("NewCustomer.html").include(request, response);
			}
			else
			{
				out.print("<p> Sorry!!! unable to save record</p>");
			}
			out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
