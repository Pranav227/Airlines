package entity;

public class Booking 
{
	private int bookid;
	private int fid;
	private int pid;
	
	public Booking(int fid, int pid) 
	{
		super();
		this.fid = fid;
		this.pid = pid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Booking [bookid=" + bookid + ", fid=" + fid + ", pid=" + pid + "]";
	}	
	
}
