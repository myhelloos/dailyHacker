package apps.factory;

import spring.di.DigitalMediaLocator;
import spring.di.SourceLocator;

public class DigitalMediaLocatorFactory {

	public static SourceLocator createInstance() {
		return new DigitalMediaLocator();
	}
}
