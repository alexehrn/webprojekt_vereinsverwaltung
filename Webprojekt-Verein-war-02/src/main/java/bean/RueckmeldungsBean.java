package bean;

import java.io.Serializable;
import java.sql.Date;

public class RueckmeldungsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean rueckmeldung;
	private Long id;
	private Long zusagen;
	private Long absagen;
	private String beschreibung;
	private Date datum;

	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Long getZusagen() {
		return zusagen;
	}
	public void setZusagen(Long zusagen) {
		this.zusagen = zusagen;
	}
	public Long getAbsagen() {
		return absagen;
	}
	public void setAbsagen(Long absagen) {
		this.absagen = absagen;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isRueckmeldung() {
		return rueckmeldung;
	}
	
	

	public void setRueckmeldung(boolean rueckmeldung) {
		this.rueckmeldung = rueckmeldung;
	}
}
