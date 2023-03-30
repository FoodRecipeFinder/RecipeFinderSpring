package RecipeFinder.Spring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="userData")
@ToString(includeFieldNames = true)
@Getter
@Setter
public class User {
	@Id
	@SequenceGenerator(name = "user_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "user_seq",strategy = GenerationType.AUTO)
	private int userId;
	private String email;
	private String password;
	
}
