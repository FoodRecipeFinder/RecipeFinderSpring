package RecipeFinder.Spring.Controller;

import RecipeFinder.Spring.Service.SpoonacularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spoonacular")
public class SpoonacularController {
    @Autowired
    SpoonacularService spoonacularService;
    @GetMapping(value = "/guessNutrition",produces = MediaType.APPLICATION_JSON_VALUE)
    public String guessNutritionByName(@RequestParam String name){
        return spoonacularService.guessNutritionByName(name);
    }
    @GetMapping(value = "/joke",produces = MediaType.APPLICATION_JSON_VALUE)
    public String foodJoke(){
        return spoonacularService.getFoodJoke();
    }
    @GetMapping(value = "/trivia",produces = MediaType.APPLICATION_JSON_VALUE)
    public String foodTrivia(){
        return spoonacularService.getFoodTrivia();
    }

}
