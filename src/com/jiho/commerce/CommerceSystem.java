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
            int chooseCategory= sc.nextInt();

            if (chooseCategory == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                return;
            } else if (chooseCategory < 0 || chooseCategory > categories.size()){
                System.out.println("유효하지 않은 카테고리 번호입니다.");
                continue;
            }



            Category category = categories.get(chooseCategory - 1);

            System.out.println();
            try {
                System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

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
            } else if (chooseProduct < 0|| chooseProduct > category.getProducts().size()) {
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
                ShoppingBasket shoppingBasket = new ShoppingBasket(product.getProductName(), 1, product.getPrice());
                shoppingBaskets.add(shoppingBasket);
            }

            System.out.println(product.getProductName() + "가 장바구니에 추가되었습니다.");




            /*System.out.println("현재 장바구니에 담긴 상품 목록");
            ShoppingBasket shoppingBasket = shoppingBaskets.get(0);
            System.out.printf(shoppingBasket.getProductName(),
                    shoppingBasket.getQuantity(),
                    shoppingBasket.getPriceInformation());*/
        }
    }
}

