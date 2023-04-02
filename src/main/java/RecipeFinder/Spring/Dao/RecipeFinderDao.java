package RecipeFinder.Spring.Dao;

import org.springframework.stereotype.Repository;

import RecipeFinder.Spring.Model.SavedRecipes;
import RecipeFinder.Spring.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class RecipeFinderDao{
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

	public User searchUserById(int userId) {
		return em.find(User.class, userId);
	}
	@Transactional
	public SavedRecipes saveRecipe(SavedRecipes sr) {
		return em.merge(sr);
	}

	
	
	public boolean checkIfSaved(int userId,int mealId) {
		User user = searchUserById(userId);
		System.out.println(mealId);
		boolean res  = false;
		
		for(SavedRecipes recipe: user.getSavedRecipes()) {
			if(recipe.getMealId() == mealId) {
				res=true;
				break;
			}
		}
		return res;
	}
	
	
	@Transactional
	public void deleteRecipe(int recipeId) {
		String jpql="delete from SavedRecipes c where id=:recipeId";
	    Query query = em.createQuery(jpql);
	    query.setParameter("recipeId", recipeId).executeUpdate();
	    System.out.println("deleted");
	}
		
}
