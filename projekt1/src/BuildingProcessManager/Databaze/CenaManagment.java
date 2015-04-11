package BuildingProcessManager.Databaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import BuildingProcessManager.models.Cena;
import BuildingProcessManager.models.Zamestnanec;


public class CenaManagment extends AllTables {

	@Override
	protected Object processRow(ResultSet rs) throws SQLException {
		return(new Cena(rs.getDouble("hodinovka"),rs.getDouble("pocethodin"),rs.getInt("id_etapa"),rs.getInt("id_zamestnanec")));
	}
	
	public void insertCena(Cena Cena) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn=null;
		Properties connectionProps = new Properties();
		String createStatementString = new String();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "dbs2015");
	    String connectionString = "jdbc:postgresql://localhost:5432/postgres";
	    createStatementString = "INSERT INTO cena(hodinovka,pocethodin, id_etapa,id_zamestnanec) VALUES(?,?,?,?)";
	    conn = DriverManager.getConnection(connectionString, connectionProps);
		conn.setAutoCommit(true);
	    stmt = (PreparedStatement) conn.prepareStatement(createStatementString);
	    try {
			conn = DriverManager.getConnection(connectionString, connectionProps);
				stmt.setDouble(1, Cena.getHodinovka());
				stmt.setDouble(2, Cena.getPocetHodin());
				stmt.setInt(3, Cena.getId_etapa());
				stmt.setInt(4, Cena.getId_zamestnanec());
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
