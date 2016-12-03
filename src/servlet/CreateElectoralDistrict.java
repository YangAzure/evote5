package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ElectoralDistrictManager;

/**
 * Servlet implementation class CreateElectoralDistrict
 */

public class CreateElectoralDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * author: Mingyang JIAO
	 * */
    public CreateElectoralDistrict() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String districtID = request.getParameter("id");
		String districtName = request.getParameter("name");
		System.out.print(districtID);
		System.out.print(districtName);
		ElectoralDistrictManager edm = new ElectoralDistrictManager();
		boolean result = edm.createElectoralDistrict(districtID, districtName);
		if(result){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/successful.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
