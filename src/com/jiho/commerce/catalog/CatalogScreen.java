package com.jiho.commerce.catalog;

import com.jiho.commerce.InputConsole;
import com.jiho.commerce.cart.Cart;

public class CatalogScreen {
    private final InputConsole inputConsole;
    private final CatalogView catalogView;
    private final Cart cart;

    public CatalogScreen(InputConsole inputConsole, CatalogView catalogView, Cart cart) {
        this.inputConsole = inputConsole;
        this.catalogView = catalogView;
        this.cart = cart;
    }

    /**
     * 카테고리의 상품 목록을 보여주고, 상품 선택 또는 이전 메뉴 복귀를 처리한다.
     *
     * @param category 현재 조회 중인 카테고리
     */
    public void show(Category category) {
        catalogView.printProductMenu(category);

        int chooseProduct = inputConsole.readInt();

        //메인 메뉴로 복귀
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
    private void addCart(Product product) {
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
