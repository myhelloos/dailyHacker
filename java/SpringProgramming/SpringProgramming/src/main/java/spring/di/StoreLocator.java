package spring.di;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreLocator implements SourceLocator {

	private static List<RentalLocation> locations = new ArrayList<RentalLocation>();
	
	static {
		locations.add(new RentalLocation("Blockbuster", Arrays.asList("Forest Gump", "Speed")));
		locations.add(new RentalLocation("Gary's Video", Arrays.asList("Jaws", "Ghost")));
		locations.add(new RentalLocation("West Coast Video", Arrays.asList("Forest Gump", "Hook")));
	}

	/* (non-Javadoc)
	 * @see spring.di.SourceLoader#find(java.lang.String, int)
	 */
	public List<RentalLocation> find(String zipcode, int radius) {
		return locations;
	}

	

}
