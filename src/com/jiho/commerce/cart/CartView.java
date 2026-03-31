package com.jiho.commerce.cart;

import com.jiho.commerce.app.Screen;
import com.jiho.commerce.catalog.Product;

import java.util.List;

public class CartView {

    //장바구니 내역
    public void printCartItems(Cart cart) {
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
    public void printCartActionMenu() {
        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");
    }

    //주문 완료
    public void printOrderCompleted(int totalPrice) {
        System.out.printf("주문이 완료되었습니다! 총 금액: %,10d원\n", totalPrice);
    }
}
