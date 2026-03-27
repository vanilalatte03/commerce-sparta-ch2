package com.jiho.commerce;

import java.util.*;

public class CommerceSystem {
    private final List<Category> categories;
    private final List<ShoppingBasket> shoppingBaskets;
    private final Scanner sc;

    public CommerceSystem(List<Category> categories, List<ShoppingBasket> shoppingBaskets, Scanner sc) {
        this.categories = categories;
        this.shoppingBaskets = shoppingBaskets;
        this.sc = sc;
    }

    void start() {
        while (true){
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i <  categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
            }
            System.out.println("0. 종료      | 프로그램 종료");

            if(!shoppingBaskets.isEmpty()){
                System.out.println("\n[ 주문 관리 ]\n" +
                        "4. 장바구니 확인      | 장바구니를 확인 후 주문합니다.\n" +
                        "5. 주문 취소       | 진행중인 주문을 취소합니다.");
            }

            int chooseCategory= sc.nextInt();

            //장바구니 확인
            if (!shoppingBaskets.isEmpty() && chooseCategory == 4) {
                System.out.println("아래와 같이 주문 하시겠습니까?\n");
                System.out.println("[ 장바구니 내역 ]");
                int sumPrice = 0;
                for (int i = 0; i < shoppingBaskets.size(); i++) {
                    System.out.printf("%d. %-11s | %,10d원 | 수량: %s개\n",
                            i + 1,
                            shoppingBaskets.get(i).getProductName(),
                            shoppingBaskets.get(i).getPriceInformation(),
                            shoppingBaskets.get(i).getQuantity());
                    sumPrice += shoppingBaskets.get(i).getPriceInformation();
                }
                System.out.println("[ 총 주문 금액 ]");
                System.out.printf("%,10d원\n\n", sumPrice);

                continue;
            }

            //주문 취소
            if (!shoppingBaskets.isEmpty() && chooseCategory == 5) {
                System.out.println("주문 취소");
                shoppingBaskets.clear();
                continue;
            }

            if (chooseCategory == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                return;
            } else if (chooseCategory < 0 || chooseCategory > categories.size()){ //예외
                System.out.println("유효하지 않은 카테고리 번호입니다.");
                continue;
            }

            Category category = categories.get(chooseCategory - 1);

            System.out.println();
            System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");

            for (int i = 0; i < category.getProducts().size(); i++) {
                Product product = category.getProducts().get(i);
                System.out.printf("%d. %-11s | %,10d원 | %s\n",
                        i + 1,
                        product.getProductName(),
                        product.getPrice(),
                        product.getDescription());
            }
            System.out.println("0. 뒤로가기");

            int chooseProduct = sc.nextInt();

            if (chooseProduct == 0) {
                System.out.println();
                continue;
            } else if (chooseProduct < 0|| chooseProduct > category.getProducts().size()) {//예외
                System.out.println("유효하지 않은 상품 번호입니다.");
                continue;
            }

            Product product = category.getProducts().get(chooseProduct - 1);
            System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개\n\n",
                    product.getProductName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getStock());

            System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인       2. 취소");
            int chooseShoppingBaskets = sc.nextInt();
            if (chooseShoppingBaskets == 1){
                if (product.getStock() == 0){
                    System.out.println("재고가 부족합니다.");
                } else {
                    ShoppingBasket shoppingBasket = new ShoppingBasket(product.getProductName(), 1, product.getPrice());
                    shoppingBaskets.add(shoppingBasket);
                    System.out.println(product.getProductName() + "가 장바구니에 추가되었습니다.");
                }
            }




            /*System.out.println("현재 장바구니에 담긴 상품 목록");
            ShoppingBasket shoppingBasket = shoppingBaskets.get(0);
            System.out.printf(shoppingBasket.getProductName(),
                    shoppingBasket.getQuantity(),
                    shoppingBasket.getPriceInformation());*/
        }
    }
}

