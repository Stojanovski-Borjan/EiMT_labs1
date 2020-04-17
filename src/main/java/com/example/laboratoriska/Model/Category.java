package com.example.laboratoriska.Model;

import javax.validation.constraints.NotBlank;

public class Category {
    private Long id;

    @NotBlank(message = "You must enter Category Name")
    private String categoryName;

    @NotBlank(message = "You must enter Category Description")
    private String categoryDescription;

    public Category(){}

    public Category(Long id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
