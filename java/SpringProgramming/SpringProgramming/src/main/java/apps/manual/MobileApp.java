package apps.manual;

import spring.di.KioskLocator;
import spring.di.RentalService;

public class MobileApp {

	
	public static void main(String[] args) {
		
		RentalService rentalService = new RentalService(new KioskLocator("key"));
		rentalService.find("Speed", "55555", 4);
		
		//Allow mobile users to find titles
	}
}
