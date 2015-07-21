package apps.ioc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.RentalLocation;
import spring.di.RentalService;

public class MobileApp {

	private static final String TITLE = "Forest Gump";
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");
		
		RentalService rentalService = context.getBean("rentalService",
				RentalService.class);
	
		List<RentalLocation> locations = rentalService.find(TITLE, "16802", 10);

		//Allow mobile users to find titles
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
