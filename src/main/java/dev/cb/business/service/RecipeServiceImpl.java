package dev.cb.business.service;

import dev.cb.business.domain.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RecipeServiceImpl implements RecipeService {

    private final List<Recipe> recipes;

    public RecipeServiceImpl() {
        this.recipes = new ArrayList<>();
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
