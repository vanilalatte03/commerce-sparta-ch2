package com.jiho.commerce.product;

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

    public boolean hasProductName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName.trim())) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }
}
