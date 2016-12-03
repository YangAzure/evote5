/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ResetPasswordManager {
        public boolean resetPassword(String username, String email, String password) {        
        boolean status = false;
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 1;
        int userID;
        GetUserID getIt = new GetUserID();
        userID = getIt.getUserID(username, email);
		try {

			System.out.println("Connecting to database...");
			conn = DbUtils.connect();
			System.out.println("Creating statement...");
            pst = (PreparedStatement)conn.prepareStatement("update User set password = ? where idUser = ?;");
            pst.setString(1, password);
            pst.setInt(2, userID);

            result = pst.executeUpdate();
            
            status = (result != 0);

	
           // status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}