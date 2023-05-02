package bean;

import java.io.Serializable;


public class TrainerTerminverwaltungsBean implements Serializable {
private static final long serialVersionUID = 1L;


private String kurzbeschreibung;
private String ort;
private String datum;
private String uhrzeitVON;
private String uhrzeitBIS;
private String beschreibung;



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
public String getDatum() {
	return datum;
}
public void setDatum(String datum) {
	this.datum = datum;
}
public String getUhrzeitVON() {
	return uhrzeitVON;
}
public void setUhrzeitVON(String uhrzeitVON) {
	this.uhrzeitVON = uhrzeitVON;
}
public String getUhrzeitBIS() {
	return uhrzeitBIS;
}
public void setUhrzeitBIS(String uhrzeitBIS) {
	this.uhrzeitBIS = uhrzeitBIS;
}
public String getBeschreibung() {
	return beschreibung;
}
public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
}


}
