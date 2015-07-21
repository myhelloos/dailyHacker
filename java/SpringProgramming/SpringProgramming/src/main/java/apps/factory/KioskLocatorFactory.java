package apps.factory;

import spring.di.KioskLocator;
import spring.di.SourceLocator;

public class KioskLocatorFactory {

	public static SourceLocator createInstance() {
		return new KioskLocator("key");
	}
}
