package com.jiho.commerce.app;

import com.jiho.commerce.admin.AdminController;
import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.io.InputConsole;
import com.jiho.commerce.order.OrderController;
import com.jiho.commerce.product.Category;
import com.jiho.commerce.product.ProductController;

import java.util.*;

/**
 * 메인 메뉴를 반복 실행하며 카테고리 조회, 장바구니 확인, 주문 취소, 관리자 모드 흐름으로 분기한다.
 */
public class MainController {
    private final List<Category> categories;
    private final Cart cart;
    private final OrderController orderController;
    private final ProductController productController;
    private final AdminController adminController;
    private final InputConsole inputConsole;
    private final MainView mainView;

    public MainController(List<Category> categories, Cart cart,
                          OrderController orderController, ProductController productController, AdminController adminController,
                          InputConsole inputConsole, MainView mainView)
    {
        this.categories = categories;
        this.cart = cart;
        this.orderController = orderController;
        this.productController = productController;
        this.adminController = adminController;
        this.inputConsole = inputConsole;
        this.mainView = mainView;
    }

    public void start() {
        while (true) {
            //카테고리 개수에 따라 동적으로 번호 변경
            int cartMenuNumber = categories.size() + 1;
            int cancelMenuNumber = categories.size() + 2;
            int adminMenuNumber = categories.size() + 3;
            mainView.printMenu(categories, !cart.isEmpty(), cartMenuNumber, cancelMenuNumber, adminMenuNumber);

            int selectedMenuNumber = inputConsole.readInt();

            //장바구니 확인
            if (!cart.isEmpty() && selectedMenuNumber == cartMenuNumber) {
                orderController.showOrderMenu();
                continue;
            }

            //주문 취소
            if (!cart.isEmpty() && selectedMenuNumber == cancelMenuNumber) {
                orderController.cancel();
                continue;
            }

            //관리자 모드
            if (selectedMenuNumber == adminMenuNumber){
                adminController.showAdminMenu();
                continue;
            }

            //프로그램 종료
            if (selectedMenuNumber == 0) {
                mainView.printExitMessage();
                return;
            } else if (selectedMenuNumber < 0 || selectedMenuNumber > categories.size()) {
                //예외 처리
                mainView.printInvalidCategoryMessage();
                continue;
            }

            Category selectedCategory = categories.get(selectedMenuNumber - 1);
            productController.showProductMenu(selectedCategory);

        }
    }
}

