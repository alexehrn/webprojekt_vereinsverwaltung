package bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;




public class KalenderItemBean implements Serializable {
private static final long serialVersionUID = 1L;


private Long id;
private String kurzbeschreibung;
private LocalTime uhrzeitVON;
private Date datum;




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
public LocalTime getUhrzeitVON() {
	return uhrzeitVON;
}
public void setUhrzeitVON(LocalTime UhrzeitVON) {
	this.uhrzeitVON = UhrzeitVON;
}

public Date getDatum() {
	return datum;
}
public void setDatum(Date datum) {
	this.datum = datum;
}



}
