package bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;


public class TrainerTerminverwaltungsBean implements Serializable {
private static final long serialVersionUID = 1L;


private Long id;
private String kurzbeschreibung;
private String ort;
private Date datum;
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
