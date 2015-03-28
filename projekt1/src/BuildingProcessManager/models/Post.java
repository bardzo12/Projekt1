package BuildingProcessManager.models;

public class Post {
	
	private Integer id;
	
	private String Nazov;
	
	private String Kompetencie;
	
	public String getNazov() {
		return Nazov;
	}

	public void setNazov(String nazov) {
		Nazov = nazov;
	}

	public String getKompetencie() {
		return Kompetencie;
	}

	public void setKompetencie(String kompetencie) {
		Kompetencie = kompetencie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
