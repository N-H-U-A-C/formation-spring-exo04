package dev.cb.business.service;

import dev.cb.business.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final CategoryService categoryService;
    private final List<Recipe> recipes;

    public RecipeServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.recipes = new ArrayList<>();
        this.recipes.add(new Recipe(
                UUID.randomUUID(),
                "Recette1",
                Arrays.asList("Ingrédient1", "Ingrédient1", "Ingrédient1"),
                "Instruction1",
                categoryService.getCategories().get(0)
                ));
    }

    // basic CRUD
    public boolean save(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        return recipes.add(recipe);
    }

    public List<Recipe> getAll() {
        return recipes;
    }

    public Optional<Recipe> getById(UUID id) {
        return recipes.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public boolean update(Recipe updatedRecipe) {
        Optional<Recipe> optionalRecipe = getById(updatedRecipe.getId());
        if (optionalRecipe.isPresent()) {
            updateFields(optionalRecipe.get(), updatedRecipe);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(UUID id) {
        return recipes.removeIf(r -> r.getId().equals(id));
    }

    // business logic
    private void updateFields(Recipe recipe, Recipe updatedRecipe) {
        recipe.setName(updatedRecipe.getName());
        recipe.setIngredients(updatedRecipe.getIngredients());
        recipe.setInstruction(updatedRecipe.getInstruction());
        recipe.setCategory(updatedRecipe.getCategory());
    }
}
