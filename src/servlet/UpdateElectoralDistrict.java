package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.UpdateElectoralDistrictManager;

/**
 * @author Yang
 */

public class UpdateElectoralDistrict extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateElectoralDistrict() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idElectoralDistrict = request
				.getParameter("idElectoralDistrict").trim();
		String districtName = request.getParameter("districtName").trim();

		UpdateElectoralDistrictManager uedm = new UpdateElectoralDistrictManager();
		boolean result = uedm.updateElectoralDistrict(idElectoralDistrict,
				districtName);
		if (result) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/successful.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
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
