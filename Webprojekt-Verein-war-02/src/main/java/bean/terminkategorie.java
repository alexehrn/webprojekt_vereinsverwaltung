//Alexander Ehrnstrasser

package bean;

import java.io.Serializable;


public class terminkategorie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String kategorie;
	private String mannschaft;
	
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	public String getMannschaft() {
		return mannschaft;
	}
	public void setMannschaft(String mannschaft) {
		this.mannschaft = mannschaft;
	}
	
	
}
