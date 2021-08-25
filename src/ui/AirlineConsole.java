package ui;

import java.sql.Connection;

import entity.Flight;
import dao.FlightDao;
import validations.PassengerValidation;
import entity.Passenger;
import dao.PassengerDao;
import entity.Booking;
import dao.BookingDao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AirlineConsole {
	public static void main(String args[])throws SQLException {
		int category;
		String ans;
		
		
		FlightDao fd=new FlightDao();
		PassengerValidation pv=new PassengerValidation();
		PassengerDao pd=new PassengerDao();
		BookingDao bd=new BookingDao();
		
		
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ose","mini","MINI");
			
			do {
				System.out.println("************** Welcome To Airline Reservation System ***************");
				System.out.println("Select your Category from the given option==>");
				System.out.println("1.    Admin");
				System.out.println("2.    Passenger");
				
				category=sc.nextInt();
				
				switch(category) {
				case 1: 
					System.out.println("************** Welcome to the Admin Portal *************");
					String aans;
					do {											
						System.out.println("Select your Action==>");
						System.out.println("1. Add Flight");
						System.out.println("2. Delete Flight");
						System.out.println("3. Update Flight Details");
						System.out.println("4. Generate Report");
						int acategory = sc.nextInt();
						
						switch(acategory) {
						case 1:
//							System.out.println("Enter the flight id");
//							int flightid = sc.nextInt();
							System.out.println("Enter the flight name");
							String fname = sc.next();
							System.out.println("Enter the flight source");
							String source = sc.next();
							System.out.println("Enter the flight destination");
							String dest=sc.next();
							System.out.println("Enter the flight strart date");
							String sdate=sc.next();
							System.out.println("Enter the flight edate");
							String edate=sc.next();
							System.out.println("Enter the flight Arrival time");
							String arrtime = sc.next();
							System.out.println("Enter the flight departure time");
							String deprtime =sc.next();
							System.out.println("Enter the flight deration");
							int dur = sc.nextInt();
							System.out.println("Enter the flight price");
							int price = sc.nextInt();
							Flight fl = new Flight(fname,source,dest,sdate,edate,arrtime,deprtime,dur,price);
							fd.insertRecord(con, fl);
							break;
						case 2:int fid;
							System.out.println("Enter the FlightID");
							fid=sc.nextInt();
							//Flight fdlt=new Flight(fid);
							
							fd.deleteRecord(con, fid);
							break;
						case 3:
							System.out.println("Enter the flight ID");
							int id=sc.nextInt();
							int choice;
							String uans;
							do {
									System.out.println("What do you want to update");
									System.out.println("1. Flight Name");
									System.out.println("2. Arrival Time");
									System.out.println("3. Departure Time");
									System.out.println("4. Price");
									choice=sc.nextInt();
									switch(choice) {
									case 1:
										System.out.println("Enter Flight name");
										String name = sc.next();
										fd.updateRecord4(con, id, name);
										break;
									case 2:
										System.out.println("Enter Arrival time");
										int arr = sc.nextInt();
										fd.updateRecord1(con, id, arr);
										break;
									case 3:
										System.out.println("Enter Departure Time");
										int dpr = sc.nextInt();
										fd.updateRecord2(con, id, dpr);
										break;
									case 4:
										System.out.println("Enter Price");
										int pr = sc.nextInt();
										fd.updateRecord3(con, id, pr);
										break;
									default : 
										System.out.println("Invalid Option");
										
									}
									System.out.println("Do you need to update anyother information?(y/n)");
									uans=sc.next();
							}while(uans.equals("y"));
						case 4:
							int rchoice;
							String rans;
							do {
								System.out.println("What kind of report would you like to generate");
								System.out.println("1. Overall Report");
								System.out.println("2. Individual Flight Report");
								rchoice=sc.nextInt();
								
								switch(rchoice) {
								
								case 1:
									System.out.println("Generating Overall Report..........");
									String query="select f.flightid,f.fname,f.source,\r\n"
											+ "p.passengerid,p.pname,p.age,\r\n"
											+ "b.bookingid\r\n"
											+ "from flight f\r\n"
											+ "INNER JOIN booking b\r\n"
											+ "ON f.flightid=b.flightid\r\n"
											+ "INNER JOIN passengers p\r\n"
											+ "ON b.passengerid=p.passengerid";
									Statement stmt=con.createStatement();
									ResultSet rs=stmt.executeQuery(query);
									System.out.println(String.format("%"+(-20)+"s", "FlightID")+String.format("%"+(-20)+"s", "FlightName")+String.format("%"+(-20)+"s", "Source")+String.format("%"+(-20)+"s", "PassengerId")+String.format("%"+(-20)+"s", "PassengerName")+String.format("%"+(-20)+"s", "Age")+String.format("%"+(-20)+"s", "BookingID"));
									while(rs.next()) {
										System.out.println(String.format("%"+(-20)+"d", rs.getInt(1))+String.format("%"+(-20)+"s", rs.getString(2))+String.format("%"+(-20)+"s", rs.getString(3))+String.format("%"+(-20)+"d", rs.getInt(4))+String.format("%"+(-20)+"s", rs.getString(5))+String.format("%"+(-20)+"d", rs.getInt(6))+String.format("%"+(-20)+"d", rs.getInt(7)));
									}
									break;
								case 2:
									System.out.println("Individual Flight Report");
									System.out.println("Enter the Flight id");
									int ffid=sc.nextInt();
									String iquery="select p.passengerid,p.pname,p.age,\r\n"
											+ "f.flightid,\r\n"
											+ "b.bookingid\r\n"
											+ "from flight f\r\n"
											+ "INNER JOIN booking b\r\n"
											+ "ON f.flightid="+ffid+"\r\n"
											+ "INNER JOIN passengers p\r\n"
											+ "ON b.passengerid=p.passengerid";
									Statement istmt=con.createStatement();
									ResultSet irs=istmt.executeQuery(iquery);
									System.out.println(String.format("%"+(-20)+"s", "PassengerId")+String.format("%"+(-20)+"s", "PassengerName")+String.format("%"+(-20)+"s", "Age")+String.format("%"+(-20)+"s", "FlightId")+String.format("%"+(-20)+"s", "BookingId"));
									while(irs.next()) {
										System.out.println(String.format("%"+(-20)+"d", irs.getInt(1))+String.format("%"+(-20)+"s", irs.getString(2))+String.format("%"+(-20)+"d", irs.getInt(3))+String.format("%"+(-20)+"d", irs.getInt(4))+String.format("%"+(-20)+"d", irs.getInt(5)));
									}
									break;									
								}
								System.out.println("Do you want to generate report again?(y/n)");
								rans=sc.next();
							}while(rans.equals("y"));
							
						}
						
						System.out.println("Do you want to perform any other action..?(y/n)");
						aans=sc.next();
					}while(aans.equals("y"));
					
					break;
				case 2:
					System.out.println("Welcome to the Passeger Portal");
					int pcategory;
					String pans;
					
					do {
						System.out.println("Select your action===>");
						System.out.println("1.     Booking");
						System.out.println("2.     Cancellation");
						System.out.println("3.     View Details");
						System.out.println("4.     Register");
						pcategory=sc.nextInt();
						
						switch(pcategory) {
						case 1:System.out.println("Enter your name");
							String name=sc.next();
							System.out.println("enter your contact number(password)");
							long pcontact=sc.nextLong();	
							PassengerValidation p = new PassengerValidation(name,pcontact);
							boolean b = pd.CheckDetails(con, p);
							if(b) {
								fd.viewFlight(con);
								System.out.println("Enter Flight Id");
								int fid=sc.nextInt();
								System.out.println("Enter Passenger id");
								int pid=sc.nextInt();
								
								Booking bk=new Booking(fid,pid);
								
								bd.insertRecord(con, bk);
								
							}
							else {
								System.out.println("Register First");
							}
							break;
						case 2:
							System.out.println("Enter Your Booking ID");
							int bid=sc.nextInt();				
							bd.deleteRecord(con, bid);
							break;
						case 3:
							System.out.println("Enter your passenger id");
							int pid = sc.nextInt();
							pd.viewDetails(con, pid);							
							break;
						case 4:
							long contact;
							String email;
							System.out.println("Registration Portal");
							System.out.println("Enter your name==>");
							String pname=sc.next();
							System.out.println("Enter age");
							int age=sc.nextInt();
							do {
								System.out.println("Enter Contact no:");
								String tcontact=sc.next();
								contact=pv.contactValidation(tcontact);
								
							}while(contact==0);							
							do {
								System.out.println("enter your Email");
								email=sc.next();
								email=pv.emailValidation(email);
							}while(email.equals("invalid"));
							System.out.println("Gender:");
							String gender=sc.next();
							Passenger ps=new Passenger(pname,age,contact,email,gender);
							pd.insertRecord(con, ps);
							break;
						default : System.out.println("Please select the category from given options only...!");
							
						}
						System.out.println("Would You like to perform any other action..?(y/n)");
						pans=sc.next();
					}while(pans.equals("y"));				
					break;
				default : System.out.println("Please select the category from given options only...!");
				}
				System.out.println("Would You like to visit again..?(y/n)");
				ans=sc.next();
			}while(ans.equals("y"));
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("Visit Again");
		sc.close();
	}
}
