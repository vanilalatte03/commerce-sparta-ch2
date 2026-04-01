package com.jiho.commerce.product;

public class ProductView {

    //상품 메뉴
    void printProductMenu(Category category) {
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
    void printSelectProduct(Product product) {
        System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개\n\n",
                product.getProductName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock());
    }

    //장바구니 추가 메뉴
    void printAddCartMenu() {
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }

    //장바구니 추가 성공
    void printAddCartSuccess(Product product) {
        System.out.println(product.getProductName() + "가 장바구니에 추가되었습니다.\n");
    }

    //재고 부족
    void printSoldOutStockMessage() {
        System.out.println("재고가 부족합니다.\n");
    }

    //유효x
    void printInvalidProductMessage() {
        System.out.println("유효하지 않은 상품 번호입니다.");
    }

    //빈 줄
    void printBlankLine() {
        System.out.println();
    }



}
