package BuildingProcessManager;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;

import BuildingProcessManager.Databaze.ZamestnanecManagment;
import BuildingProcessManager.models.*;

public class Runner {
	public static ZamestnanecManagment Program;
	private static List<Zamestnanec> VsetciZamestnanci;
	
	public ZamestnanecManagment Start(){
		return new ZamestnanecManagment();
	}
	
	public void setVsetciZamestnanci(ZamestnanecManagment zamestnanecManagment) throws SQLException{
		VsetciZamestnanci=zamestnanecManagment.getAllZamestnanec();
	}
	
	public List<Zamestnanec> getVsetciZamestnanci(){
		return VsetciZamestnanci;
	}
	
	public void insertZamestanec(Zamestnanec Builder) throws SQLException{
		Program.insertZamestnanec(Builder);
	}
	
	
	
	/*public static void main(String[] args) throws SQLException {
		
		Program = new ZamestnanecManagment();
		VsetciZamestnanci = Program.getAllZamestnanec();
		
		Frame1 frame = new Frame1();
		//Zamestnanec Builder = new Zamestnanec("Vladimír","Križek");
		//Program.insertZamestnanec(Builder);
		for (Zamestnanec zamestnanec : Program.getAllZamestnanec()) {
			System.out.println(zamestnanec.getMeno() + ":" + zamestnanec.getPriezvisko()+"-"+zamestnanec.getPost().getNazov());
		}
		Adresa Nova = new Adresa(851,"U Šporika", "Èadca", "01234");
		Post Novy = new Post();
		Zamestnanec Builder = new Zamestnanec("Róbert","Kusý",true,"+421918573335", Nova, Novy);
		Zamestnanec BuilderN = new Zamestnanec("Róbert","Kusi",true,"+421918573335", Nova, Novy);
		Program.updateZamestnanec(Builder,BuilderN);
		
		System.out.printf("Robotníci:\n");
		for (Zamestnanec zamestnanec : Program.getAllRobotnik()) {
			System.out.println(zamestnanec.getMeno() + ":" + zamestnanec.getPriezvisko()+"-"+zamestnanec.getPost().getNazov());
		}
		while(frame.program!=1)
		if(frame.program==1) System.out.printf("Ahojkaj");

	}*/

}
