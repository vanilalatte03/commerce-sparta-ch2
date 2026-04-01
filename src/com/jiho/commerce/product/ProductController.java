package com.jiho.commerce.product;

import com.jiho.commerce.InputConsole;
import com.jiho.commerce.cart.Cart;

public class ProductController {
    private final InputConsole inputConsole;
    private final ProductView productView;
    private final Cart cart;

    public ProductController(InputConsole inputConsole, ProductView productView, Cart cart) {
        this.inputConsole = inputConsole;
        this.productView = productView;
        this.cart = cart;
    }

    /**
     * 카테고리의 상품 목록을 보여주고, 상품 선택 또는 이전 메뉴 복귀를 처리한다.
     *
     * @param category 현재 조회 중인 카테고리
     */
    public void show(Category category) {
        productView.printProductMenu(category);

        int selectedProduct = inputConsole.readInt();

        //메인 메뉴로 복귀
        if (selectedProduct == 0) {
            productView.printBlankLine();
            return;
        }

        if (selectedProduct < 1 || selectedProduct > category.getProducts().size()) {
            productView.printInvalidProductMessage();
            return;
        }

        Product product = category.getProducts().get(selectedProduct - 1);
        productView.printSelectProduct(product);
        confirmAddToCart(product);
    }

    //선택한 상품의 장바구니 추가 여부를 확인하고 결과를 처리
    private void confirmAddToCart(Product product) {
        productView.printAddCartMenu();
        int selectedAddToCart = inputConsole.readInt();

        if (selectedAddToCart == 1) {
            if (cart.addProduct(product)) {
                productView.printAddCartSuccess(product);
            } else {
                productView.printSoldOutStockMessage();
            }
        }
    }
}
