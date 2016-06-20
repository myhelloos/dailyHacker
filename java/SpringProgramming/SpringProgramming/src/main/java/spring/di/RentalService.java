package spring.di;

import java.util.ArrayList;
import java.util.List;

public class RentalService {

	private SourceLocator sourceLocator;

	public RentalService(SourceLocator storeLocator) {
		super();
		this.sourceLocator = storeLocator;
	}

	public List<RentalLocation> find(String title, String zipcode, int miles) {
		List<RentalLocation> locations = this.sourceLocator.find(zipcode, miles);

		List<RentalLocation> results = new ArrayList<RentalLocation>();
		for (RentalLocation location : locations) {
			if (location.getTitles().contains(title)) {
				results.add(location);
			}
		}

		return results;
	}
}
