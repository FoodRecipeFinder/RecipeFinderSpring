package RecipeFinder.Spring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class SavedRecipes {
	@Id
	@SequenceGenerator(initialValue = 1000,allocationSize = 1, name = "sr_seq")
	@GeneratedValue(generator = "sr_seq", strategy = GenerationType.AUTO)
	private int id;
	private int userId;
	private int mealId;
		
}
