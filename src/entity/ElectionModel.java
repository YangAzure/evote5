/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import persistence.Persistable;

/**
 *
 * @author kevincheng
 */
public class ElectionModel implements Persistable{
    
        int idElection;
        String officeName;
        int isPartisan;
        int BallotID;
        int TotalCount;

    public int getIdElection() {
        return idElection;
    }

    public void setIdElection(int idElection) {
        this.idElection = idElection;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    
    public int isIsPartisan() {
        return isPartisan;
    }

    public void setIsPartisan(int isPartisan) {
        this.isPartisan = isPartisan;
    }

    public int getBallotID() {
        return BallotID;
    }

    public void setBallotID(int BallotID) {
        this.BallotID = BallotID;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

        
    
    
    	public long getId() {
		return 0;
	}

	public void setId(long id) {

	}

	public boolean isPersistent() {

		return false;
	}
    
}
