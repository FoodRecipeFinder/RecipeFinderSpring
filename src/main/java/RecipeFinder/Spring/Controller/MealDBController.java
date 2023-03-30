package RecipeFinder.Spring.Controller;

import RecipeFinder.Spring.Service.MealDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mealDB")
public class MealDBController {
	
    @Autowired
    MealDBService mealDBService;
    
    @GetMapping(value ="/random",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRandomMealDB(){
        return mealDBService.randomMeal();
    }
    
    @GetMapping(value ="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchMealDB(@RequestParam String name){
        return mealDBService.searchMeal(name);
    }
    
    @GetMapping(value ="/lookup",produces = MediaType.APPLICATION_JSON_VALUE)
    public String findMealDB(@RequestParam Integer id){
        return mealDBService.findMealById(id);
    }
    
    @GetMapping(value ="/list/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(@PathVariable Character type){
        //c->category,a->region,i->ingredients
        return mealDBService.list(type);
    }
    
    @GetMapping(value ="/filter/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String filter(@PathVariable Character type,@RequestParam String name){
        return mealDBService.filter(type,name);
    }

}
