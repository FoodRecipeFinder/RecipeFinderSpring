package RecipeFinder.Spring.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import RecipeFinder.Spring.Model.SavedRecipes;
import RecipeFinder.Spring.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class RecipeFinderDao {
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public User addUser(User user) {
		if(!emailExist(user.getEmail())) 
			return em.merge(user);
		else 
			return null;
		
	}
	
	public boolean emailExist(String email) {
		String jpql = "select u from User u where u.email=: email"; 
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("email", email);
		
		if(query.getResultList().isEmpty()) {
			return false;
		}
		else
			return true;
	}
	
	public boolean login(String email,String password) {
		String jpql = "select u from User u where u.email=:email and u.password=:password";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		try {
			query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public SavedRecipes saveRecipe(SavedRecipes sr) {
		return em.merge(sr);
	}
	
	public List<SavedRecipes> getSavedRecipes(int userId){
		String jpql = "select a from SavedRecipes a where a.userId=:userId";
		TypedQuery<SavedRecipes> query = em.createQuery(jpql,SavedRecipes.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	
	@Transactional
	public boolean deleteRecipe(int recipeId) {
		SavedRecipes recipe = em.find(SavedRecipes.class, recipeId);
		
		try {
			if(recipe!=null) {
				em.remove(recipe);
			}
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkIfSaved(int userId,int mealId) {
		String jpql = "select a from SavedRecipes a where a.userId=:userId and a.mealId=:mealId";
		TypedQuery<SavedRecipes> query = em.createQuery(jpql,SavedRecipes.class);
		query.setParameter("userId", userId);
		query.setParameter("mealId", mealId);
		 
		if(query.getResultList().isEmpty()) 
			return false;
		else
			return true;
		
	}
}
