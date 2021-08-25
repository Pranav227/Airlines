package entity;

public class Flight 
{
//			private int flightid;
			private String flightname;
			private String source;
			private String dest;
			private String sdate;
			private String edate;
			private String arrtime;
			private String deprtime;
			private int dur;
			private int price;
			private int dflightid;
			
			
			public Flight( String flightname, String source, String dest, String sdate, String edate,
					String arrtime, String deprtime, int dur, int price) 
			{
				//super();
//				this.flightid = flightid;
				this.flightname = flightname;
				this.source = source;
				this.dest = dest;
				this.sdate = sdate;
				this.edate = edate;
				this.arrtime = arrtime;
				this.deprtime = deprtime;
				this.dur = dur;
				this.price = price;
			}
			
			public Flight(int dflightid) {
				this.dflightid=dflightid;
			}
			
			public int getDflightid() {
				return dflightid;
			}


//			public int getFlightid() {
//				return flightid;
//			}
//
//
//			public void setFlightid(int flightid) {
//				this.flightid = flightid;
//			}


			public String getFlightname() {
				return flightname;
			}


			public void setFlightname(String flightname) {
				this.flightname = flightname;
			}


			public String getSource() {
				return source;
			}


			public void setSource(String source) {
				this.source = source;
			}


			public String getDest() {
				return dest;
			}


			public void setDest(String dest) {
				this.dest = dest;
			}


			public String getSdate() {
				return sdate;
			}


			public void setSdate(String sdate) {
				this.sdate = sdate;
			}


			public String getEdate() {
				return edate;
			}


			public void setEdate(String edate) {
				this.edate = edate;
			}


			public String getArrtime() {
				return arrtime;
			}


			public void setArrtime(String arrtime) {
				this.arrtime = arrtime;
			}


			public String getDeprtime() {
				return deprtime;
			}


			public void setDeprtime(String deprtime) {
				this.deprtime = deprtime;
			}


			public int getDur() {
				return dur;
			}


			public void setDur(int dur) {
				this.dur = dur;
			}


			public int getPrice() {
				return price;
			}


			public void setPrice(int price) {
				this.price = price;
			}
			
			
			
}