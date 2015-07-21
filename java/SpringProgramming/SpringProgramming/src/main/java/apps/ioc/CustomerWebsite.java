package apps.ioc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.RentalLocation;
import spring.di.RentalService;

public class CustomerWebsite {
	private static final String TITLE = "Forest Gump";

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");

		RentalService rentalService = context.getBean("digitalMediaRentalService",
				RentalService.class);

		List<RentalLocation> locations = rentalService.find(TITLE, "16802", 10);
		
		for(RentalLocation location: locations) {
			System.out.println(location.getName());
		}
		//Allow website users to find titles
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
