package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


public class TrainerTerminverwaltungsBean implements Serializable {
private static final long serialVersionUID = 1L;

private Long id;
private String kurzbeschreibung;
private String ort;
private Date datum;
private Time uhrzeitVON;
private Time uhrzeitBIS;
private String beschreibung;



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
public Time getUhrzeitVON() {
	return uhrzeitVON;
}
public void setUhrzeitVON(Time uhrzeitVON) {
	this.uhrzeitVON = uhrzeitVON;
}
public Time getUhrzeitBIS() {
	return uhrzeitBIS;
}
public void setUhrzeitBIS(Time uhrzeitBIS) {
	this.uhrzeitBIS = uhrzeitBIS;
}
public String getBeschreibung() {
	return beschreibung;
}
public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
}


}
