package spring.di;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	private static final String TITLE = "Forest Gump";

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		RentalService rentalService = context.getBean("rentalService", RentalService.class);
		List<RentalLocation> locations = rentalService.find(TITLE, "16802", 10);
		
		System.out.printf("%s is available at the following locations:\n", TITLE);
		
		for(RentalLocation location:locations) {
			System.out.println(location.getName());
		}
		((ClassPathXmlApplicationContext)context).close();
	}
}
