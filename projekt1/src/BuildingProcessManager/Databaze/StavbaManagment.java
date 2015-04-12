package BuildingProcessManager.Databaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import BuildingProcessManager.models.Adresa;
import BuildingProcessManager.models.Objednavatel;
import BuildingProcessManager.models.Objednavka;
import BuildingProcessManager.models.Stavba;
import BuildingProcessManager.models.Zamestnanec;

public class StavbaManagment extends AllTables{
	
	@SuppressWarnings("unchecked")
	public List<Stavba> getsAllStavby() throws SQLException
	{
		return(selectQuery("SELECT * FROM stavba"
				+ " WHERE stav=false"));
	}

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
											+" where s.id = " + toto);
		while(rs.next())
	    result.add(new Objednavatel(rs.getInt("id"),rs.getString("meno"),rs.getString("ico"),rs.getString("dic"),rs.getString("e_mail"),new Adresa(rs.getInt("house_number"),rs.getString("ulica"),rs.getString("mesto"),rs.getString("PSC"))));
		if(result.size()>0)
			return result.get(0);
		else return null;
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
											+"where s.id = " + toto);
		while(rs.next())
	    result.add(new Objednavka(rs.getInt("id"),rs.getInt("objednavatel_id"),rs.getDate("datum_zadania"),rs.getBoolean("ukoncena"),rs.getInt("stav_id")));
		if(result.size()>0)
			return result.get(0);
		else return null;
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
	
	public Zamestnanec VedúciStavby(String toto) throws SQLException
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
											" where p.nazov = 'Vedúci' AND s.id = " +toto + " AND e.stav=false");
		while(rs.next())
	    result.add(new Zamestnanec(rs.getString(1),rs.getString(2)));
		if(result.size()>0)
			return result.get(0);
		else {
			rs = stmt.executeQuery("select z.meno,z.priezvisko,p.nazov from etapa e"+
					" LEFT JOIN stavba s ON e.id_stavba=s.id"+
					" LEFT JOIN cena c ON c.id_etapa=e.id"+
					" LEFT JOIN zamestnanci z ON z.id=c.id_zamestnanec"+
					" JOIN post p ON p.id=z.post_id"+
					" where p.nazov = 'Vedúci' AND s.id = " +toto + " AND e.stav=true");
			while(rs.next())
				result.add(new Zamestnanec(rs.getString(1),rs.getString(2)));
			if(result.size()>0)
				return result.get(0);
			else return null;
		}
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
											" JOIN etapa e ON e.id_stavba=s.id "+
											" JOIN cena c ON c.id_etapa=e.id "+
											" JOIN zamestnanci z ON z.id=c.id_zamestnanec "+
											"where s.id = "+toto+
											"GROUP BY z.id,z.meno,z.priezvisko,z.maliar,z.murar,z.obkladac,z.betonar,z.klampiar,z.vodic_bager,z.vodic_nakladne,z.architekt"
											+ " order by z.priezvisko");
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
	    createStatementString = "INSERT INTO stavba(nazov,objednavka_id,stav,zaciatok,predpokladany_koniec, ulica,mesto,psc) VALUES(?,?,?,?,?,?,?,?);"
	    		+ " UPDATE objednavka SET ukoncena = true,stav_id=3 WHERE id = "+Stavba.getId_objednavka().toString();
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
		} catch (SQLException e) {
			if (conn != null) {
	            try {
	            	JOptionPane.showMessageDialog(null,"Stavba nebola vložená, opakujte vloženie. Vyskytla sa chyba: " + e.getMessage());
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

	public void setStavbaEnd(String pomocna) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    
		try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
			conn.setAutoCommit(true);
			String updateStatementString = new String();
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			System.out.printf("Toto je dátum: %s\n", sqlDate.toString());
				updateStatementString= "UPDATE stavba SET  stav= TRUE,koniec = '"+sqlDate.toString()+ "' where id = " + pomocna+
						"; UPDATE etapa SET stav=TRUE where id_stavba= " + pomocna;
			stmt  =  conn.prepareStatement(updateStatementString);
			stmt.executeUpdate();
		} catch (SQLException e) {
			if (conn != null) {
	            try {
	            	JOptionPane.showMessageDialog(null,"Stavba nebola ukonèená. Vyskytla sa chyba: " + e.getMessage());
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
