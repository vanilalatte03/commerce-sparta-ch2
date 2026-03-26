package com.jiho.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product product1 = new Product("Galaxy S26", 1200000, "최신 안드로이드 스마트폰", 10);
        Product product2 = new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰", 8);
        Product product3 = new Product("MacBook Pro", 2400000, "M5 칩셋이 탑재된 노트북", 5);
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 3);


        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        while (true){
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (int i = 0; i < products.size(); i++) {
                Product currentProduct = products.get(i);
                System.out.printf("%d. %-15s | %,10d원 | %s\n", i+1,
                        currentProduct.getProductName(),
                        currentProduct.getPrice(),
                        currentProduct.getDescription());
            }
            System.out.println("0. 종료            | 프로그램 종료");

            int choose = sc.nextInt();
            if (choose == 0){
                System.out.println("\n커머스 플랫폼을 종료합니다.");
                return;
            }
            System.out.println(products.get(choose-1).getProductName() + "을 구매하셨군요!");
        }


    }
}