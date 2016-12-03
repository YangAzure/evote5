
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateElectionManager {
    
    public boolean createElection(String officeName, boolean isPartisan) {
        
        boolean result = false;
        
                //int ageInt = Integer.parseInt(age);

        	Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			conn = DbUtils.connect();
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			//String insertStatement = "INSERT INTO ElectoralDistrict (idElectoralDistrict, districtName)";
                        String insertStatement = "INSERT INTO Election (officeName, isPartisan)";
			String sqlInsert = insertStatement + " VALUES ('"+ officeName + "', "+ isPartisan + ")";

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
