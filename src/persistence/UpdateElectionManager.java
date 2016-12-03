/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.ElectionModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author kevincheng
 */
public class UpdateElectionManager {
    
    
 	public boolean updateElection(int idElection,
			String officeName, boolean isPartisan) {
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
					.executeUpdate("update Election set officeName = '"+officeName+"', isPartisan = "+isPartisan+" where idElection ="+idElection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = (integerResult != 0);

		return result;
	}
}
