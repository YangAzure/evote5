package testing;

import java.sql.SQLException;

import entity.ElectoralDistrict;
import persistence.UpdateElectoralDistrictManager;

public class Testing {

	/**
	 * this class is for the testing
	 */
	public static void main(String[] args) throws SQLException {
		// test for ElectoralDistrictManager
		// ElectoralDistrictManager edm = new ElectoralDistrictManager();
		// edm.createElectoralDistrict("3", "kkk");

		// test for ElectoralDistrictManager
		
		//test for UpdateElectoralDistrictManager
		UpdateElectoralDistrictManager uedm = new UpdateElectoralDistrictManager();
		
		
		// test for ElectoralDistrictManager
//		for (ElectoralDistrict ed : uedm.getUpdateElectoralDistrict()) {
//			System.out.print(ed.getDistrictName());
//			System.out.print(ed.getIdElectoralDistrict());
//		}
		
		//test for update
		boolean result = uedm.updateElectoralDistrict("1", "afasdo");
		System.out.print(result);
	}
}