package com.jiho.commerce.catalog;

import com.jiho.commerce.InputConsole;
import com.jiho.commerce.app.Screen;
import com.jiho.commerce.cart.Cart;

import java.util.List;

public class CatalogScreen {
    private final InputConsole inputConsole;
    private final CatalogView catalogView;
    private final Cart cart;

    public CatalogScreen(InputConsole inputConsole, CatalogView catalogView, Cart carts) {
        this.inputConsole = inputConsole;
        this.catalogView = catalogView;
        this.cart = carts;
    }

    public void show(Category category) {
        catalogView.printProductMenu(category);

        int chooseProduct = inputConsole.readInt();

        if (chooseProduct == 0) {
            catalogView.printBlankLine();
            return;
        }

        if (chooseProduct < 1 || chooseProduct > category.getProducts().size()) {
            catalogView.printInvalidProductMessage();
            return;
        }

        Product product = category.getProducts().get(chooseProduct - 1);
        catalogView.printChooseProduct(product);
        addCart(product);
    }

    //장바구니에 상품 추가
    public void addCart(Product product) {
        catalogView.printAddCartMenu();
        int chooseShoppingBaskets = inputConsole.readInt();

        if (chooseShoppingBaskets == 1) {
            if (cart.addProduct(product)) {
                catalogView.printAddCartSuccess(product);
            } else {
                catalogView.printSoldOutStockMessage();
            }
        }
    }
}
