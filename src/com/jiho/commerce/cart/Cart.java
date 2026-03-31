package com.jiho.commerce.cart;

import com.jiho.commerce.catalog.Product;

import java.util.Collections;
import java.util.List;

//장바구니로 하는 일들
public class Cart {
    private final List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    //장바구니가 비었는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * 장바구니 항목을 읽기 전용으로 반환한다.
     *
     * @return 수정할 수 없는 장바구니 항목 목록
     */
    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * 상품을 장바구니에 1개 추가한다.
     * 이미 장바구니에 담긴 동일 상품 수량까지 포함해 재고를 검사한다.
     *
     * @param product 추가할 상품
     * @return 장바구니 추가 성공 여부
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

    //최종 가격
    public int getTotalPrice() {
        int sumPrice = 0;
        for (CartItem basket : items) {
            sumPrice += basket.getProduct().getPrice() * basket.getQuantity();
        }
        return sumPrice;
    }

    //장바구니 비우기
    public void clear() {
        items.clear();
    }
}
