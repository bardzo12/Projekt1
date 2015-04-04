package BuildingProcessManager.models;

public class Cena {
	
	private Integer Hodinovka;
	
	private Integer PocetHodin;
	
	private Integer Hodnota;
	
	private Integer Etapa;
	
	private Integer id_etapa;
	
	private Integer id_zamestnanec;

	public Integer getHodinovka() {
		return Hodinovka;
	}

	public void setHodinovka(Integer hodinovka) {
		Hodinovka = hodinovka;
	}

	public Integer getPocetHodin() {
		return PocetHodin;
	}

	public void setPocetHodin(Integer pocetHodin) {
		PocetHodin = pocetHodin;
	}

	public Integer getHodnota() {
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

	public void setHodnota(Integer hodnota) {
		Hodnota = hodnota;
	}
	
	

}
