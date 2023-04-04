package RecipeFinder.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RecipeFinder.Spring.Dao.RecipeFinderDao;
import RecipeFinder.Spring.Model.SavedRecipes;
import RecipeFinder.Spring.Model.User;

@Service
public class RecipeFinderService {
	@Autowired
	RecipeFinderDao dao;
	
	public String signup(User user) {
		User u = dao.addUser(user);
		if(u!=null) 
			return "UserId : "+u.getUserId();
		else
			return "EmailId allready exist";
	}
	
	public boolean login(String email,String password) {
		return dao.login(email, password);
	}
	
//	public boolean saveRecipe(SavedRecipes sr) {
//		if(dao.saveRecipe(sr)!=null) 
//			return true;
//		else
//			return false;
//	}
	public boolean saveRecipe(int userId,int mealId) {
		User user = dao.searchUserById(userId);
		SavedRecipes sr =  new SavedRecipes();
		sr.setMealId(mealId);
		sr.setUser(user);
		if(dao.saveRecipe(sr)!=null) 
			return true;
		else
			return false;
	}
	
	public List<SavedRecipes> getSavedRecipes(int userId){
		return dao.searchUserById(userId).getSavedRecipes();
	}
	
	public boolean removeRecipe(int recipeId) {
		try {
			dao.deleteRecipe(recipeId);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		 
	}
	public boolean checkIfSaved(int userId,int mealId) {
		return dao.checkIfSaved(userId,mealId);
	}
	
	public int getSavedRecipeId(int userId,int mealId) {
		return dao.getSavedRecipeId(userId, mealId);
	}
}
