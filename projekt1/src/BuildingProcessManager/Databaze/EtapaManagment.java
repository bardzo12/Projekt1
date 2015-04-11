package BuildingProcessManager.Databaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import BuildingProcessManager.models.Cena;
import BuildingProcessManager.models.Etapa;
import BuildingProcessManager.models.Zamestnanec;
import BuildingProcessManager.models.ZamestnanecEtapy;

public class EtapaManagment extends AllTables{
	
	

	@Override
	protected Object processRow(ResultSet rs) throws SQLException {
		return(new Etapa(rs.getInt("id"),rs.getInt("id_stavba"),rs.getDate("datum"),rs.getBoolean("stav")));
	}
	
	/*
	select * from etapa e
	LEFT JOIN stavba s ON s.id=e.id_stavba
	*/
	@SuppressWarnings("unchecked")
	public List<Etapa> getAllEtapy(String id_stavba) throws SQLException
	{
		return(selectQuery("SELECT e.id,e.id_stavba,e.datum,e.stav FROM etapa e "
				+ "LEFT JOIN stavba s ON s.id=e.id_stavba"
				+ " WHERE s.id = " + id_stavba));
	}

	@SuppressWarnings("unchecked")
	public List<Etapa> getAllEtapyEnd(String id_stavba) throws SQLException
	{
		return(selectQuery("SELECT e.id,e.id_stavba,e.datum,e.stav FROM stavba s "
				+ "JOIN etapa e ON s.id=e.id_stavba"
				+ " JOIN cena c ON c.id_etapa=e.id"
				+ " WHERE s.id = " + id_stavba + 
				" and e.stav=true"
				+ " GROUP BY e.id"));
	}
	
	@SuppressWarnings("unchecked")
	public List<Etapa> getAktualEtapa(String id_stavba) throws SQLException
	{
		return(selectQuery("SELECT e.id,e.id_stavba,e.datum,e.stav FROM stavba s "
				+ "JOIN etapa e ON s.id=e.id_stavba"
				+ " WHERE s.id = " + id_stavba + 
				" and e.stav=false"));
	}
	/*
	select s.nazov,e.id,SUM(c.hodinovka*c.pocethodin) from cena c
	JOIN zamestnanci z ON z.id=c.id_zamestnanec
	JOIN etapa e ON e.id=c.id_etapa
	JOIN stavba s ON s.id=e.id_stavba
	WHERE e.id = 
	group by s.nazov,e.id
	*/
	
	public Double getCenaEtapy(String id) throws SQLException{
		List<Double> result = new LinkedList<Double>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select s.nazov,e.id,SUM(c.hodinovka*c.pocethodin) from cena c"+
											" JOIN zamestnanci z ON z.id=c.id_zamestnanec"+
											" JOIN etapa e ON e.id=c.id_etapa"+  
											" JOIN stavba s ON s.id=e.id_stavba"+
											" where e.id = " + id + 
											" group by s.nazov,e.id");
		while(rs.next())
	    result.add(new Double(rs.getDouble(3)));
		if(result.size()>0)
		return result.get(0);
		else return 0.0;
	}
	
	public List<ZamestnanecEtapy> getZamestnanciEtapy(String id_etapa) throws SQLException{
		List<ZamestnanecEtapy> result = new LinkedList<ZamestnanecEtapy>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    
	    // {"Osobné ID","Meno","Priezvisko","Maliar","Murár","Obkladaè","Betonár","Klampiar","Vodiè(bager)","Vodiè(nakladiak)","Architekt"
	    try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select z.meno,z.priezvisko,SUM(c.hodinovka*c.pocethodin) from cena c"+
												" JOIN zamestnanci z ON z.id=c.id_zamestnanec"+
												" JOIN etapa e ON e.id=c.id_etapa"+
												" JOIN stavba s ON s.id=e.id_stavba"+
												" where e.id= "+id_etapa+
												" group by z.meno,z.priezvisko");
			while(rs.next()){
				result.add(new ZamestnanecEtapy(new Zamestnanec(rs.getString(1),rs.getString(2)),rs.getDouble(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	    return result;
	}
	
	public void insertEtapa(Etapa etapa) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn=null;
		Properties connectionProps = new Properties();
		String createStatementString = new String();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		conn.setAutoCommit(true);
	    stmt = (PreparedStatement) conn.prepareStatement(createStatementString);
	    try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
				createStatementString = "UPDATE etapa SET stav=TRUE where id_stavba="+etapa.getId_stavba().toString() +
						"; INSERT INTO etapa(id_stavba,datum,stav) VALUES(?,?,?)";
				stmt = (PreparedStatement) conn.prepareStatement(createStatementString);
				conn = DriverManager.getConnection(connectionString, connectionProps);
				stmt.setInt(1, etapa.getId_stavba());
				java.sql.Date sqlDate = new java.sql.Date(etapa.getDatum().getTime());
				stmt.setDate(2, sqlDate);
				stmt.setBoolean(3, false);
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
	}
}
