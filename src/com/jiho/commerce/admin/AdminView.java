package com.jiho.commerce.admin;

import com.jiho.commerce.product.Category;
import com.jiho.commerce.product.Product;

import java.util.List;

public class AdminView {

    void printPasswordCheck(){
        System.out.println("관리자 비밀번호를 입력해주세요: ");
    }

    public void printPasswordMismatchMessage(int count) {
        System.out.println("비밀번호가 일치하지 않습니다. 남은 횟수: " + count);
    }

    public void printPasswordFailMessage() {
        System.out.println("비밀번호 입력 3회 실패로 메인 메뉴로 돌아갑니다.");
    }

    public void printAdminMenu() {
        System.out.println("\n[ 관리자 모드 ]");
        System.out.println("1. 상품 추가");
        System.out.println("2. 상품 수정");
        System.out.println("3. 상품 삭제");
        System.out.println("0. 메인으로 돌아가기");
    }

    public void printInvalidMenuMessage() {
        System.out.println("유효하지 않은 메뉴 번호입니다.");
    }

    public void printCategoryMenu(List<Category> categories) {
        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
    }

    public void printAddProductHeader(String categoryName) {
        System.out.println("\n[ " + categoryName + " 카테고리에 상품 추가 ]");
    }

    public void printInvalidCategoryMessage() {
        System.out.println("유효하지 않은 카테고리 번호입니다.");
    }

    public void printProductNamePrompt() {
        System.out.print("상품명을 입력해주세요: ");
    }

    public void printBlankMessage() {
        System.out.println("비워둘 수 없습니다.");
    }

    public void printPricePrompt() {
        System.out.print("가격을 입력해주세요: ");
    }

    public void printInvalidNumberMessage() {
        System.out.println("0보다 큰 숫자를 입력해주세요.");
    }

    public void printDescriptionPrompt() {
        System.out.print("상품 설명을 입력해주세요: ");
    }

    public void printStockPrompt() {
        System.out.print("재고수량을 입력해주세요: ");
    }

    public void printProductPreview(String productName, int price, String description, int stock) {
        System.out.printf("\n%s | %,d원 | %s | 재고: %d개\n", productName, price, description, stock);
    }

    public void printConfirmAddMenu() {
        System.out.println("위 정보로 상품을 추가하시겠습니까?\n" +
                "1. 확인    2. 취소");
    }

    public void printAddCancelMessage() {
        System.out.println("상품 추가가 취소되었습니다.");
    }

    public void printDuplicationProductMessage() {
        System.out.println("같은 카테고리에 동일한 상품명이 이미 존재합니다.");
    }

    public void printAddSuccessMessage() {
        System.out.println("상품이 성공적으로 추가되었습니다!");
    }

    public void printUpdateProductNamePrompt() {
        System.out.print("수정할 상품명을 입력해주세요: ");
    }

    public void printProductNotFoundMessage() {
        System.out.println("해당 상품을 찾을 수 없습니다.");
    }

    public void printCurrentProductInfo(Product product) {
        System.out.printf("현재 상품 정보: %s | %,d원 | %s | 재고: %d개%n",
                product.getProductName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock());
    }

    public void printUpdateMenu() {
        System.out.println("\n수정할 항목을 선택해주세요:");
        System.out.println("1. 가격");
        System.out.println("2. 설명");
        System.out.println("3. 재고수량");
    }

    public void printCurrentPrice(int oldPrice) {
        System.out.printf("현재 가격: %,d원%n", oldPrice);
    }

    public void printNewPricePrompt() {
        System.out.print("새로운 가격을 입력해주세요: ");
    }

    public void printPriceUpdatedMessage(String productName, int oldPrice, int newPrice) {
        System.out.printf("%s의 가격이 %,d원 → %,d원으로 수정되었습니다.%n",
                productName, oldPrice, newPrice);
    }

    public void printCurrentDescription(String oldDescription) {
        System.out.println("현재 설명: " + oldDescription);
    }

    public void printNewDescriptionPrompt() {
        System.out.print("새로운 설명을 입력해주세요: ");
    }

    public void printDescriptionUpdatedMessage(String productName, String oldDescription, String newDescription) {
        System.out.printf("%s의 설명이 \"%s\" → \"%s\"로 수정되었습니다.%n",
                productName, oldDescription, newDescription);
    }

    public void printCurrentStock(int oldStock) {
        System.out.println("현재 재고수량: " + oldStock + "개");
    }

    public void printNewStockPrompt() {
        System.out.print("새로운 재고수량을 입력해주세요: ");
    }

    public void printStockUpdatedMessage(String productName, int oldStock, int newStock) {
        System.out.printf("%s의 재고수량이 %d개 → %d개로 수정되었습니다.%n",
                productName, oldStock, newStock);
    }

    public void printDeleteProductNamePrompt() {
        System.out.print("삭제할 상품명을 입력해주세요: ");
    }

    public void printConfirmDeleteMenu() {
        System.out.println("위 상품을 삭제하시겠습니까?");
        System.out.println("1. 확인    2. 취소");
    }

    public void printDeleteCancelMessage() {
        System.out.println("상품 삭제가 취소되었습니다.");
    }

    public void printDeleteSuccessMessage() {
        System.out.println("상품이 성공적으로 삭제되었습니다.");
    }
}
