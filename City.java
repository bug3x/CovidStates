
public class City {
	private String name;
	private String state;
	
	private int confirmed;
	private int deaths;
	private int active;
	private int recovered;
	
	public City(String n, String s, int c, int d, int r, int a) {
		super();
		name = n;
		state = s;
		confirmed = c;
		deaths = d;
		recovered = r;
		active = a;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", state=" + state + ", confirmed=" + confirmed + ", deaths=" + deaths
				+ ", active=" + active + ", recovered=" + recovered + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	
	
}
