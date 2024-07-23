package dev.cb.business.service;

import dev.cb.business.domain.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final List<Category> categories;

    public CategoryServiceImpl() {
        this.categories = new ArrayList<>();
        this.categories.add(new Category(UUID.randomUUID(), "First course", "First course"));
        this.categories.add(new Category(UUID.randomUUID(), "Main course", "Main course"));
        this.categories.add(new Category(UUID.randomUUID(), "Dessert", "Dessert"));
    }

    // basic CRUD
    public boolean save(Category category) {
        category.setId(UUID.randomUUID());
        return categories.add(category);
    }

    public List<Category> getAll() {
        return categories;
    }

    public Optional<Category> getById(UUID id) {
        return categories.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public boolean update(Category updatedCategory) {
        Optional<Category> optionalCategory = getById(updatedCategory.getId());
        if (optionalCategory.isPresent()) {
            updateFields(optionalCategory.get(), updatedCategory);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(UUID id) {
        return categories.removeIf(c -> c.getId().equals(id));
    }

    // business logic
    private void updateFields(Category category, Category updatedCategory) {
        category.setName(updatedCategory.getName());
        category.setDescription(updatedCategory.getDescription());
    }
}
