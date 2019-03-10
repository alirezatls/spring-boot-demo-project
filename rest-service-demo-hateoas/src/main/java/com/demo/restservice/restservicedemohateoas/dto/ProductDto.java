package com.demo.restservice.restservicedemohateoas.dto;

import java.math.BigDecimal;

public class ProductDto {
    private int productId;
    private String productName;
    private String productCode;
    private BigDecimal productPrice;
    private boolean productState;
    private int categoryFk;

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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public boolean isProductState() {
        return productState;
    }

    public int getCategoryFk() {
        return categoryFk;
    }
}
