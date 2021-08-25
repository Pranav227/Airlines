package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Passenger;
import validations.PassengerValidation;

public class PassengerDao {

	public  void insertRecord(Connection con,Passenger p1) throws SQLException
	{
		String name=p1.getPassname();
		long contact=p1.getCont();
		String query = "insert into passengers(PNAME,AGE,CONTACTNO,EMAIL,GENDER) values(?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(query);
		//p.setInt(1,p1.getPassid());
		p.setString(1,p1.getPassname());
		p.setInt(2,p1.getAge());
		p.setLong(3,p1.getCont());
		p.setString(4,p1.getEmail());
		p.setString(5,p1.getGender());
		
		p.executeUpdate();
		Statement stmt=con.createStatement();
		String pquery="select PASSENGERID from passengers where PNAME='";
		ResultSet rs=stmt.executeQuery(pquery + name + "'and CONTACTNO= " + contact);
		if(rs.next()) {
			System.out.println("Your Passenger ID is==>"+rs.getInt(1));
		}else {
			System.out.println("Registration Failed...!Please try again");
		}
	
	}
		
		//Function Overloading
		public  void updateRecord(Connection con,int passid,String passname) throws SQLException
		{
			
			
			String query="update passenger set NAME=? where PASSENGERID=?";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(2,passid);
			p.setString(1,passname);
			
			p.executeUpdate();
		
			}
		
		public  void updateRecord2(Connection con,int passid,long cont) throws SQLException
		{
			
			
			String query="update flight set DEPRTIME=? where FLIGHTID=?";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(2,passid);
			p.setLong(1,cont);
			
			p.executeUpdate();
		
			}
		
		public  void updateRecord3(Connection con,int passid,String email) throws SQLException
		{
			
			
			String query="update flight set PRICE=? where FLIGHTID=?";
			
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(2,passid);
			p.setString(1,email);
			
			p.executeUpdate();
		
			}
		
		
		public  void deleteRecord(Connection con,int passid) throws SQLException
		{
			
			
			String query="delete from flight where FLIGHTID=? ";
			
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1,passid);
			
			p.executeUpdate();
			System.out.println("Flight Deleted");
		
			}
		public  boolean CheckDetails(Connection con, PassengerValidation p) throws SQLException
		{
			Statement stmt=con.createStatement();
			String name=p.getPname();
			long cont=p.getContact();
			ResultSet rs=stmt.executeQuery("select * from passengers where PNAME='" + name + "'and CONTACTNO= " + cont);
			 if (rs.next()) {  
				   System.out.println("Welcome:::" + name);
				   return true;
			 }
			 else {  
				   System.out.println("Invalid user name and password");
				   return false;
			 }
				  
			}
		public void viewDetails(Connection con,int pid) throws SQLException {
			String query="select * from passengers where passengerid=";
			Statement stmt=con.createStatement();
			ResultSet irs=stmt.executeQuery(query+pid);
			System.out.println(String.format("%"+(-20)+"s", "PassengerId")+String.format("%"+(-20)+"s", "PassengerName")+String.format("%"+(-20)+"s", "Age")+String.format("%"+(-20)+"s", "ContactNo")+String.format("%"+(-20)+"s", "Email")+String.format("%"+(-20)+"s", "Gender"));
			if(irs.next()) {
				System.out.println(String.format("%"+(-20)+"d", irs.getInt(1))+String.format("%"+(-20)+"s", irs.getString(2))+String.format("%"+(-20)+"d", irs.getInt(3))+String.format("%"+(-20)+"s", irs.getString(4))+String.format("%"+(-20)+"s", irs.getString(4))+String.format("%"+(-20)+"s", irs.getString(5)));

			}


		}
		

}
	


