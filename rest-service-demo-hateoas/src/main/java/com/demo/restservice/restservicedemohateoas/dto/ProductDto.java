package com.demo.restservice.restservicedemohateoas.dto;

import java.math.BigDecimal;

public class ProductDto {
    private int productId;
    private String productName;
    private String productCode;
    private BigDecimal productPrice;
    private boolean productState;
    private int categoryId;

    public ProductDto() {
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getProductPrice() {
        return productPrice.intValue();
    }

    public boolean isProductState() {
        return productState;
    }

    public int getCategoryId() {
        return categoryId;
    }
}