package com.demo.restservice.restservicedemohateoas.controller;

import com.demo.restservice.restservicedemohateoas.dto.CategoryDto;
import com.demo.restservice.restservicedemohateoas.dto.ProductDto;
import com.demo.restservice.restservicedemohateoas.exception.NoSuchCategoryException;
import com.demo.restservice.restservicedemohateoas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
    public Resource<CategoryDto> getCategory(@PathVariable(name = "categoryId") int categoryId) {
        Optional<CategoryDto> category = categoryService.fetchCategoryById(categoryId);

        //Resource Of CategoryDto
        Resource<CategoryDto> resource = new Resource<CategoryDto>(category.orElseThrow(NoSuchCategoryException::new));

        //add all categorieslink
        Link linkToCategory = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).getAllCategory()
        ).withRel("all_categories").withType("json").withTitle("products");

        Link linkToProduct = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(ProductController.class).getAllProduct()
        ).withRel("all_products").withType("json").withTitle("products");

        //add link to resource
        resource.add(linkToCategory,linkToProduct);

        return resource;
    }

    /**
     * ##INSERT A CATEGORY##
     */
    @PostMapping(path = "/api/demo/categories", consumes = {"application/json"})
    public void addNewCategory() {

    }
}
