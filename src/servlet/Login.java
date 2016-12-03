/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import persistence.UserLogin;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            
            /*
            if(username == null || password == null)
            {
			RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out2= response.getWriter();
                        out2.println("<html>");
                        out2.println("<br>");
			out2.println("<center><font color=red>Username or Password Field is Empty</font></center>");
                        out2.println("<br>");
                        out2.println("</html>");
			rd2.include(request, response);                        
            }
            */
            
            boolean result = new UserLogin().validate(username, password);
            
            if(result == true)
            {
                System.out.println("Logged in Successful");
            }
		
		if(result == true){
			Cookie loginCookie = new Cookie("username",username);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.sendRedirect("loggedsuccess.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
                        out.println("<html>");
                        out.println("<br>");
			out.println("<center><font color=red>Incorrect Username/Password</font></center>");
                        out.println("<br>");
                        out.println("</html>");
			rd.include(request, response);
		}

	}

}
/*


public class Login extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            
            boolean result = new UserLogin().validate(username, password);
            
            if(result == true)
            {
                System.out.println("Logged in Successful");
            }
              
		
		if(result == true){
			Cookie loginCookie = new Cookie("username",username);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
                        //RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginSuccess.jsp");
			//dispatcher.forward(request, response);
			//response.sendRedirect("/createDistrict/LoginSuccess.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			
			out.println("Username or Password is Incorrect");
			rd.include(request, response);
		}
                
            
     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
*/