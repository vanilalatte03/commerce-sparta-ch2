package com.jiho.commerce.order;

import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartItem;
import com.jiho.commerce.catalog.Product;

public class OrderService {
    /**
     * 장바구니의 모든 상품을 주문 처리한다.
     * 재고를 차감하고 총 금액을 반환한 뒤 장바구니를 비운다.
     *
     * @param cart 주문할 장바구니
     * @return 주문 총 금액
     */
    public int checkout(Cart cart) {
        int totalPrice = cart.getTotalPrice();

        for (CartItem cartItem : cart.getItems()) {
            Product product = cartItem.getProduct();

            int beforeStock = product.getStock();
            product.decreaseStock(cartItem.getQuantity());
            int afterStock = product.getStock();

            //출력 분리 못한거
            System.out.printf("%s 재고가 %d개 -> %d개로 변경되었습니다.%n",
                    product.getProductName(),
                    beforeStock,
                    afterStock);
        }

        cart.clear();
        return totalPrice;
    }
}
