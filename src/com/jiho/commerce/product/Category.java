package com.jiho.commerce.product;

import java.util.List;

/**
 * 하나의 카테고리와 그 안에 속한 상품 목록을 관리한다.
 */
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

    /**
     * 현재 카테고리 안에서 같은 이름의 상품이 이미 존재하는지 검사한다.
     *
     * @param productName 검사할 상품명
     * @return 중복 상품이 있으면 true, 없으면 false
     */
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
