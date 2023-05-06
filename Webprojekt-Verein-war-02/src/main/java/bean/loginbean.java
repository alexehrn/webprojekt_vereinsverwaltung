package bean;

import java.io.Serializable;

public class loginbean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String auswahl;
	private String email;
	private String passwort;
	
	
	public String getAuswahl() {
		return auswahl;
	}
	public void setAuswahl(String auswahl) {
		this.auswahl = auswahl;
	}
	
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
	

}
