package com.jiho.commerce.product;


import java.util.List;

/**
 * 관리자 메뉴에서 사용하는 상품 관리 유스케이스를 담당한다.
 */
public class ProductAdminService {

    /**
     * 카테고리에 새 상품을 추가한다.
     * 같은 카테고리 안에 동일한 이름의 상품이 있으면 추가하지 않는다.
     *
     * @param category 상품을 추가할 카테고리
     * @param productName 추가할 상품명
     * @param price 추가할 상품 가격
     * @param description 추가할 상품 설명
     * @param stock 추가할 초기 재고 수량
     * @return 추가에 성공하면 true, 중복 상품명이 있으면 false
     */
    public boolean addProduct(Category category, String productName, int price, String description, int stock) {
        if (category.hasProductName(productName)) {
            return false;
        }

        Product product = new Product(productName, price, description, stock);
        category.addProduct(product);
        return true;
    }

    /**
     * 전체 카테고리를 순회해 이름이 일치하는 첫 번째 상품을 찾는다.
     *
     * @param categories 검색 대상 카테고리 목록
     * @param productName 찾을 상품명
     * @return 찾은 상품, 없으면 null
     */
    public Product findProductByName(List<Category> categories, String productName) {
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.getProductName().equals(productName.trim())) {
                    return product;
                }
            }
        }
        return null;
    }

    /**
     * 상품 가격을 수정한다.
     *
     * @param product 수정할 상품
     * @param newPrice 새 가격
     * @return 가격이 0보다 크면 true, 아니면 false
     */
    public boolean updatePrice(Product product, int newPrice) {
        if (newPrice <= 0) {
            return false;
        }

        product.updatePrice(newPrice);
        return true;
    }

    /**
     * 상품 설명을 수정한다.
     *
     * @param product 수정할 상품
     * @param newDescription 새 설명
     * @return 설명이 비어 있지 않으면 true, 아니면 false
     */
    public boolean updateDescription(Product product, String newDescription) {
        if (newDescription == null || newDescription.isBlank()) {
            return false;
        }

        product.updateDescription(newDescription);
        return true;
    }

    /**
     * 상품 재고를 수정한다.
     *
     * @param product 수정할 상품
     * @param newStock 새 재고 수량
     * @return 재고가 0 이상이면 true, 아니면 false
     */
    public boolean updateStock(Product product, int newStock) {
        if (newStock < 0) {
            return false;
        }

        product.updateStock(newStock);
        return true;
    }

    /**
     * 상품이 속한 카테고리를 찾아 제거한다.
     *
     * @param categories 검색 대상 카테고리 목록
     * @param targetProduct 삭제할 상품
     * @return 삭제에 성공하면 true, 아니면 false
     */
    public boolean deleteProduct(List<Category> categories, Product targetProduct) {
        for (Category category : categories) {
            if (category.removeProduct(targetProduct)) {
                return true;
            }
        }
        return false;
    }

}
