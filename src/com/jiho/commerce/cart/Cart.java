package com.jiho.commerce.cart;

import com.jiho.commerce.product.Product;

import java.util.Collections;
import java.util.List;

/**
 * 장바구니 항목을 관리하고 총 금액을 계산하는 도메인 객체다.
 */
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
     * @param product 장바구니에 추가할 상품
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

        //현재 구현은 같은 상품 수량을 합치지 않고 CartItem을 새로 추가한다.
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

    /**
     * 특정 상품을 참조하는 장바구니 항목을 모두 제거한다.
     *
     * @param product 장바구니에서 제거할 상품
     */
    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct() == product);
    }

}
