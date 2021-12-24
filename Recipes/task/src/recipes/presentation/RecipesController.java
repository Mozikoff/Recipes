package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.businesslayer.Recipe;
import recipes.businesslayer.RecipeNewResponse;
import recipes.businesslayer.RecipeService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class RecipesController {

    @Autowired
    RecipeService service;

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable long id) {
        Optional<Recipe> recipe = service.findRecipeById(id);
        if (recipe.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipe.get();
    }

    @PostMapping("/api/recipe/new")
    public RecipeNewResponse saveRecipe(@Valid @RequestBody Recipe newRecipe) {
        Recipe recipe = service.save(newRecipe);
        return new RecipeNewResponse(recipe.getId());
    }

    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity deleteRecipe(@PathVariable long id) {
        Optional<Recipe> recipe = service.findRecipeById(id);
        if (recipe.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        service.deleteRecipeById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
