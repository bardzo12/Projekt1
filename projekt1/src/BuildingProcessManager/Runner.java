package BuildingProcessManager;

import BuildingProcessManager.models.*;

public class Runner {

	public static void main(String[] args) {
		Zamestnanec Builder = new Zamestnanec();
		Builder.setMeno("Alžbeta");
		Builder.setPriezvisko("Križeková");
		System.out.printf("Meno prvého: %s priezvisko: %s", Builder.getMeno(), Builder.getPriezvisko());

	}

}
