package RecipeFinder.Spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RecipeFinder")
public class RecipeFinderController {
    @GetMapping
    public String check(){
        return "check pass";
    }

}
