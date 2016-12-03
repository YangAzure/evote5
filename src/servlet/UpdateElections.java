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
import persistence.UpdateElectionManager;

/**
 *
 * @author KevinC
 */
public class UpdateElections extends HttpServlet {
        private static final long serialVersionUID = 1L;

        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String electionid = request.getParameter("electionid");
            String officeName = request.getParameter("OfficeName");
            String isPartisanTrue = request.getParameter("RadioButton");
            String isPartisanFalse = request.getParameter("RadioButton");
            

            int idElection = Integer.parseInt(electionid);
            
            boolean isPartisan = false;
            
            if(isPartisanTrue.equals("True"))
            {
                isPartisan = true;
            }
            if(isPartisanFalse.equals("False"))
            {
                isPartisan = false;
            }
            

            boolean result = new UpdateElectionManager().updateElection(idElection, officeName, isPartisan);
            if(result) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateElection.jsp");
            PrintWriter out= response.getWriter();
            out.println("<br>");
            out.println("<center><b><font color=green>Successfully Created Election</font></b></center>");
            out.println("<br>");
            rd.include(request, response);
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
