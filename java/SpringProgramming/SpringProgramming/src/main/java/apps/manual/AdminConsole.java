package apps.manual;

import java.util.List;

import spring.di.KioskLocator;
import spring.di.RentalLocation;
import spring.di.RentalService;

public class AdminConsole {


	@SuppressWarnings("unused")
	public static void main(String[] args) {

		
		RentalService rentalService = new RentalService(new KioskLocator("key"));

		List<RentalLocation> locations = rentalService.find("Speed", "16802", 10);
		
		//Allow admins to support customers
		
	}
}
