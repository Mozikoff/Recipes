package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.model.Recipe;
import recipes.model.RecipeNewResponse;
import recipes.model.RecipesManager;

import java.util.Objects;

@RestController
public class RecipesController {

    @Autowired
    RecipesManager manager;

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        Recipe recipe = manager.getRecipeWithId(id);
        if (Objects.isNull(recipe)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipe;
    }

    @PostMapping("/api/recipe/new")
    public RecipeNewResponse overrideRecipe(@RequestBody Recipe newRecipe) {
        return new RecipeNewResponse(manager.addRecipe(newRecipe));
    }
}
