package com.jiho.commerce.app;

import com.jiho.commerce.product.Category;

import java.util.List;

public class MainView {

    //메인 메뉴
    void printMenu(List<Category> categories, boolean hasCartItems,
                   int cartMenuNumber, int cancelMenuNumber, int adminMenuNumber) {
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 프로그램 종료");
        System.out.printf("%d. 관리자 모드\n", adminMenuNumber);

        if (hasCartItems) {
            System.out.printf("\n[ 주문 관리 ]\n" +
                    "%d. 장바구니 확인      | 장바구니를 확인 후 주문합니다.\n" +
                    "%d. 주문 취소       | 진행중인 주문을 취소합니다.\n", cartMenuNumber, cancelMenuNumber);
        }
    }

    //종료
    void printExitMessage() {
        System.out.println("커머스 플랫폼을 종료합니다.");
    }

    //유효x
    void printInvalidCategoryMessage() {
        System.out.println("유효하지 않은 카테고리 번호입니다.");
    }

}
