package spring.di;

import java.util.List;

public class RentalLocation {

	private List<String> titles;
	private String name;

	public RentalLocation(String name, List<String> titles) {
		super();
		this.titles = titles;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
}
