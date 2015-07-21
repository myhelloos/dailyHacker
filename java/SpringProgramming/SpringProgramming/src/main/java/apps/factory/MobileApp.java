package apps.factory;

import java.util.List;

import spring.di.RentalLocation;
import spring.di.RentalService;

public class MobileApp {

	private static final String TITLE = "Forest Gump";
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		RentalService rentalService = new RentalService(KioskLocatorFactory.createInstance());
		
		List<RentalLocation> locations = rentalService.find(TITLE, "16802", 10);
		
		//Allow mobile users to find titles
	}
}
