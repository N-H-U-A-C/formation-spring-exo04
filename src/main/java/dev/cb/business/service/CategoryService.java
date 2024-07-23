package dev.cb.business.service;

import dev.cb.business.domain.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    boolean save(Category recipe);

    List<Category> getAll();

    Optional<Category> getById(UUID id);

    boolean update(Category recipe);

    boolean delete(UUID id);

    List<Category> getCategories();
}
