import com.lti.*;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("NewCustomer").include(request,response);
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      String sid=request.getParameter("id");
      long id=Long.parseLong(sid);
      String name=request.getParameter("name");
      String password=request.getParameter("password");
      String email=request.getParameter("email");
      String country=request.getParameter("country");
      
      Customer e=new Customer();
      e.setId(id);
      e.setName(name);
      e.setPassword(password);
      e.setEmail(email);
      e.setCountry(country);
      
      int status=customerDAO.updateCustomer(e);
      if(status>0)
      {
    	  response.sendRedirect("ViewCustomer.jsp");
      }
      else
      {
    	  out.println("Sorry! unable to update record");
      }
      out.close();
      
      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
