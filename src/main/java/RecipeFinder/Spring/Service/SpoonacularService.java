package RecipeFinder.Spring.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpoonacularService {
    RestTemplate restTemplate;
    final String apiURi = "https://api.spoonacular.com/";
    final String apiKey ="apiKey="+System.getenv("SPOONACULAR_KEY");
    public String guessNutritionByName(String name){
        final String uri = apiURi+"recipes/guessNutrition?"+apiKey+"&title="+name;
        restTemplate = new RestTemplate();
        String meal = restTemplate.getForObject(uri, String.class);
        return meal;
    }

    public String getFoodJoke(){
        final String uri = apiURi+"food/jokes/random?"+apiKey;
        restTemplate = new RestTemplate();
        String joke = restTemplate.getForObject(uri, String.class);
        return joke;
    }

    public String getFoodTrivia(){
        final String uri = apiURi+"food/trivia/random?"+apiKey;
        restTemplate = new RestTemplate();
        String trivia = restTemplate.getForObject(uri, String.class);
        return trivia;
    }
}
