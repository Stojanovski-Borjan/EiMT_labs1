package com.example.laboratoriska.service_or_business.Impl;

import com.example.laboratoriska.Model.Category;
import com.example.laboratoriska.Model.exception.CategoryNotFoundException;
import com.example.laboratoriska.persistence_or_repository.CategoryRepository;
import com.example.laboratoriska.service_or_business.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    public final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(()
                -> new CategoryNotFoundException(id));
    }

    @Override
    public List<Category> findAllByName(String categoryName) {
        return this.categoryRepository.findAllByName(categoryName);
    }

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.saveCategory(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category c = this.findById(id);
        c.setCategoryName(category.getCategoryName());
        c.setCategoryDescription(category.getCategoryDescription());
        return this.categoryRepository.saveCategory(c);
    }

    @Override
    public Category updateCategoryName(Long id, String categoryName) {
        Category c = this.findById(id);
        c.setCategoryName(categoryName);
        return this.categoryRepository.saveCategory(c);
    }


    @Override
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }

}
