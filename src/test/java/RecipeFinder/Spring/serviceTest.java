package RecipeFinder.Spring;


import java.time.LocalDateTime;

import javax.print.DocFlavor.SERVICE_FORMATTED;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import RecipeFinder.Spring.Dao.RecipeFinderDao;
import RecipeFinder.Spring.Model.User;
import RecipeFinder.Spring.Service.RecipeFinderService;

@SpringBootTest
class serviceTest {
	@Autowired RecipeFinderDao dao;
	@Autowired RecipeFinderService service;
//	@Test
//	void emailExists() {
//		System.out.println(dao.emailExist("harshalaardekar@gmail.com"));
//		System.out.println("user : "+dao.searchUserByEmail("harshalaardekar101@gmail.com"));
//	}
	
//	@Test
//	void signupTest() {
//		User user= new User();
////		user.setUserId(1014);
//		user.setEmail("ardekarharshala16@gmail.com");
//		user.setPassword("123");
////		user.setOne_time_password(78763);
////		user.setOtp_captured_time(LocalDateTime.now());
//		service.signup(user);
//		System.out.println(user);
//	}
	
	
//	@Test 
//	void otpTest() {
//		System.out.println (service.sendOtp("harshalaardekar101@gmail.com"));
//	}
	
//	@Test
//	void isOtpValid() {
//		System.out.println(service.isOtpValid(39580, "harshalaardekar101@gmail.com"));
//	}
//	
//	@Test
//	void loginTest() {
//		System.out.println(service.loginByPassword("harshalaardekar101@gmail.com","1234"));
//	}

	

}
