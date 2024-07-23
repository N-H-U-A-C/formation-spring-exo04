package dev.cb.business.domain;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Category {

    private UUID id;
    @NotBlank(message = "Name may not be null or blank")
    private String name;
    @NotBlank(message = "Description may not be null or blank")
    private String description;

    public Category() {
    }

    public Category(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
