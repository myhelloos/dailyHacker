package apps.manual;

import spring.di.KioskLocator;
import spring.di.RentalService;

public class CustomerWebsite {

	public static void main(String[] args) {

		RentalService rentalService = new RentalService(new KioskLocator("key"));
		
		rentalService.find("Speed", "16802", 10);

		//Allow website users to find titles
	}
}
