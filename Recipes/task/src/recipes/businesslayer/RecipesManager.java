package recipes.businesslayer;

import org.springframework.stereotype.Component;
import recipes.businesslayer.Recipe;

import java.util.HashMap;
import java.util.Map;

@Component
public class RecipesManager {
    private int id = 0;
    private Map<Integer, Recipe> recipes = new HashMap<>();

    public int addRecipe(Recipe recipe) {
        recipes.put(++id, recipe);
        return id;
    }

    public Recipe getRecipeWithId(int id) {
        return recipes.get(id);
    }
}
