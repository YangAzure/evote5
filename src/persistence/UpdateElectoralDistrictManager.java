package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entity.ElectoralDistrict;

public class UpdateElectoralDistrictManager {

	public boolean updateElectoralDistrict(String idElectoralDistrict,
			String districtName) {
		boolean result = true;
		Connection conn = null;
		Statement stmt = null;
		int integerResult = 1;
		System.out.println("Connecting to database...");
		try {
			conn = DbUtils.connect();
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			integerResult = stmt
					.executeUpdate("update ElectoralDistrict set districtName = '"
							+ districtName
							+ "' where idElectoralDistrict ='"
							+ idElectoralDistrict + "'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = (integerResult != 0);

		return result;
	}

	public Vector<ElectoralDistrict> getUpdateElectoralDistrict() {

		/*
		 * author: YANG SHI
		 */
		Vector<ElectoralDistrict> edList = new Vector<ElectoralDistrict>();
		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			conn = DbUtils.connect();
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sqlSelectID = "select ed.idElectoralDistrict, ed.districtName from ElectoralDistrict ed";
			// String sqlSelectID =
			// "select idElectoralDistrict districtName from ElectoralDistrict";
			// String sqlSelectName =
			// "select districtName from ElectoralDistrict";

			System.out.println(sqlSelectID);

			ResultSet rs = stmt.executeQuery(sqlSelectID);
			while (rs.next()) {
				ElectoralDistrict ed = new ElectoralDistrict();
				ed.setDistrictName(rs.getString("districtName"));
				ed.setIdElectoralDistrict(rs.getString("idElectoralDistrict"));

				edList.add(ed);
			}

			stmt.close();
			conn.close();
		} catch (SQLException se) {

			se.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return edList;

	}

}
