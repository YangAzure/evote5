package entity;

import persistence.Persistable;

public class ElectoralDistrict implements Persistable {

	String districtName;

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getIdElectoralDistrict() {
		return idElectoralDistrict;
	}

	public void setIdElectoralDistrict(String idElectoralDistrict) {
		this.idElectoralDistrict = idElectoralDistrict;
	}

	String idElectoralDistrict;

	public long getId() {
		return 0;
	}

	public void setId(long id) {

	}

	public boolean isPersistent() {

		return false;
	}

}
