package com.jiho.commerce.order;

import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartItem;
import com.jiho.commerce.product.Product;

public class OrderService {
    /**
     * 장바구니 총액을 계산하고 각 상품 재고를 차감한 뒤 장바구니를 비운다.
     *
     * @param cart 주문할 장바구니
     * @return 주문 총 금액
     */
    public int checkout(Cart cart) {
        int totalPrice = cart.getTotalPrice();

        for (CartItem cartItem : cart.getItems()) {
            Product product = cartItem.getProduct();
            product.decreaseStock(cartItem.getQuantity());
        }

        cart.clear();
        return totalPrice;
    }
}
