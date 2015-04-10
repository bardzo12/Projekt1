package BuildingProcessManager.Databaze;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import BuildingProcessManager.models.Adresa;
import BuildingProcessManager.models.Objednavatel;
import BuildingProcessManager.models.Objednavka;
import BuildingProcessManager.models.Stavba;
import BuildingProcessManager.models.Zamestnanec;

public class StavbaManagment extends AllTables{
	
	@SuppressWarnings("unchecked")
	public List<Stavba> getAllStavby() throws SQLException
	{
		return(selectQuery("SELECT * FROM stavba"));
	}

	@Override
	protected Object processRow(ResultSet rs) throws SQLException {
		return(new Stavba(rs.getInt("id"),rs.getString("nazov"),rs.getInt("objednavka_id"),rs.getBoolean("stav"),rs.getDate("zaciatok"),rs.getDate("koniec"),rs.getDate("predpokladany_koniec"),rs.getString("ulica"),rs.getString("mesto"),rs.getString("psc")));
	}
	
	public Object getStavba(String toto) throws SQLException
	{
		return (selectQuerys("SELECT * FROM stavba"
		+ " where id = "+toto));
	}
	
	public Objednavatel getObjednavatel(String toto) throws SQLException
	{
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
											+" where ob.id = " + toto);
		while(rs.next())
	    result.add(new Objednavatel(rs.getInt("id"),rs.getString("meno"),rs.getString("ico"),rs.getString("dic"),rs.getString("e_mail"),new Adresa(rs.getInt("house_number"),rs.getString("ulica"),rs.getString("mesto"),rs.getString("PSC"))));
		return result.get(0);
	}
	
	public Objednavka getObjednavka(String toto) throws SQLException
	{
		List<Objednavka> result = new LinkedList<Objednavka>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select o.id,o.datum_zadania,o.ukoncena,o.objednavatel_id,o.stav_id from stavba s "
										+"JOIN objednavka o ON o.id=s.objednavka_id "
										+"JOIN objednavatel ob ON ob.id=o.objednavatel_id "
											+"where ob.id = " + toto);
		while(rs.next())
	    result.add(new Objednavka(rs.getInt("id"),rs.getInt("objednavatel_id"),rs.getDate("datum_zadania"),rs.getBoolean("ukoncena"),rs.getInt("stav_id")));
		return result.get(0);
	}
	
	public Double StavbaAktualnaCena(String toto) throws SQLException
	{
		List<Double> result = new LinkedList<Double>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select s.id, s.nazov, SUM(c.hodinovka*c.pocethodin) from etapa e"+
											" LEFT JOIN stavba s ON e.id_stavba=s.id"+
											" LEFT JOIN cena c ON c.id_etapa=e.id"+  
											" LEFT JOIN zamestnanci z ON z.id=c.id_zamestnanec"+
											" where s.id = "+ toto + " AND e.stav = true"+
											" group by s.nazov,s.id"+
											" order by SUM(c.hodinovka*c.pocethodin)");
		while(rs.next())
	    result.add(new Double(rs.getDouble(3)));
		if(result.size()>0)
		return result.get(0);
		else return 0.0;
	}
	
	
	public Double StavbaCena(String toto) throws SQLException
	{
		List<Double> result = new LinkedList<Double>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select s.id, s.nazov, SUM(c.hodinovka*c.pocethodin) from etapa e"+
											" LEFT JOIN stavba s ON e.id_stavba=s.id"+
											" LEFT JOIN cena c ON c.id_etapa=e.id"+  
											" LEFT JOIN zamestnanci z ON z.id=c.id_zamestnanec"+
											" where s.id = "+ toto +
											" group by s.nazov,s.id"+
											" order by SUM(c.hodinovka*c.pocethodin)");
		while(rs.next())
	    result.add(new Double(rs.getDouble(3)));
		if(result.size()>0)
		return result.get(0);
		else return 0.0;
	}
	
	public Zamestnanec Ved�ciStavby(String toto) throws SQLException
	{
		List<Zamestnanec> result = new LinkedList<Zamestnanec>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select z.meno,z.priezvisko,p.nazov from etapa e"+
											" LEFT JOIN stavba s ON e.id_stavba=s.id"+
											" LEFT JOIN cena c ON c.id_etapa=e.id"+
											" LEFT JOIN zamestnanci z ON z.id=c.id_zamestnanec"+
											" JOIN post p ON p.id=z.post_id"+
											" where p.nazov = 'Ved�ci' AND s.id = " +toto);
		while(rs.next())
	    result.add(new Zamestnanec(rs.getString(1),rs.getString(2)));
		if(result.size()>0)
			return result.get(0);
		else return null;
	}

	public List<Zamestnanec> getZamestnanciStavby(String toto) throws SQLException{
		List<Zamestnanec> result = new LinkedList<Zamestnanec>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT z.id,z.meno,z.priezvisko,z.maliar,z.murar,z.obkladac,z.betonar,z.klampiar,z.vodic_bager,z.vodic_nakladne,z.architekt FROM stavba s "+
											"LEFT JOIN etapa e ON e.id_stavba=s.id "+
											"LEFT JOIN cena c ON c.id_etapa=e.id "+
											"LEFT JOIN zamestnanci z ON z.id=c.id_zamestnanec "+
											"where s.id = "+toto+
											"GROUP BY z.id,z.meno,z.priezvisko,z.maliar,z.murar,z.obkladac,z.betonar,z.klampiar,z.vodic_bager,z.vodic_nakladne,z.architekt");
		while(rs.next())
	    result.add(new Zamestnanec(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4),rs.getBoolean(5),rs.getBoolean(6),rs.getBoolean(7),rs.getBoolean(8),rs.getBoolean(9),rs.getBoolean(10),rs.getBoolean(11)));
		return result;
	}
	
	public void insertStavba(Stavba Stavba) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn=null;
		Properties connectionProps = new Properties();
		String createStatementString = new String();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    createStatementString = "INSERT INTO stavba(nazov,objednavka_id,stav,zaciatok,predpokladany_koniec, ulica,mesto,psc) VALUES(?,?,?,?,?,?,?,?)";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		conn.setAutoCommit(true);
	    stmt = (PreparedStatement) conn.prepareStatement(createStatementString);
	    try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
				stmt.setString(1, Stavba.getNazov());
				stmt.setInt(2, Stavba.getId_objednavka());
				stmt.setBoolean(3, false);
				java.sql.Date sqlDate = new java.sql.Date(Stavba.getZaciatok().getTime());
				stmt.setDate(4,sqlDate);
				sqlDate = new java.sql.Date(Stavba.getPredpokladany_koniec().getTime());
				stmt.setDate(5, sqlDate);
				stmt.setString(6, Stavba.getAdresa().getUlica());
				stmt.setString(7, Stavba.getAdresa().getMesto());
				stmt.setString(8, Stavba.getAdresa().getPSC());
				stmt.executeUpdate();

			
			//conn.commit();
//			throw new SQLException("Tuto vynimku sme vyhodili naschval");

				
				

		} catch (SQLException e) {
			if (conn != null) {
	            try {
	            	System.err.println(e.getMessage());
	            	System.err.print("Transaction is being rolled back");
	                conn.rollback();
	            } catch(SQLException excep) {
	                
	            }
	        }
		} finally {
			if(stmt != null){
				stmt.close();
			}
		}
	    
	    conn = null;
		stmt = null;
		
		connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    
		try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
			conn.setAutoCommit(false);
			String updateStatementString = "UPDATE objednavka SET ukoncena = true,stav_id=3 WHERE id = "+Stavba.getId_objednavka().toString();
			stmt  =  conn.prepareStatement(updateStatementString);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
	            try {
	            	System.err.println(e.getMessage());
	            	System.err.print("Transaction is being rolled back");
	                conn.rollback();
	            } catch(SQLException excep) {
	                
	            }
	        }
		} finally {
			if(stmt != null){
				stmt.close();
			}
		}
	}
}