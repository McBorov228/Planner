package my.rest.app.Planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlannerApplication {

	public static void main(String[] args) {
		//SessionFactory session = new SessionFactory();
		SpringApplication.run(PlannerApplication.class, args);
	}

}
