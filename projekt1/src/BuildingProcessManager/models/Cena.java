package BuildingProcessManager.models;

public class Cena {
	
	private Double Hodinovka;
	
	private Double PocetHodin;
	
	private Double Hodnota;
	
	private Integer Etapa;
	
	private Integer id_etapa;
	
	private Integer id_zamestnanec;

	public Double getHodinovka() {
		return Hodinovka;
	}

	public void setHodinovka(Double hodinovka) {
		Hodinovka = hodinovka;
	}

	public Double getPocetHodin() {
		return PocetHodin;
	}

	public void setPocetHodin(Double pocetHodin) {
		PocetHodin = pocetHodin;
	}

	public Double getHodnota() {
		return Hodnota;
	}

	public void setHodnota() {
		Hodnota = PocetHodin*Hodinovka;
	}

	public Integer getEtapa() {
		return Etapa;
	}

	public void setEtapa(Integer etapa) {
		Etapa = etapa;
	}

	public Integer getId_etapa() {
		return id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		this.id_etapa = id_etapa;
	}

	public Integer getId_zamestnanec() {
		return id_zamestnanec;
	}

	public void setId_zamestnanec(Integer id_zamestnanec) {
		this.id_zamestnanec = id_zamestnanec;
	}

	public void setHodnota(Double hodnota) {
		Hodnota = hodnota;
	}
	
	
	public Cena(Double hodinovka, Double pocethodin, Integer id_etapa,Integer id_zamestnanec){
		setHodinovka(hodinovka);
		setPocetHodin(pocethodin);
		setId_etapa(id_etapa);
		setId_zamestnanec(id_zamestnanec);
	}
	

}
