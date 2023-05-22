package bean;

import java.io.Serializable;
import java.sql.Date;

public class RueckmeldungsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String rueckmeldung;
	private Long id;
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

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRueckmeldung() {
		return rueckmeldung;
	}
	
	public void setRueckmeldung(String rueckmeldung) {
		this.rueckmeldung = rueckmeldung;
	}
}
