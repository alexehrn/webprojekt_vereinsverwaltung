//Alexander Ehrnstrasser:

package bean;

import java.io.Serializable;
import java.sql.Date;

public class RueckmeldungsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String rueckmeldung;
	private Long id;
	private String beschreibung;
	private Long zusagen;
	private Long absagen;
	private Date datum;
	private String year;
	private String month;
	private String day;

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
	public String getYear() {
		return year;
	}

	public void setYear(Date datum) {
		this.year = datum.toString().substring(0,4);
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(Date datum) {
		this.month = datum.toString().substring(5,7);
	}

	public String getDay() {
		return day;
	}

	public void setDay(Date datum) {
		this.day = datum.toString().substring(8,10);
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
