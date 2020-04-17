package com.example.laboratoriska.persistence_or_repository;

import com.example.laboratoriska.Model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> findAll();
    List<Category> findAllByName(String categoryName);
    Optional<Category> findById(Long id);
    Category saveCategory(Category category);
    void deleteById(Long id);

}
