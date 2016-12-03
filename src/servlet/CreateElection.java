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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CreateElectionManager;

/**
 *
 * @author KevinC
 */
public class CreateElection extends HttpServlet {
        private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String officeName = request.getParameter("OfficeName");
            String isPartisanTrue = request.getParameter("RadioButton");
            String isPartisanFalse = request.getParameter("RadioButton");
            
            boolean isPartisan = false;
            
            if(isPartisanTrue.equals("True"))
            {
                isPartisan = true;
            }
            if(isPartisanFalse.equals("False"))
            {
                isPartisan = false;
            }
            

            boolean result = new CreateElectionManager().createElection(officeName, isPartisan);

            if(result) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/createElection.jsp");
            out.println("<br>");
            out.println("<center><b><font color=green>Successfully Created Election</font><b></center>");
            out.println("<br>");
            rd.include(request, response);
            }
            else
            {
              RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/createElection.jsp");  
              out.println("<center><br><font color=red>Failed to create Election</font></br></center>");  
              rd2.include(request, response);
            }
            
            
        }
    }

        */
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
                    String officeName = request.getParameter("OfficeName");
            String isPartisanTrue = request.getParameter("RadioButton");
            String isPartisanFalse = request.getParameter("RadioButton");
            
            //Null Checking
            boolean isNull = false;
            if(officeName == null || isPartisanTrue == null || isPartisanFalse == null)
            {
                isNull = true;
            }
            
            
            boolean isPartisan = false;
            
            if(isPartisanTrue.equals("True"))
            {
                isPartisan = true;
            }
            if(isPartisanFalse.equals("False"))
            {
                isPartisan = false;
            }
            

            boolean result = new CreateElectionManager().createElection(officeName, isPartisan);

            if(result) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/createElection.jsp");
            PrintWriter out= response.getWriter();
            out.println("<br>");
            out.println("<center><b><font color=green>Successfully Created Election</font></b></center>");
            out.println("<br>");
            rd.include(request, response);
            }
            if(isNull == true)
            {
              RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/createElection.jsp");  
              PrintWriter out2= response.getWriter();
              out2.println("<center><b><font color=red>Failed to create Election</font></b></center>");  
              rd2.include(request, response);
            }
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
