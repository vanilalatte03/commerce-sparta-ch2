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
                    ShoppingBasket basket = shoppingBaskets.get(i);
                    Product product = basket.getProduct();
                    System.out.printf("%d. %-11s | %,10d원 | 수량: %s개\n",
                            i + 1,
                            product.getProductName(),
                            product.getPrice(),
                            basket.getQuantity());
                    sumPrice += product.getPrice() * basket.getQuantity();
                }
                System.out.println("[ 총 주문 금액 ]");
                System.out.printf("%,10d원\n\n", sumPrice);

                System.out.println("1. 주문 확정      2. 메인으로 돌아가기");
                int chooseOrder = sc.nextInt();
                if (chooseOrder == 1){
                    System.out.printf("주문이 완료되었습니다! 총 금액: %,10d원\n", sumPrice);
                    for(int i = 0; i < shoppingBaskets.size(); i++){
                        ShoppingBasket basket = shoppingBaskets.get(i);
                        Product product = basket.getProduct();
                        System.out.printf("%s 재고가 %d개 → ",
                                product.getProductName(),
                                product.getStock()
                                );
                        product.setStock(product.getStock() - basket.getQuantity());
                        System.out.printf("%d개로 업데이트되었습니다.\n",product.getStock());
                    }
                    shoppingBaskets.clear();
                }
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

            int basketQuantity = 0; //장바구니 담긴 같은 상품 수량

            if (chooseShoppingBaskets == 1){
                for (ShoppingBasket basket : shoppingBaskets) {
                    if (basket.getProduct() == product) {
                        basketQuantity += basket.getQuantity();
                    }
                }

                if (basketQuantity >= product.getStock()){
                    System.out.println("재고가 부족합니다.");
                } else {
                    shoppingBaskets.add(new ShoppingBasket(product, 1));
                    System.out.println(product.getProductName() + "가 장바구니에 추가되었습니다.");
                }
            }

        }
    }
}

