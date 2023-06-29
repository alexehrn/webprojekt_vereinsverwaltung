package bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class RueckmeldungsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String rueckmeldung;
	private Long id;
	private String beschreibung;
	private Long zusagen;
	private Long absagen;
	private Date datum;

	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	 public String getDatum() {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	        return sdf.format(datum);
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
}
