package json;

public class Weather {

	private String loc;
	private String temp;
	private String date;

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "{\"loc\" = \"" + loc + "\", \"temp\" = \"" + temp + "\", \"date\" = \"" + date + "\"}";
	}
}
