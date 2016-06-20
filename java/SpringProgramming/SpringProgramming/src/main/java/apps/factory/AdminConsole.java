package apps.factory;

import java.util.List;

import spring.di.RentalLocation;
import spring.di.RentalService;

public class AdminConsole {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		RentalService rentalService = new RentalService(KioskLocatorFactory.createInstance());

		List<RentalLocation> locations = rentalService.find("Jaws", "16802", 10);

		//Allow admins to support customers
	}
}
