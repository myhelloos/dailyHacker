package apps.manual;

import spring.di.KioskLocator;
import spring.di.RentalService;

public class NightlyInventory {


	@SuppressWarnings("unused")
	public static void main(String[] args) {
			
		RentalService rentalService = new RentalService(new KioskLocator("key"));
		
		//Find inventory each night.
	}
}
