package BuildingProcessManager.models;

public class Adresa {
	
	private Integer Number;
	
	private String Ulica;
	
	private String Mesto;
	
	private String PSC;

	public Integer getNumber() {
		return Number;
	}

	public void setNumber(Integer number) {
		Number = number;
	}

	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		Ulica = ulica;
	}

	public String getMesto() {
		return Mesto;
	}

	public void setMesto(String mesto) {
		Mesto = mesto;
	}

	public String getPSC() {
		return PSC;
	}

	public void setPSC(String pSC) {
		PSC = pSC;
	}
	
	public Adresa(Integer Hous_Number, String Ulica, String Mesto, String PSC){
		setNumber(Hous_Number);
		setUlica(Ulica);
		setMesto(Mesto);
		setPSC(PSC);
	}
}
