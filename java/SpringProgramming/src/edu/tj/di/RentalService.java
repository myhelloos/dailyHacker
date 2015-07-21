package edu.tj.di;

import java.util.ArrayList;
import java.util.List;

public class RentalService
{

	private SourceLocator sourceLocator;

	public RentalService(SourceLocator sourceLocator)
	{
		super();
		this.sourceLocator = sourceLocator;
	}

	public List<RentalLocation> find(String title, String zipcode, int miles)
	{
		List<RentalLocation> locations = this.sourceLocator.find(zipcode, miles);

		List<RentalLocation> results = new ArrayList<RentalLocation>();
		for (RentalLocation location : locations)
		{
			if (location.getTitles().contains(title))
			{
				results.add(location);
			}
		}

		return results;
	}
}