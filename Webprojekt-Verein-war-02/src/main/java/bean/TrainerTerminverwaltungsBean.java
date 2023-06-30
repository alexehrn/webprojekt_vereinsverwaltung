//Fabian Wolfsteiner:

package bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;


public class TrainerTerminverwaltungsBean implements Serializable {
private static final long serialVersionUID = 1L;


private Long id;
private String kurzbeschreibung;
private String ort;
private Date datum;
private String year;
private String month;
private String day;
private LocalTime uhrzeitVON;
private LocalTime uhrzeitBIS;
private String beschreibung;
private String rueckmeldung;



public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getKurzbeschreibung() {
	return kurzbeschreibung;
}
public void setKurzbeschreibung(String kurzbeschreibung) {
	this.kurzbeschreibung = kurzbeschreibung;
}
public String getOrt() {
	return ort;
}
public void setOrt(String ort) {
	this.ort = ort;
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
public LocalTime getUhrzeitVON() {
	return uhrzeitVON;
}
public void setUhrzeitVON(LocalTime UhrzeitVON) {
	this.uhrzeitVON = UhrzeitVON;
}
public LocalTime getUhrzeitBIS() {
	return uhrzeitBIS;
}
public void setUhrzeitBIS(LocalTime uhrzeitBIS) {
	this.uhrzeitBIS = uhrzeitBIS;
}
public String getBeschreibung() {
	return beschreibung;
}
public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
}
public String getRueckmeldung() {
	return rueckmeldung;
}
public void setRueckmeldung(String rueckmeldung) {
	this.rueckmeldung = rueckmeldung;
}


}
