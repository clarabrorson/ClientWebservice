package com.example.newClientWebservice.Menu;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

import static com.example.newClientWebservice.Service.UserService.login;

public class Login {

    public static int getUserChoice() {
        System.out.println("Enter your choice: ");
        try {
            return Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getUserChoice();
        }
    }

//    private static void loginMenu() throws IOException, ParseException {
//        while (true) {
//            System.out.println("Login Menu");
//            System.out.println("1. Login");
//            System.out.println("2. Back to Main Menu");
//        }
//
//        int choice = getUserChoice();
//
//        switch (choice) {
//            case 1:
//                login();
//                break;
//            case 2:
//                mainMenu();
//                break;
//            default:
//                System.out.println("Invalid input. Please enter a number between 1 and 3.");
//                loginMenu();
//                break;
//        }
//    }
}
