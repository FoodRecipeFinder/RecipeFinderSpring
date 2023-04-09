package RecipeFinder.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import RecipeFinder.Spring.Model.SavedRecipes;
import RecipeFinder.Spring.Model.User;
import RecipeFinder.Spring.Service.RecipeFinderService;

@RestController
@RequestMapping("/RecipeFinder")
@CrossOrigin("*")
public class RecipeFinderController {
	
	@Autowired
	RecipeFinderService service;

	@PostMapping(value="/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean signup(@RequestBody User user) {
		return service.signup(user);
	}

	@GetMapping(value="/loginByPassword")
	public boolean loginByPassword(@RequestParam String email, String password) {
		return service.loginByPassword(email, password);
	}
	
	@GetMapping(value="/loginByOtp")
	public boolean loginByOtp(@RequestParam String email, int otp) {
		return service.isOtpValid(otp,email);
	}
	
	@PutMapping(value="/sendOtp")
	public boolean sendOtp(@RequestParam String email) {
		return service.sendOtp(email);
	}
	
	@GetMapping(value = "/isEmailExists/{email}")
	public boolean isEmailExists(@PathVariable String email) {
		return service.isEmailExist(email);
	}
	
	@GetMapping(value="/searchUserByEmail/{email}")
	public User searchUserByEmail(@PathVariable String email) {
		return service.searchUserByEmail(email);
	}
	
	@GetMapping(value="/searchUserById/{userId}")
	public User searchUserById(@PathVariable int userId) {
		return service.searchUserBtId(userId);
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
	
	@GetMapping(value = "/getSavedRecipeId")
	public int getSavedRecipeId(@RequestParam int userId,int mealId) {
		return service.getSavedRecipeId(userId, mealId);
	}
    
}
