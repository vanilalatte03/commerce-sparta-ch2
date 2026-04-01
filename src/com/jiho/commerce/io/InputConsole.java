package com.jiho.commerce.io;

import java.util.Scanner;

public class InputConsole {
    private final Scanner sc;

    public InputConsole(Scanner sc) {
        this.sc = sc;
    }

    /**
     * 한 줄 전체를 읽어 정수로 변환한다.
     * nextInt() 대신 nextLine()을 사용해 개행이 남는 문제를 피한다.
     */
    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    public String readLine() {
        return sc.nextLine().trim();
    }
}
