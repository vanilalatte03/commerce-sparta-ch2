package com.jiho.commerce.admin;

/**
 * 관리자 비밀번호 일치 여부만 판단한다.
 */
public class AdminAuthService {
    private final String adminPassword = "admin123";

    /**
     * 입력한 비밀번호가 관리자 비밀번호와 일치하는지 확인한다.
     *
     * @param password 사용자가 입력한 비밀번호
     * @return 일치하면 true, 아니면 false
     */
    public boolean matches(String password) {
        return adminPassword.equals(password);
    }
}
