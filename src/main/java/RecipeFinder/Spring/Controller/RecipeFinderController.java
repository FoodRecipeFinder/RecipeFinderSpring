package RecipeFinder.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import RecipeFinder.Spring.Model.SavedRecipes;
import RecipeFinder.Spring.Model.User;
import RecipeFinder.Spring.Service.RecipeFinderService;

@RestController
@RequestMapping("/RecipeFinder")
public class RecipeFinderController {
	
	@Autowired
	RecipeFinderService service;
	
	@PostMapping(value = "/signup")
	public String signup(@RequestBody User user) {
		return service.signup(user);
	}

	@GetMapping(value="/login")
	public boolean login(@RequestParam String email, String password) {
		return service.login(email, password);
	}
	
	@PostMapping(value = "/saveRecipe")
	public boolean saveRecipe(@RequestParam int userId,int mealId) {
		return service.saveRecipe(userId,mealId);
	}
	
	@GetMapping(value = "/getSavedRecipes/{userId}")
	public List<SavedRecipes> getSavedRecipes(@PathVariable int userId){
		return service.getSavedRecipes(userId);
	}
	
	@DeleteMapping(value ="/removeRecipe/{recipeId}")
	public boolean removeRecipe(@PathVariable int recipeId) {
		return service.removeRecipe(recipeId);
	}
	
	@GetMapping(value = "/checkIfSaved")
	public boolean checkIfSaved(@RequestParam int userId,int mealId) {
		return service.checkIfSaved(userId,mealId);
	}
//	
    
}
