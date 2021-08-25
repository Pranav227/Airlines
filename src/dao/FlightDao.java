package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Flight;


public class FlightDao {

	public void viewFlight(Connection con) throws SQLException {
		String query="select * from flight";
		Statement stmt=con.createStatement();

//		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs=stmt.executeQuery(query);
		System.out.println(String.format("%"+20+"s", "FlightID")+String.format("%"+20+"s", "FlightName")+String.format("%"+20+"s", "Source")+String.format("%"+20+"s", "Destination")+String.format("%"+20+"s", "StartDate")+String.format("%"+20+"s", "EndDate")+String.format("%"+20+"s", "ArrivalTime")+String.format("%"+20+"s", "DepartureTime")+String.format("%"+20+"s", "Duration")+String.format("%"+20+"s", "Price"));
		while(rs.next()) {
			System.out.println(String.format("%"+20+"d", rs.getInt(1))+String.format("%"+20+"s", rs.getString(2))+String.format("%"+20+"s", rs.getString(3))+String.format("%"+20+"s", rs.getString(4))+String.format("%"+20+"s", rs.getString(5))+String.format("%"+20+"s", rs.getString(6))+String.format("%"+20+"s", rs.getString(7))+String.format("%"+20+"s", rs.getString(8))+String.format("%"+20+"d", rs.getInt(9))+String.format("%"+20+"d", rs.getInt(10)));
		}
	}
	public  void insertRecord(Connection con,Flight f) throws SQLException
	{
		
			
		String query = "insert into flight(FNAME,SOURCE,DESTINATION,STARTDATE,ENDDATE,ARRTIME,DEPRTIME,DURATION,PRICE) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(query);
		
		//p.setInt(1,f.getFlightid());
		p.setString(1,f.getFlightname());
		p.setString(2,f.getSource());
		p.setString(3,f.getDest());
		p.setString(4,f.getSdate());
		p.setString(5,f.getEdate());
		p.setString(6,f.getArrtime());
		p.setString(7,f.getDeprtime());
		p.setInt(8,f.getDur());
		p.setInt(9,f.getPrice());
		p.executeUpdate();
	
	}
		
		//Function Overloading
		public  void updateRecord1(Connection con,int Flightid,int Arrtime) throws SQLException
		{
			
			
			String query="update flight set ARRTIME=? where FLIGHTID=?";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(2,Flightid);
			p.setInt(1,Arrtime);
			
			p.executeUpdate();
		
			}
		
		public  void updateRecord2(Connection con,int Flightid,int Deprtime) throws SQLException
		{
			
			
			String query="update flight set DEPRTIME=? where FLIGHTID=?";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(2,Flightid);
			p.setInt(1,Deprtime);
			
			p.executeUpdate();
		
			}
		
		public  void updateRecord3(Connection con,int Flightid,int Price) throws SQLException
		{
			
			
			String query="update flight set PRICE=? where FLIGHTID=?";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(2,Flightid);
			p.setInt(1,Price);
			
			p.executeUpdate();
		
			}
		
		public  void updateRecord4(Connection con,int Flightid,String Flightname) throws SQLException
		{
			
			
			String query="update flight set FNAME=? where FLIGHTID=?";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(2,Flightid);
			p.setString(1,Flightname);
			
			p.executeUpdate();
		
			}
		
		public  void deleteRecord(Connection con,int flightid) throws SQLException
		{
			
			
			String query="delete from flight where FLIGHTID=? ";
			
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1,flightid);
			
			p.executeUpdate();
			System.out.println("Flight Deleted");
		
		}
	

}