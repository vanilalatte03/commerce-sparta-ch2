package com.jiho.commerce.admin;

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
        System.out.println("4. 전체 상품 현황");
        System.out.println("0. 메인으로 돌아가기");
    }
}
