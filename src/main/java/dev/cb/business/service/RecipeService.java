package dev.cb.business.service;

import dev.cb.business.domain.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecipeService {

    boolean save(Recipe recipe);

    List<Recipe> getAll();

    Optional<Recipe> getById(UUID id);

    boolean update(Recipe recipe);

    boolean delete(UUID id);
}
