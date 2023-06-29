package bean;

import java.io.Serializable;
import java.sql.Date;


public class abwesenheitsbean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String grund;
	private Date start;
	private Date ende;
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
	public Date getEnde() {
       return ende;
    }
	public void setEnde(Date ende) {
		this.ende = ende;
	}
	
	
}
