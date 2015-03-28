package BuildingProcessManager.models;

import java.sql.Date;

public class Objednávka {
	
	private Integer id;
	
	private Integer id_objednavka;
	
	private Date DatumZadania;
	
	private Boolean Ukoncena;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_objednavka() {
		return id_objednavka;
	}

	public void setId_objednavka(Integer id_objednavka) {
		this.id_objednavka = id_objednavka;
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
