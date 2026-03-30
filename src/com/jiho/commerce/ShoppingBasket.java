package com.jiho.commerce;

import java.util.List;

//장바구니
public class ShoppingBasket {
    private final Product product; //상품명, 가격

    private final int quantity; //수량

    public ShoppingBasket(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

/*    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }*/

}

