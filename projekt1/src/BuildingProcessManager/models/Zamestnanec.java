package BuildingProcessManager.models;

import java.util.Set;


public class Zamestnanec {
	
	private Integer id;
	
	private Integer id_post;
	
	private String Meno;
	
	private String Priezvisko;
	
	private String Zdravotny_stav;
	
	private Integer Telefon;
	
	private Set<Etapa> etapy;
	
	private Adresa Adresa;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_post() {
		return id_post;
	}

	public void setId_post(Integer id_post) {
		this.id_post = id_post;
	}

	public String getMeno() {
		return Meno;
	}

	public void setMeno(String meno) {
		Meno = meno;
	}

	public String getPriezvisko() {
		return Priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		Priezvisko = priezvisko;
	}

	public String getZdravotny_stav() {
		return Zdravotny_stav;
	}

	public void setZdravotny_stav(String zdravotny_stav) {
		Zdravotny_stav = zdravotny_stav;
	}

	public Integer getTelefon() {
		return Telefon;
	}

	public void setTelefon(Integer telefon) {
		Telefon = telefon;
	}

	public Set<Etapa> getEtapy() {
		return etapy;
	}

	public void setEtapy(Set<Etapa> etapy) {
		this.etapy = etapy;
	}

	public Adresa getAdresa() {
		return Adresa;
	}

	public void setAdresa(Adresa adresa) {
		Adresa = adresa;
	}

}
