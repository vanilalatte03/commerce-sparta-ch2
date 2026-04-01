package com.jiho.commerce.product;


import java.util.List;

public class ProductService {

    public boolean addProduct(Category category, String productName, int price, String description, int stock) {
        if (category.hasProductName(productName)) {
            return false;
        }

        Product product = new Product(productName, price, description, stock);
        category.addProduct(product);
        return true;
    }

    public Product findProductByName(List<Category> categories, String productName) {
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.getProductName().equals(productName.trim())) {
                    return product;
                }
            }
        }
        return null;
    }

    public boolean deleteProduct(List<Category> categories, Product targetProduct) {
        for (Category category : categories) {
            if (category.removeProduct(targetProduct)) {
                return true;
            }
        }
        return false;
    }



}
