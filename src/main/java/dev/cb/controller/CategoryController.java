package dev.cb.controller;

import dev.cb.business.domain.Category;
import dev.cb.business.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/save")
    public String getSaveForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Category category, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            categoryService.save(category);
            return "redirect:/categories";
        } else {
            return "categories/form";
        }
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "/categories/list";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable UUID id, Model model) {
        Optional<Category> optionalCategory = categoryService.getById(id);
        //TODO handle if optional is empty
        optionalCategory.ifPresent(category -> model.addAttribute("category", category));
        return "categories/form";
    }

    @PostMapping("/update/{id}")
    public String upgrade(@Valid @ModelAttribute Category category, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            categoryService.update(category);
            return "redirect:/categories";
        } else {
            return "categories/form";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}
