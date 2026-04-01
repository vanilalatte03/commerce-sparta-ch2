package com.jiho.commerce.admin;

import com.jiho.commerce.io.InputConsole;
import com.jiho.commerce.cart.Cart;
import com.jiho.commerce.product.Category;
import com.jiho.commerce.product.Product;
import com.jiho.commerce.product.ProductAdminService;

import java.util.List;

/**
 * 관리자 인증이 성공하면 관리자 메뉴를 반복 실행한다.
 */
public class AdminController {
    private final AdminView adminView;
    private final InputConsole inputConsole;
    private final List<Category> categories;
    private final AdminAuthService adminAuthService;
    private final ProductAdminService productAdminService;
    private final Cart cart;

    public AdminController(InputConsole inputConsole, AdminView adminView, List<Category> categories, AdminAuthService adminAuthService, ProductAdminService productAdminService, Cart cart) {
        this.inputConsole = inputConsole;
        this.adminView = adminView;
        this.categories = categories;
        this.adminAuthService = adminAuthService;
        this.productAdminService = productAdminService;
        this.cart = cart;
    }

    public void showAdminMenu() {
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
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 0:
                    return;
                default:
                    adminView.printInvalidMenuMessage();
            }
        }

    }

    /**
     * 비밀번호를 최대 3번까지 입력받아 인증 성공 여부를 반환한다.
     */
    private boolean checkPassword() {
        for (int i = 0; i < 3; i++) {
            adminView.printPasswordCheck();
            String password = inputConsole.readLine();

            if (adminAuthService.matches(password)) {
                return true;
            }

            adminView.printPasswordMismatchMessage(2 - i);
        }

        adminView.printPasswordFailMessage();
        return false;
    }

    //상품 추가
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

        boolean added = productAdminService.addProduct(category, productName, price, description, stock);

        if (!added) {
            adminView.printDuplicationProductMessage();
            return;
        }

        adminView.printAddSuccessMessage();

    }

    //상품 수정
    private void updateProduct() {
        adminView.printUpdateProductNamePrompt();
        String productName = inputConsole.readLine();

        if (productName.isBlank()) {
            adminView.printBlankMessage();
            return;
        }

        Product product = productAdminService.findProductByName(categories, productName);

        if (product == null) {
            adminView.printProductNotFoundMessage();
            return;
        }

        adminView.printCurrentProductInfo(product);
        adminView.printUpdateMenu();

        int menu = inputConsole.readInt();

        switch (menu) {
            case 1:
                updatePrice(product);
                break;
            case 2:
                updateDescription(product);
                break;
            case 3:
                updateStock(product);
                break;
            default:
                adminView.printInvalidMenuMessage();
        }
    }

    private void updatePrice(Product product) {
        int oldPrice = product.getPrice();

        adminView.printCurrentPrice(oldPrice);
        adminView.printNewPricePrompt();
        int newPrice = inputConsole.readInt();

        boolean updated = productAdminService.updatePrice(product, newPrice);
        if (!updated) {
            adminView.printInvalidNumberMessage();
            return;
        }

        adminView.printPriceUpdatedMessage(product.getProductName(), oldPrice, newPrice);
    }

    private void updateDescription(Product product) {
        String oldDescription = product.getDescription();

        adminView.printCurrentDescription(oldDescription);
        adminView.printNewDescriptionPrompt();
        String newDescription = inputConsole.readLine();

        boolean updated = productAdminService.updateDescription(product, newDescription);
        if (!updated) {
            adminView.printBlankMessage();
            return;
        }

        adminView.printDescriptionUpdatedMessage(product.getProductName(), oldDescription, newDescription);

    }

    private void updateStock(Product product) {
        int oldStock = product.getStock();

        adminView.printCurrentStock(oldStock);
        adminView.printNewStockPrompt();
        int newStock = inputConsole.readInt();

        boolean updated = productAdminService.updateStock(product, newStock);
        if (!updated) {
            adminView.printInvalidNumberMessage();
            return;
        }

        adminView.printStockUpdatedMessage(product.getProductName(), oldStock, newStock);
    }

    //상품 삭제
    private void deleteProduct() {
        adminView.printDeleteProductNamePrompt();
        String productName = inputConsole.readLine();

        if (productName.isBlank()) {
            adminView.printBlankMessage();
            return;
        }

        Product product = productAdminService.findProductByName(categories, productName);

        if (product == null) {
            adminView.printProductNotFoundMessage();
            return;
        }

        adminView.printCurrentProductInfo(product);
        adminView.printConfirmDeleteMenu();

        int confirm = inputConsole.readInt();

        if (confirm != 1) {
            adminView.printDeleteCancelMessage();
            return;
        }

        boolean deleted = productAdminService.deleteProduct(categories, product);

        if (!deleted) {
            adminView.printProductNotFoundMessage();
            return;
        }

        // 삭제된 상품이 장바구니에 남아 주문되지 않도록 관련 항목도 함께 제거
        cart.removeProduct(product);
        adminView.printDeleteSuccessMessage();
    }

    /**
     * 카테고리 번호를 입력받아 선택된 카테고리를 반환한다.
     * 유효하지 않은 번호면 null을 반환해 현재 작업을 중단한다.
     */
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





