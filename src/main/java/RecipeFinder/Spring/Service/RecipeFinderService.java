package RecipeFinder.Spring.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RecipeFinder.Spring.Dao.RecipeFinderDao;
import RecipeFinder.Spring.Model.SavedRecipes;
import RecipeFinder.Spring.Model.User;

@Service
public class RecipeFinderService {
	@Autowired
	RecipeFinderDao dao;
	
	@Autowired EmailService emailService;
	
	public boolean isEmailExist(String email) {
		return dao.emailExist(email);
	}
	
	public User searchUserByEmail(String email) {
		return dao.searchUserByEmail(email);
	}
	
	public User searchUserBtId(int userId) {
		return dao.searchUserById(userId);
	}
	
	public boolean signup(User u) {
//		User u = new User();
//		u.setEmail(email);
//		u.setPassword(password);
		if(dao.addOrUpdateUser(u)!= null) 
			return true;
		else
			return false;
	}
	
	
	public boolean sendOtp(String email) {
		try {
			Random random = new Random(); 
			int otp = random.nextInt(100000, 999999);
			LocalDateTime otp_capturedTime = LocalDateTime.now();
			String text = "Hi,\nYour One Time Registration Password is : "+otp+
					"\nNote : This password will be valid for 5 minutes";
			String subject = "OTP for registration";
			
			System.out.println(otp +" vd  "+otp_capturedTime);
			User user = dao.searchUserByEmail(email);
			user.setOne_time_password(otp);
			user.setOtp_captured_time(otp_capturedTime);
//			System.out.println("user : "+user);
			
			if(dao.addOrUpdateUser(user)!=null) {
				emailService.sendOtp(user.getEmail(), text, subject);
				System.out.println("Email Sent");
				return true;
			}
			else
				return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	loginbyotp
	public boolean isOtpValid(int otp,String email) {
		User user = dao.searchUserByEmail(email);
		long timeDiffernce = ChronoUnit.MINUTES.between(user.getOtp_captured_time(),LocalDateTime.now());
		System.out.println(timeDiffernce);
		return timeDiffernce<6 && timeDiffernce>=0 && user.getOne_time_password()==otp ?true:false;
	}
	

	
	public boolean loginByPassword(String email,String password) {
		return dao.searchUserByEmail(email).getPassword().equals(password) ? true:false;
	}
	
	
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
