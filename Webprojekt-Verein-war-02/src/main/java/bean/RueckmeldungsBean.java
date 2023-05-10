package bean;

import java.io.Serializable;

public class RueckmeldungsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean rueckmeldung;
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isRueckmeldung() {
		return rueckmeldung;
	}

	public void setRueckmeldung(boolean rueckmeldung) {
		this.rueckmeldung = rueckmeldung;
	}
}
