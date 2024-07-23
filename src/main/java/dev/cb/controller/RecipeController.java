package dev.cb.controller;

import dev.cb.business.domain.Recipe;
import dev.cb.business.domain.Recipe;
import dev.cb.business.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/save")
    public String getSaveForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipes/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Recipe recipe, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            recipeService.save(recipe);
            return "redirect:/recipes";
        } else {
            return "recipes/form";
        }
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("recipes", recipeService.getAll());
        return "/recipes/list";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable UUID id, Model model) {
        Optional<Recipe> optionalRecipe = recipeService.getById(id);
        //TODO handle if optional is empty
        optionalRecipe.ifPresent(recipe -> model.addAttribute("recipe", recipe));
        return "recipes/form";
    }

    @PostMapping("/update/{id}")
    public String upgrade(@Valid @ModelAttribute Recipe recipe, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            recipeService.update(recipe);
            return "redirect:/recipes";
        } else {
            return "recipes/form";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        recipeService.delete(id);
        return "redirect:/recipes";
    }
}
