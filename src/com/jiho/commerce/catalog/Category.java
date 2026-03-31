package com.jiho.commerce.catalog;

import java.util.List;

//카테고리
public class Category {
    private final String categoryName; //카테고리 이름
    private final List<Product> products; // 상품 목록

    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
