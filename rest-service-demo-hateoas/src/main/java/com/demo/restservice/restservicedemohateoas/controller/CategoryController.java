package com.demo.restservice.restservicedemohateoas.controller;

import com.demo.restservice.restservicedemohateoas.dto.CategoryDto;
import com.demo.restservice.restservicedemohateoas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     *  ##FETCH ALL Category##
     * @return List
     */
    @GetMapping(path = "/api/demo/categories", produces = {"application/json"})
    public List<CategoryDto> getAllCategory() {
       return categoryService.fetchAllCategory();
    }

    /**
     *  ##FETCH A CATEGORY WITH ID##
     * @param categoryId is identity of category
     * @return CategoryDto
     */
    @GetMapping(path = "/api/demo/categories/{categoryId}", produces = {"application/json"})
    public CategoryDto getCategory(@PathVariable(name = "categoryId") int categoryId) {
        Optional<CategoryDto> category = categoryService.fetchCategoryById(categoryId);
        return category.orElseThrow(IllegalStateException::new);
    }

    /**
     * ##INSERT A CATEGORY##
     */
    @PostMapping(path = "/api/demo/categories", consumes = {"application/json"})
    public void addNewCategory() {

    }
}
