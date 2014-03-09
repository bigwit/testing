package itmo.cs.testing.lab1.task3;

public class Place {
	
	private static final String DEFAULT_PLACE = "HERE";
	private String place;
	
	public Place() {
		place = DEFAULT_PLACE;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getPlace() {
		return this.place;
	}
	
}
