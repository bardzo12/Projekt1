package BuildingProcessManager;

import BuildingProcessManager.models.*;

public class Runner {

	public static void main(String[] args) {
		Zamestnanec Builder = new Zamestnanec();
		Builder.setMeno("Al�beta");
		Builder.setPriezvisko("Kri�ekov�");
		System.out.printf("Meno prv�ho: %s priezvisko: %s", Builder.getMeno(), Builder.getPriezvisko());

	}

}
