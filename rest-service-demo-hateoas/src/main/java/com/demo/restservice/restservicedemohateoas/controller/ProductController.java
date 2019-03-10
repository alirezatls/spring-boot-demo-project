package com.demo.restservice.restservicedemohateoas.controller;

import com.demo.restservice.restservicedemohateoas.dto.ProductDto;
import com.demo.restservice.restservicedemohateoas.exception.NoSuchCategoryException;
import com.demo.restservice.restservicedemohateoas.exception.NoSuchProductException;
import com.demo.restservice.restservicedemohateoas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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
        Optional<List<ProductDto>> dtos = productService.fetchAllProductByCategoryId(categoryId);
        if(dtos.get().size() == 0) {
            throw new NoSuchCategoryException("No Such Category with id "+categoryId);
        }
        return dtos.get();

    }


    /**
     * fetch a product by id
     * @param productId is identity of product
     * @return an object of product or else throw an exception
     */
    @GetMapping(path = "/api/demo/categories/products/{productId}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Resource<ProductDto> getProduct(@PathVariable(name = "productId") int productId) {
        Optional<ProductDto> productDto = productService.fechProductByIdAndCategoryId(productId);

        Resource<ProductDto> resource = new Resource<ProductDto>(productDto.orElseThrow(NoSuchProductException::new));

        Link link = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).getAllProduct()
        ).withRel("all_products");

        resource.add(link);

        return resource;
    }

    /**
     *  ##INSERT A NEW PRODUCT##
     * @param productDto is object that must save
     */
    @PostMapping(path = "/api/demo/categories/products",consumes = {"application/json"})
    public ResponseEntity<Object> addNewProduct(@RequestBody ProductDto productDto) {
        ProductDto product = productService.insertProduct(productDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getProductId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     *  ##DELETE A PRODUCT WITH ID##
     * @param productId is identity of product
     */
    @DeleteMapping(path = "/api/demo/categories/products/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int productId) {

        int i = productService.deleteProduct(productId);
        if(i == 0) {
            throw new NoSuchProductException("no such product with id "+productId);
        }
        return ResponseEntity.ok(i);
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
