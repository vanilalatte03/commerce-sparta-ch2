package com.jiho.commerce.app;

import com.jiho.commerce.*;
import com.jiho.commerce.admin.AdminController;
import com.jiho.commerce.admin.AdminView;
import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.cart.CartItem;
import com.jiho.commerce.order.OrderController;
import com.jiho.commerce.order.OrderView;
import com.jiho.commerce.product.Category;
import com.jiho.commerce.product.ProductController;
import com.jiho.commerce.product.ProductView;
import com.jiho.commerce.product.Product;
import com.jiho.commerce.order.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(new Product("Galaxy S26", 1200000, "최신 안드로이드 스마트폰", 10));
        electronicsProducts.add(new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰", 8));
        electronicsProducts.add(new Product("MacBook Pro", 2400000, "M5 칩셋이 탑재된 노트북", 2));
        electronicsProducts.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 0));

        List<Product> clothesProducts = new ArrayList<>();
        clothesProducts.add(new Product("후드집업", 40000, "검은색 후드집업", 60));
        clothesProducts.add(new Product("티셔츠", 10000, "흰색 티셔츠", 80));

        List<Product> foodProducts = new ArrayList<>();
        foodProducts.add(new Product("페퍼로니 피자", 30000, "치즈 듬뿍 피자", 30));
        foodProducts.add(new Product("후라이드 치킨", 24000, "순살 치킨", 50));

        Category electronics = new Category("전자제품", electronicsProducts);
        Category clothes = new Category("의류", clothesProducts);
        Category foods = new Category("음식", foodProducts);

        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(clothes);
        categories.add(foods);

        List<CartItem> cartItems = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        InputConsole inputConsole = new InputConsole(scanner);
        MainView mainView = new MainView();

        OrderService orderService = new OrderService();

        Cart carts = new Cart(cartItems);
        OrderView orderView = new OrderView();
        OrderController cartScreen = new OrderController(inputConsole, orderView, carts, orderService);

        ProductView productView = new ProductView();
        ProductController productScreen = new ProductController(inputConsole, productView, carts);

        AdminView adminView = new AdminView();
        AdminController adminController = new AdminController(inputConsole, adminView);

        MainController commerceSystem = new MainController(categories, carts, cartScreen, productScreen, adminController, inputConsole, mainView);
        commerceSystem.start();
    }
}
