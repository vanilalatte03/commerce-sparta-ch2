package com.jiho.commerce.product;


public class ProductService {

    public boolean addProduct(Category category, String productName, int price, String description, int stock) {
        if (category.hasProductName(productName)) {
            return false;
        }

        Product product = new Product(productName, price, description, stock);
        category.addProduct(product);
        return true;
    }

}
