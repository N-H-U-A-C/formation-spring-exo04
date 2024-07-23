package dev.cb.business.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class Recipe {

    private UUID id;
    @NotBlank(message = "Name may not be null or blank")
    private String name;
    //TODO check validation and list
    private List<String> ingredients;
    @NotBlank(message = "Instruction may not be null or blank")
    private String instruction;
//    @NotNull(message = "Category may not be null")
    private Category category;

    public Recipe() {
    }

    public Recipe(UUID id, String name, List<String> ingredients, String instruction, Category category) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
