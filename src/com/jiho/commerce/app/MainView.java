package com.jiho.commerce.app;

import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.catalog.Category;

import java.util.List;

public class MainView {

    //메인 메뉴
    public void printMenu(List<Category> categories, Cart cart) {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 프로그램 종료");

        if (!cart.isEmpty()) {
            System.out.println("\n[ 주문 관리 ]\n" +
                    "4. 장바구니 확인      | 장바구니를 확인 후 주문합니다.\n" +
                    "5. 주문 취소       | 진행중인 주문을 취소합니다.");
        }
    }

    //종료
    public void printExitMessage() {
        System.out.println("커머스 플랫폼을 종료합니다.");
    }

    //유효x
    public void printInvalidCategoryMessage() {
        System.out.println("유효하지 않은 카테고리 번호입니다.");
    }

}
