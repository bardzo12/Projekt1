package BuildingProcessManager.models;

import java.sql.Date;

public class Objednavka {
	
	private Integer id;
	
	private Integer id_objednavatel;
	
	private Date DatumZadania;
	
	private Boolean Ukoncena;
	
	private Integer stav_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getObjednavatel_id() {
		return id_objednavatel;
	}

	public void setObjednavatel_id(Integer id_objednavatel) {
		this.id_objednavatel = id_objednavatel;
	}

	public Date getDatumZadania() {
		return DatumZadania;
	}

	public void setDatumZadania(Date datumZadania) {
		DatumZadania = datumZadania;
	}

	public Boolean getUkoncena() {
		return Ukoncena;
	}

	public void setUkoncena(Boolean ukoncena) {
		Ukoncena = ukoncena;
	}

	public Integer getStav_id() {
		return stav_id;
	}

	public void setStav_id(Integer stav_id) {
		this.stav_id = stav_id;
	}
	
	public Objednavka(Integer id,Integer objednavatel_id, Date datum_zadania,Boolean ukoncena,Integer stav_id){
		
		setId(id);
		setDatumZadania(datum_zadania);
		setUkoncena(ukoncena);
		setObjednavatel_id(objednavatel_id);
		setStav_id(stav_id);
		
	}
	
	public Objednavka(){
		
	}

}
