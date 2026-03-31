package com.jiho.commerce.order;

import com.jiho.commerce.InputConsole;
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

    public void showOrderMenu() {
        orderView.printOrderItems(cart);
        orderView.printOrderActionMenu();
        int chooseOrder = inputConsole.readInt();

        if (chooseOrder == 1) {
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
