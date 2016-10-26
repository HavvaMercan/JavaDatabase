package guiProjArlanda1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class sqlString extends connectSQL {
	
	private ResultSet rs =null;
	connectSQL conn = new connectSQL();
	Connection connection = connectSQL.dbConnector();
	
	
	
	
	
	public void sqlSetView() throws SQLException {
		System.out.println("sqlSetView... Running");
		String sqlSelect = "select * from departures";
		PreparedStatement pst = connection.prepareStatement(sqlSelect);
		rs = pst.executeQuery();
		System.out.println("sqlSet... Done");
	}
	
	public void sqlSetInsert(String textField_Flight, String textField_Destination, String textField_AirLine, String textField_AirCraft) throws SQLException {
		System.out.println("sqlSetInsert... Running");
		String query = "insert into departures (Flight, Destination, AirLine, AirCraft) values (?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, textField_Flight);
		pst.setString(2, textField_Destination);
		pst.setString(3, textField_AirLine);
		pst.setString(4, textField_AirCraft);
		pst.execute();
		System.out.println("sqlSetInsert... Done");
	}
	
	public void sqlSetEdit(String textField_Flight, String textField_Destination, String textField_AirLine, String textField_AirCraft) throws SQLException {
		
		System.out.println("sqlSetEdit... Running");
		String sqlEdit = "update departures set Destination = ?, AirLine = ?, AirCraft = ? where Flight = ?";
		PreparedStatement pst = connection.prepareStatement(sqlEdit);
		pst.setString(1, textField_Destination);
		pst.setString(2, textField_AirLine);
		pst.setString(3, textField_AirCraft);
		pst.setString(4, textField_Flight);
		pst.executeUpdate();
		System.out.println("sqlSetEdit... Done");
	}
	
	public void sqlSetRemove(String textField_Flight) throws SQLException {
		System.out.println("sqlSetRemove... Running");
		String sqlRemove = "delete from departures where Flight = ?";
		PreparedStatement pst = connection.prepareStatement(sqlRemove);
		pst.setString(1, textField_Flight);
		pst.executeUpdate();
		System.out.println("sqlSetRemove... Done");
	}
	
	public void sqlSetSearchDis(String textField_Distination) throws SQLException {
		System.out.println("sqlSetSearchDis... Running");
		String sqlRemove = "select * from departures where Destination = ?";
		PreparedStatement pst = connection.prepareStatement(sqlRemove);
		pst.setString(1, textField_Distination);
		rs = pst.executeQuery();
		System.out.println("sqlSetSearchDis... Done");
	}
	
	public void sqlSetSearchAirLine(String textField_AirLine) throws SQLException {
		System.out.println("sqlSetSearchAirLine... Running");
		String sqlRemove = "select * from departures where AirLine = ?";
		PreparedStatement pst = connection.prepareStatement(sqlRemove);
		pst.setString(1, textField_AirLine);
		rs = pst.executeQuery();
		System.out.println("sqlSetSearchAirLine... Done");
	}
	
	public void sqlSetSearchFlight(String textField_Flight) throws SQLException {
		System.out.println("sqlSetSearchFlight... Running");
		String sqlRemove = "select * from departures where Flight = ?";
		PreparedStatement pst = connection.prepareStatement(sqlRemove);
		pst.setString(1, textField_Flight);
		rs = pst.executeQuery();
		System.out.println("sqlSetSearchFlight... Done");
	}
	
	public void sqlSetRemoveQ(String textField_peek) throws SQLException {
		System.out.println("sqlSetRemoveQ... Running");
		String sqlRemove = "delete from departures where Flight = ?";
		PreparedStatement pst = connection.prepareStatement(sqlRemove);
		pst.setString(1, textField_peek);
		pst.executeUpdate();
		System.out.println("sqlSetRemoveQ... Done");
	}
	
	
	
	
	
	
	
	
	public ResultSet sqlGet() {
		return rs;
	}
	

}
