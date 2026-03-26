package com.jiho.commerce;

public class Product {

    private final String productName;
    private final int price;
    private final String description;
    private final int stock;

    Product(String productName, int price, String description, int stock) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }


    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
