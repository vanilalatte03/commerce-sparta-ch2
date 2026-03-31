package com.jiho.commerce.order;

import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartItem;
import com.jiho.commerce.product.Product;

import java.util.List;

public class OrderView {

    //장바구니 내역
    void printOrderItems(Cart cart) {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ 장바구니 내역 ]");

        List<CartItem> basketItems = cart.getItems();
        for (int i = 0; i < basketItems.size(); i++) {
            CartItem basket = basketItems.get(i);
            Product product = basket.getProduct();

            System.out.printf("%d. %-11s | %,10d원 | 수량: %s개\n",
                    i + 1,
                    product.getProductName(),
                    product.getPrice(),
                    basket.getQuantity());
        }
        System.out.println("[ 총 주문 금액 ]");
        System.out.printf("%,10d원\n\n", cart.getTotalPrice());
    }

    //장바구니 주문 메뉴
    void printOrderActionMenu() {
        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");
    }

    void printStockChanges(List<CartItem> orderedItems) {
        for (CartItem cartItem : orderedItems) {
            Product product = cartItem.getProduct();

            //재고 감소 후
            int afterStock = product.getStock();
            //재고 감소 전
            int beforeStock = afterStock + cartItem.getQuantity();

            System.out.printf("%s 재고가 %d개 -> %d개로 변경되었습니다.%n",
                    product.getProductName(),
                    beforeStock,
                    afterStock);
        }
    }


    //주문 완료
    void printOrderCompleted(int totalPrice) {
        System.out.printf("주문이 완료되었습니다! 총 금액: %,10d원\n", totalPrice);
    }

    //주문 취소
    void printCancelOrderMessage() {
        System.out.println("주문 취소");
    }

}
