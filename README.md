# JAVA 커머스 콘솔 앱

### 프로젝트 소개
간단한 자바 콘솔 기반 커머스 애플리케이션입니다.  

## 진행 목표
- 카테고리와 상품을 콘솔 메뉴로 조회한다.
- 장바구니 담기, 주문, 주문 취소 흐름을 구현한다.
- 관리자 인증 후 상품 추가, 수정, 삭제 기능을 제공한다.
- 도메인, 컨트롤러, 뷰 역할을 분리해 구조를 정리한다.

## 파일 구조

```text
/src/com/jiho/commerce
├── admin
│   ├── AdminAuthService.java
│   ├── AdminController.java
│   └── AdminView.java
├── app
│   ├── Main.java
│   ├── MainController.java
│   └── MainView.java
├── cart
│   ├── Cart.java
│   └── CartItem.java
├── customer
│   └── Customer.java 
├── io
│   └── InputConsole.java
├── order
│   ├── OrderController.java
│   ├── OrderService.java
│   └── OrderView.java
└── product
    ├── Category.java
    ├── Product.java
    ├── ProductAdminService.java
    ├── ProductController.java
    └── ProductView.java
```
- `app` : 프로그램 시작, 메인 메뉴 출력, 전체 흐름 제어
- `product` : 카테고리/상품 조회와 관리자 상품 관리 로직 담당
- `cart` : 장바구니 항목 관리와 총 금액 계산 담당
- `order` : 주문 처리, 재고 차감 담당
- `customer` : 고객 정보 관리
- `admin` : 관리자 인증과 관리자 메뉴 흐름 담당
- `io` : 콘솔 입력 처리 담당

## 구현 내용
- 메인 메뉴에서 카테고리 조회, 장바구니 확인, 주문 취소, 관리자 모드 진입 기능 제공
- 상품 선택 후 장바구니에 담기 기능 제공
- 주문 완료 시 상품 재고 차감 및 장바구니 비우기 처리
- 관리자 비밀번호 인증 후 상품 추가, 가격 수정, 설명 수정, 재고 수정, 삭제 기능 제공
- 삭제된 상품이 장바구니에 남지 않도록 관련 항목 함께 제거

## 실행 방법
1. IDE에서 `src/com/jiho/commerce/app/Main.java`를 실행합니다.
2. 콘솔 메뉴에서 카테고리를 선택해 상품을 탐색합니다.
3. 상품을 장바구니에 담고 주문 메뉴에서 결제를 진행합니다.
4. 관리자 기능이 필요하면 관리자 모드로 진입합니다.

## 실행 환경
- Java 21
- IntelliJ IDEA

## 참고 사항
- 관리자 비밀번호는 현재 코드 기준 `admin123`으로 고정되어 있습니다.
- 초기 데이터는 `Main.java`에서 메모리 기반으로 생성됩니다.

