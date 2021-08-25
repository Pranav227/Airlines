package validations;

public class PassengerValidation {
	
	private String pname;
	private long contact;
	
	public PassengerValidation() {
		
	}

	public PassengerValidation(String pname, long contact) {
		super();
		this.pname = pname;
		this.contact = contact;
	}
	
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public long contactValidation(String tcon) {
		 long contact=0;
		 String vcontact=tcon;
		 String regex = "(0/91)?[7-9][0-9]{9}";
	     //System.out.println("The phone number is: " + vcontact);
	     if(vcontact.matches(regex)) {
	    	  contact=Long.parseLong(vcontact);
	    	  return contact;
	     }else {
	    	 System.out.println("Please Enter the valid Contact number");
	    	 return 0;
	     }	     
	}
	public String emailValidation(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(email.matches(regex)) {
			return email;
		}else {
			System.out.println("Please Enter valid EmailId");
			return "invalid";
		}
		
	}
	public boolean userValidation(String pname, long contact) {
		
		return true;
	}
}
