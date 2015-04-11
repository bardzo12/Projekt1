package BuildingProcessManager.models;

public class ZamestnanecEtapy {
	
	private Zamestnanec Zamestnanec;
	
	private Double Cena;
	
	private Integer Id_etapa;

	public Zamestnanec getZamestnanec() {
		return Zamestnanec;
	}

	public void setZamestnanec(Zamestnanec zamestnanec) {
		Zamestnanec = zamestnanec;
	}

	public Double getCena() {
		return Cena;
	}

	public void setCena(Double cena) {
		Cena = cena;
	}
	
	public Integer getId_etapa() {
		return Id_etapa;
	}

	public void setId_etapa(Integer id_etapa) {
		Id_etapa = id_etapa;
	}
	
	public ZamestnanecEtapy(Zamestnanec zamestnanec, Double cena){
		setZamestnanec(zamestnanec);
		setCena(cena);
	}

	
	

}
