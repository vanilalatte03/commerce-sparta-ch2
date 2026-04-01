package com.jiho.commerce.order;

import com.jiho.commerce.io.InputConsole;
import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartItem;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private final InputConsole inputConsole;
    private final OrderView orderView;
    private final Cart cart;
    private final OrderService orderService;

    public OrderController(InputConsole inputConsole, OrderView orderView, Cart cart, OrderService orderService) {
        this.inputConsole = inputConsole;
        this.orderView = orderView;
        this.cart = cart;
        this.orderService = orderService;
    }

    /**
     * 장바구니를 출력하고 주문 확정 여부를 입력받아 주문을 진행한다.
     */
    public void showOrderMenu() {
        orderView.printOrderItems(cart);
        orderView.printOrderActionMenu();
        int chooseOrder = inputConsole.readInt();

        if (chooseOrder == 1) {
            //checkout()이 장바구니를 비우기 전에 주문 결과 출력용 항목을 복사해 둔다
            List<CartItem> orderedItems = new ArrayList<>(cart.getItems());

            int totalPrice = orderService.checkout(cart);

            orderView.printOrderCompleted(totalPrice);
            orderView.printStockChanges(orderedItems);
        }
    }

    //주문 취소
    public void cancel() {
        cart.clear();
        orderView.printCancelOrderMessage();
    }
}
