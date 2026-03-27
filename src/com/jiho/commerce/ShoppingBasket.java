package com.jiho.commerce;

import java.util.List;

//장바구니
public class ShoppingBasket {
    private final String productName; //상품명
    private final int quantity; //수량
    private final int priceInformation; //가격 정보

    public ShoppingBasket(String productName, int quantity, int priceInformation) {
        this.productName = productName;
        this.quantity = quantity;
        this.priceInformation = priceInformation;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPriceInformation() {
        return priceInformation;
    }
}
