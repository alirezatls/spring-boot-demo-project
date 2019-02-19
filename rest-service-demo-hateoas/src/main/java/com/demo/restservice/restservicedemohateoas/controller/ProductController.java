package com.demo.restservice.restservicedemohateoas.controller;

import com.demo.restservice.restservicedemohateoas.dto.ProductDto;
import com.demo.restservice.restservicedemohateoas.exception.NoSuchProductException;
import com.demo.restservice.restservicedemohateoas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *  ##FETCH ALL PRODUCT##
     * @return list of all product of all categories
     */
    @GetMapping(path = "/api/demo/categories/products")
    public List<ProductDto> getAllProduct() {
        return productService.getAllProduct();
    }

    /**
     *  ##FETCH PRODUCTS OF A CATEGORY##
     * @param categoryId is identity
     * @return list of product of a category
     */
    @GetMapping(path = "/api/demo/categories/{categoryId}/products")
    public List<ProductDto> getAllProductOfSpecialCategory(@PathVariable(name = "categoryId") int categoryId) {
        return productService.fetchAllProductByCategoryId(categoryId);
    }

    /**
     *   ##FETCH A PRODUCT WITH ID##
     * @param productId is identity of product
     * @return an object of product or else throw an exception
     */
    @GetMapping(path = "/api/demo/categories/products/{productId}")
    public ProductDto getProduct(@PathVariable(name = "productId") int productId) {
        Optional<ProductDto> productDto = productService.fechProductByIdAndCategoryId(productId);
        return productDto.orElseThrow(NoSuchProductException::new);
    }

    /**
     *  ##INSERT A NEW PRODUCT##
     * @param productDto is object that must save
     */
    @PostMapping(path = "/api/demo/categories/products",consumes = {"application/json"})
    public void addNewProduct(ProductDto productDto) {
        productService.insertProduct(productDto);
    }

    /**
     *  ##DELETE A PRODUCT WITH ID##
     * @param productId is identity of product
     */
    @DeleteMapping(path = "/api/demo/categories/products/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
    }

    /**
     *  ##UPDATE A PRODUCT##
     * @param productId identity of product
     * @param productDto is an object that updated
     */
    @PutMapping(path = "/api/demo/categories/products/{productId}")
    public void updateProduct(int productId, ProductDto productDto) {

    }
}
