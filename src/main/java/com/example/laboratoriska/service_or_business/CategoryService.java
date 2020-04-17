package com.example.laboratoriska.service_or_business;

import com.example.laboratoriska.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    List<Category> findAllByName(String categoryName);
    Category saveCategory(Category category);
    Category updateCategory(Long id, Category category);
    Category updateCategoryName(Long id, String categoryName);

    void deleteCategory(Long id);

}
