package GUI;

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
}