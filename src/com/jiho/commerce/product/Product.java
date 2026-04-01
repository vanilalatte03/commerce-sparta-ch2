package com.jiho.commerce.product;

/**
 * 상품명, 가격, 설명, 재고를 보관하는 도메인 객체다.
 * 현재 값 검증은 서비스에서 수행하고, 이 클래스는 상태 변경을 담당한다.
 */
public class Product {
    private final String productName; //상품명
    private int price; //가격
    private String description; //설명
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
     * 주문 수량 만큼 재고를 차감한다.
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

    public void updatePrice(int price) {
        this.price = price;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateStock(int stock) {
        this.stock = stock;
    }

}
