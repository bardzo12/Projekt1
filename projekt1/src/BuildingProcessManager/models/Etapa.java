package BuildingProcessManager.models;

import java.sql.Date;

public class Etapa {
	
	private Integer id;
	
	private Integer id_stavba;
	
	private Date Datum;
	
	private String Stav;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_stavba() {
		return id_stavba;
	}

	public void setId_stavba(Integer id_stavba) {
		this.id_stavba = id_stavba;
	}

	public Date getDatum() {
		return Datum;
	}

	public void setDatum(Date datum) {
		Datum = datum;
	}

	public String getStav() {
		return Stav;
	}

	public void setStav(String stav) {
		Stav = stav;
	}
	

}
