package com.jiho.commerce.cart;

import com.jiho.commerce.product.Product;

import java.util.Collections;
import java.util.List;

//장바구니로 하는 일들
public class Cart {
    private final List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * 장바구니 항목을 읽기 전용으로 반환한다.
     *
     * @return 외부에서 수정할 수 없는 장바구니 항목 목록
     */
    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * 이미 장바구니에 담긴 동일 상품 수량까지 포함해 재고를 검사한다.
     * 상품을 장바구니에 1개 추가한다.
     *
     * @param product 추가할 상품
     * @return 재고 범위 내에서 추가되면 true, 아니면 false
     */
    public boolean addProduct(Product product) {
        int basketQuantity = 0;

        for (CartItem basket : items) {
            if (basket.getProduct() == product) {
                basketQuantity += basket.getQuantity();
            }
        }

        if (basketQuantity >= product.getStock()) {
            return false;
        }

        items.add(new CartItem(product, 1));
        return true;
    }

    public int getTotalPrice() {
        int sumPrice = 0;
        for (CartItem basket : items) {
            sumPrice += basket.getProduct().getPrice() * basket.getQuantity();
        }
        return sumPrice;
    }

    public void clear() {
        items.clear();
    }
}
