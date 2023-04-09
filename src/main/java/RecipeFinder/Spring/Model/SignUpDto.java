package RecipeFinder.Spring.Model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class SignUpDto {
	String email;
	String password;
}
