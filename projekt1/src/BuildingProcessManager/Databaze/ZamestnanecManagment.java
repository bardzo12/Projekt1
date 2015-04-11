package BuildingProcessManager.Databaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import BuildingProcessManager.models.Adresa;
import BuildingProcessManager.models.Post;
import BuildingProcessManager.models.Zamestnanec;

public class ZamestnanecManagment extends AllTables{

	protected Zamestnanec processRow(ResultSet rs) throws SQLException{
		Post post = new Post();
		post.setNazov(rs.getString("Nazov"));
		/*rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
		post.setNazov(rs.getString(rs.getString("Nazov")));*/
		Adresa adresa = new Adresa(rs.getInt("House_number"),rs.getString("Ulica"),rs.getString("Mesto"),rs.getString("PSC"));
		return(new Zamestnanec(rs.getInt("id"),rs.getString("Meno"),rs.getString("Priezvisko"),rs.getBoolean("Zdravotny_stav"),rs.getString("Telefon"),adresa,post,rs.getBoolean("maliar"),rs.getBoolean("murar"),rs.getBoolean("obkladac"),rs.getBoolean("betonar"),rs.getBoolean("klampiar"),rs.getBoolean("vodic_bager"),rs.getBoolean("vodic_nakladne"),
				rs.getBoolean("architekt"),rs.getDate("zaciatokPN"),rs.getDate("koniecPN")));
	}

	public List<Zamestnanec> getAllZamestnanec() throws SQLException
	{
		return(selectQuery("SELECT * FROM Zamestnanci z "
				+ "JOIN Post p ON z.Post_id=p.id"
				+ " order by z.priezvisko,z.meno"));
	}
	
	public List<Zamestnanec> getAllRobotnik() throws SQLException
	{
		return(selectQuery("SELECT * FROM Zamestnanci z "
				+ "JOIN Post p ON z.Post_id=p.id "
				+ "WHERE p.Nazov='Robotník'"));
	}
	
	public static List<Zamestnanec> getAllZamestanecOld() throws SQLException{
		List<Zamestnanec> result = new LinkedList<Zamestnanec>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM zamestnanci"
					+ " order by priezvisko,meno");
			while(rs.next()){
				//result.add(new Zamestnanec(rs.getString("Meno"),rs.getString("Priezvisko")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	    return result;
	}
	
	public void updateZamestnanec(String tohto, String Post) throws SQLException{
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
				updateStatementString= "UPDATE zamestnanci SET post_id = " + Post + " where id = " + tohto ;
				stmt  =  conn.prepareStatement(updateStatementString);
			stmt.executeUpdate();
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
	
	public void updateZamestnanec(Zamestnanec Kto, Zamestnanec Novy) throws SQLException {
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
			if(Novy.getZdravotny_stav()==null)
				updateStatementString= "UPDATE zamestnanci SET meno = '"+Novy.getMeno()+"',priezvisko = '"+Novy.getPriezvisko()+"', telefon = '"+Novy.getTelefon()+"', house_number = '"+Novy.getAdresa().getNumber()+"'"
						+ ", ulica = '"+Novy.getAdresa().getUlica()+"', mesto = '"+Novy.getAdresa().getMesto()+"', psc = '"+Novy.getAdresa().getPSC()+"'"
						+ ", maliar = '"+Novy.getMaliar()+"', murar = '"+Novy.getMurar()+"', obkladac = '"+Novy.getObkladac()+"'"
								+ ", betonar = '"+Novy.getBetonar()+"', klampiar = '"+Novy.getKlampiar()+"', vodic_bager = '"+Novy.getVodic_bager()+"', vodic_nakladne = '"+Novy.getVodic_nakladne()+"', architekt = '"+Novy.getArchitekt()+"' WHERE id = '"+Kto.getId()+"'";
			else if(Novy.getZdravotny_stav()==false)
				updateStatementString= "UPDATE zamestnanci SET meno = '"+Novy.getMeno()+"',priezvisko = '"+Novy.getPriezvisko()+"', telefon = '"+Novy.getTelefon()+"', house_number = '"+Novy.getAdresa().getNumber()+"'"
					+ ", ulica = '"+Novy.getAdresa().getUlica()+"', mesto = '"+Novy.getAdresa().getMesto()+"', psc = '"+Novy.getAdresa().getPSC()+"'"
							+ ", maliar = '"+Novy.getMaliar()+"', murar = '"+Novy.getMurar()+"', obkladac = '"+Novy.getObkladac()+"'"
									+ ", betonar = '"+Novy.getBetonar()+"', klampiar = '"+Novy.getKlampiar()+"', vodic_bager = '"+Novy.getVodic_bager()+"', vodic_nakladne = '"+Novy.getVodic_nakladne()+"', zaciatokPN = '"+Novy.getZaciatokPN()+"', koniecPN='"+Novy.getKoniecPN()+"', zdravotny_stav = '"+Novy.getZdravotny_stav()+"', architekt = '"+Novy.getArchitekt()+"' WHERE id = '"+Kto.getId()+"'";
			else updateStatementString= "UPDATE zamestnanci SET meno = '"+Novy.getMeno()+"',priezvisko = '"+Novy.getPriezvisko()+"', telefon = '"+Novy.getTelefon()+"', house_number = '"+Novy.getAdresa().getNumber()+"'"
					+ ", ulica = '"+Novy.getAdresa().getUlica()+"', mesto = '"+Novy.getAdresa().getMesto()+"', psc = '"+Novy.getAdresa().getPSC()+"'"
					+ ", maliar = '"+Novy.getMaliar()+"', murar = '"+Novy.getMurar()+"', obkladac = '"+Novy.getObkladac()+"'"
							+ ", betonar = '"+Novy.getBetonar()+"', klampiar = '"+Novy.getKlampiar()+"', vodic_bager = '"+Novy.getVodic_bager()+"', vodic_nakladne = '"+Novy.getVodic_nakladne()+"', zdravotny_stav = '"+Novy.getZdravotny_stav()+"', architekt = '"+Novy.getArchitekt()+"', koniecPN = NULL, zaciatokPN = NULL WHERE id = '"+Kto.getId()+"'";
			stmt  =  conn.prepareStatement(updateStatementString);
			stmt.executeUpdate();
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
	
	
	
	/*
	 * SELECT z.id,z.meno,z.priezvisko FROM zamestnanci z WHERE z.id NOT IN (
select z.id from cena c
JOIN etapa e ON e.id=c.id_etapa
JOIN zamestnanci z ON z.id=c.id_zamestnanec
where e.stav = true and z.zdravotny_stav=true)
	
	 */
	
	@SuppressWarnings("unchecked")
	public List<Zamestnanec> getAllFree() throws SQLException
	{
		return(selectQuery("SELECT p.nazov,z.id,meno,priezvisko,zdravotny_stav,telefon,maliar,murar,obkladac,betonar,klampiar,vodic_bager,vodic_nakladne,architekt,zaciatokPN,koniecPN,house_number,ulica,mesto,psc FROM zamestnanci z "
				+ "JOIN post p ON p.id=z.post_id "
				+ "WHERE z.id NOT IN ( "
				+ "select z.id from cena c "
				+ "JOIN etapa e ON e.id=c.id_etapa "
				+ "JOIN zamestnanci z ON z.id=c.id_zamestnanec "
				+ "JOIN post p ON p.id=z.post_id "
				+ "where e.stav = true and z.zdravotny_stav=true)"));
	}
	
	public void insertZamestnanec(Zamestnanec Zamestnanec) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn=null;
		Properties connectionProps = new Properties();
		String createStatementString = new String();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    createStatementString = "INSERT INTO zamestnanci(id,post_id, Meno,Priezvisko, zdravotny_stav, telefon, house_number,ulica,mesto,psc,maliar,murar,obkladac,betonar,klampiar,vodic_bager,vodic_nakladne,architekt) VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		conn.setAutoCommit(true);
	    stmt = (PreparedStatement) conn.prepareStatement(createStatementString);
	    try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
				stmt.setInt(1, 3);
				stmt.setString(2, Zamestnanec.getMeno());
				stmt.setString(3, Zamestnanec.getPriezvisko());
				stmt.setBoolean(4, true);
				stmt.setString(5, Zamestnanec.getTelefon());
				stmt.setInt(6,Zamestnanec.getAdresa().getNumber());
				stmt.setString(7, Zamestnanec.getAdresa().getUlica());
				stmt.setString(8, Zamestnanec.getAdresa().getMesto());
				stmt.setString(9, Zamestnanec.getAdresa().getPSC());
				stmt.setBoolean(10, Zamestnanec.getMaliar());
				stmt.setBoolean(11, Zamestnanec.getMurar());
				stmt.setBoolean(12, Zamestnanec.getObkladac());
				stmt.setBoolean(13, Zamestnanec.getBetonar());
				stmt.setBoolean(14, Zamestnanec.getKlampiar());
				stmt.setBoolean(15, Zamestnanec.getVodic_bager());
				stmt.setBoolean(16, Zamestnanec.getVodic_nakladne());
				stmt.setBoolean(17, Zamestnanec.getArchitekt());
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
	
	public void deleteZamestnanec(Integer Koho) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn=null;
		Properties connectionProps = new Properties();
		String createStatementString = new String();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    createStatementString = "DELETE FROM zamestnanci CASCADE where id = "+Koho.toString();
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		conn.setAutoCommit(true);
	    stmt = (PreparedStatement) conn.prepareStatement(createStatementString);
		try{	conn = DriverManager.getConnection(connectionString, connectionProps);
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
	
	public static List<Zamestnanec> getOdbornici(String Odbornici) throws SQLException{
		List<Zamestnanec> result = new LinkedList<Zamestnanec>();
		Connection conn = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Odbornici);
			while(rs.next()){
				Post post = new Post();
				post.setNazov(rs.getString("Nazov"));
				Adresa adresa = new Adresa(rs.getInt("House_number"),rs.getString("Ulica"),rs.getString("Mesto"),rs.getString("PSC"));
				result.add(new Zamestnanec(rs.getInt("id"),rs.getString("Meno"),rs.getString("Priezvisko"),rs.getBoolean("Zdravotny_stav"),rs.getString("Telefon"),adresa,post,rs.getBoolean("maliar"),rs.getBoolean("murar"),rs.getBoolean("obkladac"),rs.getBoolean("betonar"),rs.getBoolean("klampiar"),rs.getBoolean("vodic_bager"),rs.getBoolean("vodic_nakladne"),
						rs.getBoolean("architekt"),rs.getDate("zaciatokPN"),rs.getDate("koniecPN")));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	    return result;
	}
	
	
}
