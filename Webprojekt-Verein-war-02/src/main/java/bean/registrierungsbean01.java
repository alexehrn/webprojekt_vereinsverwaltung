package bean;

import java.io.Serializable;

/* Alexander Ehrnstrasser: */
public class registrierungsbean01 implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String auswahl;
	private String vorname;
	private String nachname;
	private String email;
	private String passwort;
	private String team;
	private String filename;
	private byte[] image;
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
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
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}


	
	
	
}
