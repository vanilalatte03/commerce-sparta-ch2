package com.jiho.commerce.cart;

import com.jiho.commerce.product.Product;

/**
 * 장바구니 항목 한 건을 표현한다.
 * 현재 구조에서는 같은 상품이 여러 CartItem으로 나뉘어 저장될 수 있다.
 */
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

}
