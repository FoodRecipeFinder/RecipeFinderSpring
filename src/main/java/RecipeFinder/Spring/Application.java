package RecipeFinder.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import RecipeFinder.Spring.Model.SavedRecipes;
import RecipeFinder.Spring.Model.User;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
