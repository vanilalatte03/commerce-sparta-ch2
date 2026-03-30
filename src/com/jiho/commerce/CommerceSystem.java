package com.jiho.commerce;

import java.util.*;

public class CommerceSystem {
    private final List<Category> categories;
    private final Cart cart;
    private final Scanner sc;
    private final OutputConsole outputConsole;

    public CommerceSystem(List<Category> categories, Cart carts, Scanner scanner, OutputConsole outputConsole) {
        this.categories = categories;
        this.cart = carts;
        this.sc = scanner;
        this.outputConsole = outputConsole;
    }

    void start() {
        while (true){
            outputConsole.printMenu(categories, cart);

            int chooseCategory = sc.nextInt();

            //장바구니 확인
            if (!cart.isEmpty() && chooseCategory == 4) {
                showShoppingBasket();
                continue;
            }

            //주문 취소
            if (!cart.isEmpty() && chooseCategory == 5) {
                outputConsole.printCancelOrderMessage();
                cart.clear();
                continue;
            }

            if (chooseCategory == 0) {
                outputConsole.printExitMessage();
                return;
            } else if (chooseCategory < 0 || chooseCategory > categories.size()){ //예외
                outputConsole.printInvalidCategoryMessage();
                continue;
            }

            Category category = categories.get(chooseCategory - 1);

            outputConsole.printProductMenu(category);

            int chooseProduct = sc.nextInt();

            if (chooseProduct == 0) {
                outputConsole.printBlankLine();
                continue;
            } else if (chooseProduct < 0|| chooseProduct > category.getProducts().size()) {//예외
                outputConsole.printInvalidProductMessage();
                continue;
            }

            Product product = category.getProducts().get(chooseProduct - 1);
            outputConsole.printChooseProduct(product);

            addShoppingBasket(product);


        }
    }

    //4.장바구니 확인
    void showShoppingBasket() {
        outputConsole.printShoppingBasket(cart);
        outputConsole.printOrderMenu();
        int chooseOrder = sc.nextInt();

        if (chooseOrder == 1){
            outputConsole.printOrderCompleted(cart.getTotalPrice());
            cart.checkout();
        }
    }

    //장바구니 추가
    void addShoppingBasket(Product product) {
        outputConsole.printAddShoppingBasketMenu();
        int chooseShoppingBaskets = sc.nextInt();

        if (chooseShoppingBaskets == 1) {
            if (cart.addProduct(product)) {
                outputConsole.printAddShoppingBasketSuccess(product);
            } else {
                outputConsole.printSoldOutStockMessage();
            }
        }
    }
}

