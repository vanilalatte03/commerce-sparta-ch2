package com.jiho.commerce.app;

import com.jiho.commerce.*;
import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartScreen;
import com.jiho.commerce.catalog.CatalogScreen;
import com.jiho.commerce.catalog.Category;

import java.util.*;

/**
 * 메인 메뉴를 반복 실행하며 카테고리 조회, 장바구니 확인, 주문 취소 흐름으로 분기
 */
public class CommerceSystem {
    private final List<Category> categories;
    private final Cart cart;
    private final CartScreen cartScreen;
    private final CatalogScreen catalogScreen;
    private final InputConsole inputConsole;
    private final MainView mainView;

    public CommerceSystem(List<Category> categories, Cart cart, CartScreen cartScreen, CatalogScreen catalogScreen, InputConsole inputConsole, MainView mainView) {
        this.categories = categories;
        this.cart = cart;
        this.cartScreen = cartScreen;
        this.catalogScreen = catalogScreen;
        this.inputConsole = inputConsole;
        this.mainView = mainView;
    }

    public void start() {
        while (true) {
            mainView.printMenu(categories, cart);

            int chooseCategory = inputConsole.readInt();

            //카테고리 개수에 따라 뒤에 동적으로 번호 변경
            int cartMenuNumber = categories.size() + 1;
            int cancelMenuNumber = categories.size() + 2;

            //장바구니 확인
            if (!cart.isEmpty() && chooseCategory == cartMenuNumber) {
                cartScreen.show();
                continue;
            }

            //주문 취소
            if (!cart.isEmpty() && chooseCategory == cancelMenuNumber) {
                cartScreen.cancel();
                continue;
            }

            if (chooseCategory == 0) {
                mainView.printExitMessage();
                return;
            } else if (chooseCategory < 0 || chooseCategory > categories.size()) {
                //예외 처리
                mainView.printInvalidCategoryMessage();
                continue;
            }

            Category selectedCategory = categories.get(chooseCategory - 1);
            catalogScreen.show(selectedCategory);

        }
    }
}

