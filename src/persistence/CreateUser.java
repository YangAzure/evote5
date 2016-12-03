
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateUser {
    
    public boolean createUser(String username, String password, String email,
            String address, String age, String firstname, String lastname) {
        
        boolean result = false;
        
                int ageInt = Integer.parseInt(age);

        	Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");
			conn = DbUtils.connect();
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			//String insertStatement = "INSERT INTO ElectoralDistrict (idElectoralDistrict, districtName)";
                        String insertStatement = "INSERT INTO User (firstName, lastName, userName, password, email, address, age, voterId, DistrictID)";
			String sqlInsert = insertStatement + " VALUES ('"+ firstname + "', '"+ lastname + "', '"+ username + "', '"+ password + "', '"+ email + "','"+ address + "','"+ ageInt + "','"+ 0 + "','"+ 0 + "')";

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
