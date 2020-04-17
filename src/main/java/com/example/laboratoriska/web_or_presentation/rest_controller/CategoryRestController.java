package com.example.laboratoriska.web_or_presentation.rest_controller;

import com.example.laboratoriska.Model.Category;
import com.example.laboratoriska.service_or_business.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAllOrFindAllByName(@RequestParam(required = false) String categoryName){
        if(categoryName == null){
            return this.categoryService.findAll();
        }else{
            return this.categoryService.findAllByName(categoryName);
        }
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public Category saveCategory(@Valid Category category){
        return this.categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, Category category){
        return this.categoryService.updateCategory(id, category);
    }

    @PatchMapping("/{id}")
    public Category updateName(@PathVariable Long id, @RequestParam String categoryName){
        return this.categoryService.updateCategoryName(id, categoryName);
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        this.categoryService.deleteCategory(id);
    }
}
