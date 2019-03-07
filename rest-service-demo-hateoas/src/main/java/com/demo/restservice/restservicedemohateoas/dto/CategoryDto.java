package com.demo.restservice.restservicedemohateoas.dto;

public class CategoryDto {

    private int categoryPk;
    private String categoryName;
    private String categoryCode;

    public CategoryDto() {
    }

    public int getCategoryPk() {
        return categoryPk;
    }

    public String getName() {
        return categoryName;
    }

    public String getCode() {
        return categoryCode;
    }
}
