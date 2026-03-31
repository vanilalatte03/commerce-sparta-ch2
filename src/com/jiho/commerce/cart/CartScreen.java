package com.jiho.commerce.cart;

import com.jiho.commerce.InputConsole;
import com.jiho.commerce.app.Screen;
import com.jiho.commerce.order.OrderService;

public class CartScreen implements Screen {
    private final InputConsole inputConsole;
    private final CartView cartView;
    private final Cart cart;
    private final OrderService orderService;

    public CartScreen(InputConsole inputConsole, CartView cartView,  Cart carts, OrderService orderService) {
        this.inputConsole = inputConsole;
        this.cartView = cartView;
        this.cart = carts;
        this.orderService = orderService;
    }

    @Override
    public void show() {
        cartView.printCartItems(cart);
        cartView.printCartActionMenu();
        int chooseOrder = inputConsole.readInt();

        if (chooseOrder == 1) {
            int totalPrice = orderService.checkout(cart);
            cartView.printOrderCompleted(totalPrice);
        }
    }
}
