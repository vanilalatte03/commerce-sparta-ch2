package com.jiho.commerce.product;

//상품
public class Product {
    private final String productName; //상품명
    private final int price; //가격
    private final String description; //설명
    private int stock; //재고

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

    /**
     * 재고를 지정한 수량만큼 차감한다.
     *
     * @param quantity 차감할 수량
     */
    public void decreaseStock(int quantity) {
        this.stock -= quantity;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }


}
