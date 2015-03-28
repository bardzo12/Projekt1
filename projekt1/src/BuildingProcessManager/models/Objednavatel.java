package BuildingProcessManager.models;

public class Objednavatel {
	
	private Integer id;
	
	private String Name;
	
	private String ICO;
	
	private String DIC;
	
	private String E_mail;
	
	private Adresa Adresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getICO() {
		return ICO;
	}

	public void setICO(String iCO) {
		ICO = iCO;
	}

	public String getDIC() {
		return DIC;
	}

	public void setDIC(String dIC) {
		DIC = dIC;
	}

	public String getE_mail() {
		return E_mail;
	}

	public void setE_mail(String e_mail) {
		E_mail = e_mail;
	}

	public Adresa getAdresa() {
		return Adresa;
	}

	public void setAdresa(Adresa adresa) {
		Adresa = adresa;
	}
	

}
