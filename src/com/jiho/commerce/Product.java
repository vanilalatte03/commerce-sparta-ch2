package com.jiho.commerce;

//상품
public class Product {
    private final String productName; //상품명
    private final int price; //가격
    private final String description; //설명
    private final int stock; //재고

    public Product(String productName, int price, String description, int stock) {
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
