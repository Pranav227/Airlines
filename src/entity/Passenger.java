package entity;

public class Passenger 
{
	private int passid;
	private String passname;
	private int age;
	private long cont;
	private String email;
	private String gender;
	
	public Passenger(String passname, int age, long cont, String email, String gender) 
	{
		super();
		this.passname = passname;
		this.age = age;
		this.cont = cont;
		this.email = email;
		this.gender = gender;
	}

	public int getPassid() {
		return passid;
	}

	public void setPassid(int passid) {
		this.passid = passid;
	}

	public String getPassname() {
		return passname;
	}

	public void setPassname(String passname) {
		this.passname = passname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getCont() {
		return cont;
	}

	public void setCont(long cont) {
		this.cont = cont;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [passid=" + passid + ", passname=" + passname + ", age=" + age + ", cont=" + cont + ", email="
				+ email + ", gender=" + gender + "]";
	}
	
}
	
	
