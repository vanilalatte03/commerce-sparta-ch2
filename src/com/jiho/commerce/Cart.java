package com.jiho.commerce;

import java.util.List;

//장바구니로 하는 일들
public class Cart {
    private final List<ShoppingBasket> items;

    public Cart(List<ShoppingBasket> items) {
        this.items = items;
    }

    //장바구니가 비었는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<ShoppingBasket> getItems() {
        return items;
    }

    //재고 확인 후 장바구니 추가
    public boolean addProduct(Product product) {
        if (product.getStock() < 1) {
            return false;
        }
        items.add(new ShoppingBasket(product, 1));
        return true;
    }

    //최종 가격
    public int getTotalPrice() {
        int sumPrice = 0;
        for (ShoppingBasket basket : items) {
            sumPrice += basket.getProduct().getPrice() * basket.getQuantity();
        }
        return sumPrice;
    }

    //재고 차감
    public void checkout() {
        for (ShoppingBasket basket : items) {
            Product product = basket.getProduct();

            System.out.printf("%s 재고가 %d개 → ",
                    product.getProductName(),
                    product.getStock());
            product.decreaseStock( basket.getQuantity());
            System.out.printf("%d개로 업데이트되었습니다.\n", product.getStock());
        }
        clear();
    }

    //장바구니 비우기
    public void clear() {
        items.clear();
    }
}
