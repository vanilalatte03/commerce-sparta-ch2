package com.jiho.commerce;

import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartItem;
import com.jiho.commerce.catalog.Category;
import com.jiho.commerce.catalog.Product;

import java.util.List;

public class OutputConsole {

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

    //상품 메뉴
    public void printProductMenu(Category category) {
        System.out.println("\n[ " + category.getCategoryName() + " 카테고리 ]");

        for (int i = 0; i < category.getProducts().size(); i++) {
            Product product = category.getProducts().get(i);
            System.out.printf("%d. %-11s | %,10d원 | %s\n",
                    i + 1,
                    product.getProductName(),
                    product.getPrice(),
                    product.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }

    //선택한 상품 정보
    public void printChooseProduct(Product product) {
        System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개\n\n",
                product.getProductName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock());
    }

    //장바구니 추가 메뉴
    public void printAddCartMenu() {
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

    //장바구니 추가 성공
    public void printAddCartSuccess(Product product) {
        System.out.println(product.getProductName() + "가 장바구니에 추가되었습니다.");
    }

    //재고 부족
    public void printSoldOutStockMessage() {
        System.out.println("재고가 부족합니다.");
    }

    //주문 취소
    public void printCancelOrderMessage() {
        System.out.println("주문 취소");
    }

    //종료
    public void printExitMessage() {
        System.out.println("커머스 플랫폼을 종료합니다.");
    }

    //유효x
    public void printInvalidCategoryMessage() {
        System.out.println("유효하지 않은 카테고리 번호입니다.");
    }

    //유효x
    public void printInvalidProductMessage() {
        System.out.println("유효하지 않은 상품 번호입니다.");
    }

    //빈 줄
    public void printBlankLine() {
        System.out.println();
    }

}
