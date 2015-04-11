package BuildingProcessManager.models;

import java.util.Date;


public class Etapa {
	
	private Integer id;
	
	private Integer id_stavba;
	
	private Date Datum;
	
	private Boolean Stav;

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

	public Boolean getStav() {
		return Stav;
	}

	public void setStav(Boolean stav) {
		Stav = stav;
	}
	
	public Etapa(Integer id, Integer id_stavba, Date datum, Boolean stav){
		setId(id);
		setId_stavba(id_stavba);
		setDatum(datum);
		setStav(stav);
	}

	public Etapa() {
	}

}
