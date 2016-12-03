package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.UserLoginOfficer;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/Login")
public class LoginOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            /*
                                    if(username == null || password == null)
            {
			RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/officerlogin.jsp");
			PrintWriter out2= response.getWriter();
                        out2.println("<html>");
                        out2.println("<br>");
			out2.println("<center><font color=red>Username or Password Field is Empty</font></center>");
                        out2.println("<br>");
                        out2.println("</html>");
			rd2.include(request, response);                          
            }
            
            */
            boolean result = new UserLoginOfficer().validate(username, password);
            

            
            if(result == true)
            {
                System.out.println("Logged in Successful");
            }
		
		if(result == true){
			Cookie loginCookie = new Cookie("officerusername",username);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.sendRedirect("choice.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/officerlogin.jsp");
			PrintWriter out= response.getWriter();
                        out.println("<html>");
                        out.println("<br>");
			out.println("<center><font color=red>Incorrect Username/Password or You are not an Officer</font></center>");
                        out.println("<br>");
                        out.println("</html>");
			rd.include(request, response);
		}

	}

}