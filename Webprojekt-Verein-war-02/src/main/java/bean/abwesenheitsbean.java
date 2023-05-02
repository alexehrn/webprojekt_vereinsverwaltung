package bean;

import java.io.Serializable;
import java.util.Date;

public class abwesenheitsbean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String grund;
	private String start;
	private String ende;
	
	public String getGrund() {
		return grund;
	}
	public void setGrund(String grund) {
		this.grund = grund;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnde() {
		return ende;
	}
	public void setEnde(String ende) {
		this.ende = ende;
	}
	
	
}
