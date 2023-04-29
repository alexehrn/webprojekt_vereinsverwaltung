package bean;

import java.io.Serializable;

public class loginbean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	private String passwort;

}
