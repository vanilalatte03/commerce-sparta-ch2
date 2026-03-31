package com.jiho.commerce.cart;

import com.jiho.commerce.catalog.Product;

//장바구니
public class CartItem {
    private final Product product; //상품명, 가격
    private final int quantity; //수량

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    /*
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }*/

}
