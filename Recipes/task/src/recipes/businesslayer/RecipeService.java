package recipes.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.persistence.RecipeRepository;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Optional<Recipe> findRecipeById(Long id) {
        return repository.findById(id);
    }

    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    public void deleteRecipeById(Long id) {
        repository.deleteById(id);
    }
}
