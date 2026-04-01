package com.jiho.commerce.admin;

import com.jiho.commerce.InputConsole;
import com.jiho.commerce.product.Category;
import com.jiho.commerce.product.ProductService;

import java.util.List;

public class AdminController {
    private final AdminView adminView;
    private final InputConsole inputConsole;
    private final List<Category> categories;
    private final ProductService productService;

    public AdminController(InputConsole inputConsole, AdminView adminView, List<Category> categories, ProductService productService) {
        this.inputConsole = inputConsole;
        this.adminView = adminView;
        this.categories = categories;
        this.productService = productService;
    }

    public void show() {
        if (!checkPassword()) {
            return;
        }

        while (true) {
            adminView.printAdminMenu();
            int menu = inputConsole.readInt();

            switch (menu){
                case 1:
                    addProduct();
                    break;
                case 2:
                case 3:
                case 4:
                case 0:
                    return;
                default:
                    adminView.printInvalidMenuMessage();
            }
        }

    }

    private Boolean checkPassword(){
        String adminPassword = "admin123";

        for (int i = 0; i < 3; i++) {
            adminView.printPasswordCheck();
            String password = inputConsole.readLine();

            if (adminPassword.equals(password)) {
                return true;
            }

            adminView.printPasswordMismatchMessage(2 - i);
        }

        adminView.printPasswordFailMessage();
        return false;
    }

    private void addProduct() {
        Category category = selectCategory();
        if (category == null) {
            return;
        }

        adminView.printAddProductHeader(category.getCategoryName());

        String productName = readProductName();
        int price = readPrice();
        String description = readDescription();
        int stock = readStock();

        adminView.printProductPreview(productName, price, description, stock);
        adminView.printConfirmAddMenu();

        int confirm = inputConsole.readInt();
        if (confirm != 1) {
            adminView.printAddCancelMessage();
            return;
        }

        boolean added = productService.addProduct(category, productName, price, description, stock);

        if (!added) {
            adminView.printDuplicationProductMessage();
            return;
        }

        adminView.printAddSuccessMessage();

    }

    private Category selectCategory() {
        adminView.printCategoryMenu(categories);

        int categoryNumber = inputConsole.readInt();

        if (categoryNumber < 1 || categoryNumber > categories.size()) {
            adminView.printInvalidCategoryMessage();
            return null;
        }

        return categories.get(categoryNumber - 1);
    }

    private String readProductName() {
        while (true) {
            adminView.printProductNamePrompt();
            String productName = inputConsole.readLine();

            if (productName.isBlank()) {
                adminView.printBlankMessage();
                continue;
            }

            return productName;
        }
    }

    private int readPrice() {
        while (true) {
            adminView.printPricePrompt();
            int price = inputConsole.readInt();

            if (price <= 0) {
                adminView.printInvalidNumberMessage();
                continue;
            }

            return price;
        }
    }

    private String readDescription() {
        while (true) {
            adminView.printDescriptionPrompt();
            String description = inputConsole.readLine();

            if (description.isBlank()) {
                adminView.printBlankMessage();
                continue;
            }

            return description;
        }
    }

    private int readStock() {
        while (true) {
            adminView.printStockPrompt();
            int stock = inputConsole.readInt();

            if (stock <= 0) {
                adminView.printInvalidNumberMessage();
                continue;
            }

            return stock;
        }
    }

}





