/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import persistence.Persistable;

public class LoginModel implements Persistable {
    
    String username, password;
    int voterId;

    public LoginModel() {
    }

    
    
    public LoginModel(String username, String password, int voterId) {
        this.username = username;
        this.password = password;
        this.voterId = voterId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
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
