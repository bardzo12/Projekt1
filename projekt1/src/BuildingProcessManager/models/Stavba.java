package BuildingProcessManager.models;

import java.sql.Date;

public class Stavba {
	
	private Integer id;
	
	private Integer id_objednavka;
	
	private Stav Stav;
	
	private Date Zaciatok;
	
	private Date PredpokladanyKoniec;
	
	private Date Koniec;
	
	private Adresa Adresa;
	
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

	public Stav getStav() {
		return Stav;
	}

	public void setStav(Stav stav) {
		Stav = stav;
	}

	public Date getZaciatok() {
		return Zaciatok;
	}

	public void setZaciatok(Date zaciatok) {
		Zaciatok = zaciatok;
	}

	public Date getPredpokladanyKoniec() {
		return PredpokladanyKoniec;
	}

	public void setPredpokladanyKoniec(Date predpokladanyKoniec) {
		PredpokladanyKoniec = predpokladanyKoniec;
	}

	public Date getKoniec() {
		return Koniec;
	}

	public void setKoniec(Date koniec) {
		Koniec = koniec;
	}

	public Adresa getAdresa() {
		return Adresa;
	}

	public void setAdresa(Adresa adresa) {
		Adresa = adresa;
	}
	
	

}
