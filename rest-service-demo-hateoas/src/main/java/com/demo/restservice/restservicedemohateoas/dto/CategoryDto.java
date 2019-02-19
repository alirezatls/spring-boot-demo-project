package com.demo.restservice.restservicedemohateoas.dto;

public class CategoryDto {

    private int categoryPk;
    private String name;
    private String code;

    public CategoryDto() {
    }

    public int getCategoryPk() {
        return categoryPk;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
