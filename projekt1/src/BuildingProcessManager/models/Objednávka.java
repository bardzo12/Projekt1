package BuildingProcessManager.models;

import java.sql.Date;

public class Objednávka {
	
	private Integer id;
	
	private Integer id_objednavatel;
	
	private Date DatumZadania;
	
	private Boolean Ukoncena;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_objednavatel() {
		return id_objednavatel;
	}

	public void setId_objednavatel(Integer id_objednavatel) {
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
	

}
