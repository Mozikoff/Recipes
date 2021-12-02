package recipes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.model.Recipe;

@RestController
public class RecipesController {

    private Recipe recipe = new Recipe();

    @GetMapping("/api/recipe")
    public Recipe getRecipe() {
        return recipe;
    }

    @PostMapping("/api/recipe")
    public void overrideRecipe(@RequestBody Recipe newRecipe) {
        recipe = newRecipe;
    }
}
