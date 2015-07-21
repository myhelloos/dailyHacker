package apps.factory;

import java.util.List;

import spring.di.RentalLocation;
import spring.di.RentalService;

public class CustomerWebsite {

	@SuppressWarnings("unused")
	public static void main(String[] args) {


		RentalService rentalService = new RentalService(DigitalMediaLocatorFactory.createInstance());
		
		List<RentalLocation> locations = rentalService.find("The Grey", "16802", 10);
		
		//Allow website users to find titles
	}
}
