package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ElectoralDistrictManager {
	public boolean createElectoralDistrict(String districtID, String districtName) {
		boolean result = true;
		/*
		 * author: Mingyang JIAO
		 * */
		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			conn = DbUtils.connect();
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			//String insertStatement = "INSERT INTO ElectoralDistrict (idElectoralDistrict, districtName)";
                        String insertStatement = "INSERT INTO ElectoralDistrict ( districtName)";
			String sqlInsert = insertStatement + " VALUES ('"
					+ districtName + "')";

			System.out.println(sqlInsert);

			int rs = stmt.executeUpdate(sqlInsert);
			result = (rs != 0);
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

		return result;
	}
}
