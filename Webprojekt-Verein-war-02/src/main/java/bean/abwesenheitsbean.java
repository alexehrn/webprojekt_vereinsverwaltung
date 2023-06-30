//Alexander Ehrnstrasser

package bean;

import java.io.Serializable;
import java.sql.Date;


public class abwesenheitsbean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String grund;
	private Date start;
	private String startyear;
	private String startmonth;
	private String startday;
	private Date ende;
	private String endeyear;
	private String endemonth;
	private String endeday;
	private String vorname;
	private String nachname;
	
	
	
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getGrund() {
		return grund;
	}
	public void setGrund(String grund) {
		this.grund = grund;
	}
	public Date getStart() {
        return start;
    }
	public void setStart(Date start) {
		this.start = start;
	}
	public String getStartyear() {
		return startyear;
	}
	public void setStartyear(Date start) {
		this.startyear = start.toString().substring(0,4);
	}
	public String getStartmonth() {
		return startmonth;
	}
	public void setStartmonth(Date start) {
		this.startmonth = start.toString().substring(5,7);
	}
	public String getStartday() {
		return startday;
	}
	public void setStartday(Date start) {
		this.startday = start.toString().substring(8,10);
	}
	
	public Date getEnde() {
       return ende;
    }
	public void setEnde(Date ende) {
		this.ende = ende;
	}
	public String getEndeyear() {
		return endeyear;
	}
	public void setEndeyear(Date ende) {
		this.endeyear = ende.toString().substring(0,4);
	}
	public String getEndemonth() {
		return endemonth;
	}
	public void setEndemonth(Date ende) {
		this.endemonth = ende.toString().substring(5,7);
	}
	public String getEndeday() {
		return endeday;
	}
	public void setEndeday(Date ende) {
		this.endeday = ende.toString().substring(8,10);
	}
	
	
}
