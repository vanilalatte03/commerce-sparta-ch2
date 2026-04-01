package com.jiho.commerce;

import java.util.Scanner;

public class InputConsole {
    private final Scanner sc;

    public InputConsole(Scanner sc) {
        this.sc = sc;
    }

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
