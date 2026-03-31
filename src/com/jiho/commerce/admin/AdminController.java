package com.jiho.commerce.admin;

import com.jiho.commerce.InputConsole;

public class AdminController {
    private final AdminView adminView;
    private final InputConsole inputConsole;

    public AdminController(InputConsole inputConsole, AdminView adminView) {
        this.inputConsole = inputConsole;
        this.adminView = adminView;
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
                case 2:
                case 3:
                case 4:
                case 0:
                default:
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


}
