package com.jiho.commerce.app;

import com.jiho.commerce.*;
import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartScreen;
import com.jiho.commerce.cart.CartView;
import com.jiho.commerce.catalog.CatalogScreen;
import com.jiho.commerce.catalog.Category;
import com.jiho.commerce.catalog.Product;

import java.util.*;

public class CommerceSystem {
    private final List<Category> categories;
    private final Cart cart;
    private final CartScreen cartScreen;
    private final CatalogScreen catalogScreen;
    private final InputConsole inputConsole;
    private final OutputConsole outputConsole;

    public CommerceSystem(List<Category> categories, Cart cart, CartScreen cartScreen, CatalogScreen catalogScreen, InputConsole inputConsole, OutputConsole outputConsole) {
        this.categories = categories;
        this.cart = cart;
        this.cartScreen = cartScreen;
        this.catalogScreen = catalogScreen;
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
    }

    public void start() {
        while (true) {
            outputConsole.printMenu(categories, cart);

            int chooseCategory = inputConsole.readInt();

            int cartMenuNumber = categories.size() + 1;
            int cancelMenuNumber = categories.size() + 2;

            //장바구니 확인
            if (!cart.isEmpty() && chooseCategory == cartMenuNumber) {
                cartScreen.show();
                continue;
            }

            //주문 취소
            if (!cart.isEmpty() && chooseCategory == cancelMenuNumber) {
                outputConsole.printCancelOrderMessage();
                cart.clear();
                continue;
            }

            if (chooseCategory == 0) {
                outputConsole.printExitMessage();
                return;
            } else if (chooseCategory < 0 || chooseCategory > categories.size()) { //예외
                outputConsole.printInvalidCategoryMessage();
                continue;
            }

            Category selectedCategory = categories.get(chooseCategory - 1);
            catalogScreen.show(selectedCategory);

        }
    }

}

