package edu.tj.di;

import java.util.List;

public class Application
{

	private static final String TITLE = "Forest Gump";

	public static void main(String[] args)
	{

		RentalService rentalService = new RentalService(new KioskLocator());
		List<RentalLocation> locations = rentalService.find(TITLE, "16802", 10);

		System.out.printf("%s is available at the following locations:\n", TITLE);

		for (RentalLocation location : locations)
		{
			System.out.println(location.getName());
		}

	}
}