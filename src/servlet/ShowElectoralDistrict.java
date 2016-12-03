package servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ElectoralDistrict;
import persistence.UpdateElectoralDistrictManager;

/**
 * Author Yang SHI
 */

public class ShowElectoralDistrict extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowElectoralDistrict() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UpdateElectoralDistrictManager uedm = new UpdateElectoralDistrictManager();
		Vector<ElectoralDistrict> edList = uedm.getUpdateElectoralDistrict();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("edList", edList);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/updateElectoralDistrict.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
