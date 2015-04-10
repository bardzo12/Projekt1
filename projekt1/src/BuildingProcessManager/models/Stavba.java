package BuildingProcessManager.models;

import java.util.Date;


public class Stavba {
	
	private Integer id;
	
	private String Nazov;
	
	private Integer id_objednavka;
	
	private Boolean Stav;
	
	private Date Zaciatok;
	
	private Date Predpokladany_koniec;
	
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

	public void setId_objednavka(Integer objednavka_id) {
		this.id_objednavka = objednavka_id;
	}

	public Boolean getStav() {
		return Stav;
	}

	public void setStav(Boolean stav) {
		Stav = stav;
	}

	public Date getZaciatok() {
		return Zaciatok;
	}

	public void setZaciatok(Date datumStart) {
		Zaciatok = datumStart;
	}

	public Date getPredpokladany_koniec() {
		return Predpokladany_koniec;
	}

	public void setPredpokladany_koniec(Date predpokladany_koniec) {
		Predpokladany_koniec = predpokladany_koniec;
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

	public String getNazov() {
		return Nazov;
	}

	public void setNazov(String nazov) {
		Nazov = nazov;
	}
	
	public Stavba(Integer id, String nazov, Integer objednavka_id, Boolean stav, Date zaciatok, Date koniec, Date predpokladany_koniec, String ulica, String mesto, String psc){
		setId(id);
		setNazov(nazov);
		setId_objednavka(objednavka_id);
		setStav(stav);
		setZaciatok(zaciatok);
		setKoniec(koniec);
		setPredpokladany_koniec(predpokladany_koniec);
		Adresa adresa = new Adresa(null,ulica,mesto,psc);
		setAdresa(adresa);
	}
	
	public Stavba(){
	}

}
