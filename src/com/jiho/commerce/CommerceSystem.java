package com.jiho.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private final List<Product> products;

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    void start() {
        Scanner sc = new Scanner(System.in);
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
