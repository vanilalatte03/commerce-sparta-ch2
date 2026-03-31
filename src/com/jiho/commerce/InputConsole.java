package com.jiho.commerce;

import java.util.Scanner;

public class InputConsole {
    private final Scanner sc;

    public InputConsole(Scanner sc) {
        this.sc = sc;
    }

    public int readInt() {
        return sc.nextInt();
    }

    public String readLine() {
        return sc.nextLine().trim();
    }
}
