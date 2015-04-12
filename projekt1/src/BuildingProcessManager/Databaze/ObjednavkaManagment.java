package BuildingProcessManager.Databaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import BuildingProcessManager.models.Adresa;
import BuildingProcessManager.models.Objednavatel;
import BuildingProcessManager.models.Objednavka;

public class ObjednavkaManagment extends AllTables{

	protected Object processRow(ResultSet rs) throws SQLException {
		return(new Objednavka(rs.getInt("id"),rs.getInt("objednavatel_id"),rs.getDate("datum_zadania"),rs.getBoolean("ukoncena"),rs.getInt("stav_id")));
	}

	@SuppressWarnings("unchecked")
	public List<Objednavka> getObjednavkyNevybavene() throws SQLException
	{
		return(selectQuery("select * from objednavka "+
							"JOIN objednavatel o ON o.id=objednavka.objednavatel_id " +
							"where objednavka.ukoncena=false "
							));
	}
	
	public Objednavatel getObjednavatel(String id) throws SQLException{
			List<Objednavatel> result = new LinkedList<Objednavatel>();
			Connection conn = null;
			Statement stmt = null;
			Properties connectionProps = new Properties();
		    connectionProps.put("user", "postgres");
		    connectionProps.put("password", "dbs2015");
		    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
		    conn = DriverManager.getConnection(connectionString, connectionProps);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select ob.id,ob.meno,ob.ico,ob.dic,ob.e_mail,ob.house_number,ob.ulica,ob.mesto,ob.psc from stavba s"
												+" JOIN objednavka o ON o.id=s.objednavka_id"
												+" JOIN objednavatel ob ON ob.id=o.objednavatel_id"
												+" where ob.id = " + id);
			while(rs.next())
		    result.add(new Objednavatel(rs.getInt("id"),rs.getString("meno"),rs.getString("ico"),rs.getString("dic"),rs.getString("e_mail"),new Adresa(rs.getInt("house_number"),rs.getString("ulica"),rs.getString("mesto"),rs.getString("PSC"))));
			return result.get(0);
	}
	
	public Objednavatel getObjednavatelObjednavka(String id) throws SQLException{
		List<Objednavatel> result = new LinkedList<Objednavatel>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select ob.id,ob.meno,ob.ico,ob.dic,ob.e_mail,ob.house_number,ob.ulica,ob.mesto,ob.psc from objednavka o"
											+" JOIN objednavatel ob ON ob.id=o.objednavatel_id"
											+" where ob.id = " + id);
		while(rs.next())
	    result.add(new Objednavatel(rs.getInt("id"),rs.getString("meno"),rs.getString("ico"),rs.getString("dic"),rs.getString("e_mail"),new Adresa(rs.getInt("house_number"),rs.getString("ulica"),rs.getString("mesto"),rs.getString("PSC"))));
		return result.get(0);
}
}
