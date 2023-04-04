package RecipeFinder.Spring.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MealDBService {
    RestTemplate restTemplate;
    final String apiURi = "https://www.themealdb.com/api/json/v1/1/";
    public static String dictToList(String dict){
        //to convert json meals dict to list
        return dict.substring(9,dict.length()-1);
    }
    public String randomMeal(){
        final String uri = apiURi+"random.php";
        restTemplate = new RestTemplate();
        String meal= restTemplate.getForObject(uri, String.class);
        return meal;
    }
    
    public String searchMeal(String name){
        final String uri = apiURi+"search.php?s="+name;
        restTemplate = new RestTemplate();
        String meal = restTemplate.getForObject(uri, String.class);
        return meal;
    }
    
    public String findMealById(Integer id){
        final String uri = apiURi+"lookup.php?i="+id;
        restTemplate = new RestTemplate();
        String meal = restTemplate.getForObject(uri, String.class);
        return meal;
    }
    
    public String list(Character type){
        final String uri = apiURi+"list.php?"+type+"=list";
        restTemplate = new RestTemplate();
        String meal = restTemplate.getForObject(uri, String.class);
        return dictToList(meal);
    }
    
    public String filter(Character type, String ingredient){
        final String uri = apiURi+"filter.php?"+type+"="+ingredient;
        restTemplate = new RestTemplate();
        String meal = restTemplate.getForObject(uri, String.class);
        return meal;
    }
    
    

}
