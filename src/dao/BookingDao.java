package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Booking;

public class BookingDao 
{
	
	public  void insertRecord(Connection con,Booking b1) throws SQLException
	{
		
		String query = "insert into booking(FLIGHTID,PASSENGERID) values(?,?)";
		PreparedStatement p = con.prepareStatement(query);
		p.setInt(2,b1.getPid());
		p.setInt(1,b1.getFid());
		p.executeUpdate();
		System.out.println("booking Succesful");
	
	}
	
	public void deleteRecord(Connection con, int bid ) throws SQLException{
		String query="delete from booking where bookingid=? ";
		
		PreparedStatement p = con.prepareStatement(query);
		
		p.setInt(1,bid);
		
		p.executeUpdate();
		System.out.println("Record Deleted");
	}
	
	public void viewDetails(Connection con, String name) throws SQLException{
		
	}
		
}
