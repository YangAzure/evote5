/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.RegistrationModel;
import javax.servlet.RequestDispatcher;
import persistence.CreateUser;

/**
 *
 * @author kevincheng
 */
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String username = request.getParameter("Username");
            String firstname = request.getParameter("FirstName");
            String lastname = request.getParameter("LastName");
            String email = request.getParameter("Email");
            String address = request.getParameter("Address");
            String age = request.getParameter("Age");
            String password = request.getParameter("Password");
            String confirmpassword = request.getParameter("ConfirmPassword");
            
            boolean missingfields = false;
          /*  
            if(username != null && firstname != null && lastname != null && email != null && address != null && age != null && password != null
                    && confirmpassword != null)
            {
                missingfields = true;
                                        RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/registration.jsp");
			PrintWriter out2= response.getWriter();
                        out2.println("<html>");
                        out2.println("<br>");
			out2.println("<center><font color=red>One or more Missing fields</font></center>");
                        out2.println("<br>");
                        out2.println("</html>");
			rd2.include(request, response);  
            } else
            {
            */
            
            boolean passwordcheck = false; 
            boolean result = false;
            int ageInt = 0;
            boolean ageCheck = false;
            
                          try{
               ageInt = Integer.parseInt(age);
               if(ageInt <= 0 || age == null)
               {
                   ageCheck = false;
                   out.println("<h1>Error, Age input Incorrect</h1>");
               } else {
                   ageCheck = true;
               }
                             } catch(NumberFormatException e) {
                          ageCheck = false;
                          out.println("<h1>Error, with your Registration, Please try Again.</h1>");
                          //out.println("Incorrect Number of Shares Entered");
                          }
            
            if(!(password.equals(confirmpassword)))
            {
                passwordcheck = false;
            } else 
            {
                passwordcheck = true;
            }
            
            if(passwordcheck == true)
            {
                result = new CreateUser().createUser(username, password, email, address, age, firstname, lastname);
             
            } 
            
            //else {
                

                /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error. Please make sure both passwords are the same.</h1>");
            out.println("</body>");
            out.println("</html>");
*/                
          //  }
          

          
            
          //  if(ageCheck == false)
          //  {
        //        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
	//		PrintWriter out2= response.getWriter();
          //              out2.println("<html>");
            //            out2.println("<br>");
		//	out2.println("<center><font color=red>Incorrect Age</font></center>");
                  //      out2.println("<br>");
                    //    out2.println("</html>");
			//rd.include(request, response);
                /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error, Age input Incorrect</h1>");
            out.println("</body>");
            out.println("</html>"); 
                */
       //     } else
          //  {
                if(passwordcheck == false || ageCheck == false)
                {
                         //RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/registration.jsp");
			//PrintWriter out3= response.getWriter();
                        out.println("<html>");
                        out.println("<br>");
			out.println("<center><font color=red>Passwords do not Match</font></center>");
                        out.println("<br>");
                        out.println("</html>");
			//rd.include(request, response);
                }
           // }
            /*
            if(result == false)
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error</h1>");
            out.println("</body>");
            out.println("</html>");                
            } */
            
            
            if(result == true && passwordcheck == true && ageCheck == true) 
            {
                response.sendRedirect("registersuccess.jsp");
                /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thank you for registering " + firstname + "</h1>");
            out.println("<input type=\"button\" value=\"Back\" onclick=\"javascript:history.go(-2)\">");
            out.println("</body>");
            out.println("</html>");
                */
            }
            /*
                        RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/registration.jsp");
			PrintWriter out3= response.getWriter();
                        out3.println("<html>");
                        out3.println("<br>");
			out3.println("<center><font color=red>Passwords do not Match</font></center>");
                        out3.println("<br>");
                        out3.println("</html>");
			rd2.include(request, response); 
            
            */
            }
        //}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
