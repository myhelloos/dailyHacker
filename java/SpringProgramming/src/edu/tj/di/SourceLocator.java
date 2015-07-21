package edu.tj.di;

import java.util.List;

public interface SourceLocator
{

	List<RentalLocation> find(String zipcode, int radius);

}