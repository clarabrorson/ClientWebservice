package com.example.newClientWebservice.Menu;

import com.example.newClientWebservice.Service.UtilService;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

import static com.example.newClientWebservice.Service.UserService.login;
import static com.example.newClientWebservice.Service.UtilService.getIntInput;

public class Login {


    public static void loginMenu() throws IOException, ParseException {
        while (true) {
            System.out.println("Login Menu");
            System.out.println("1. Login");
            System.out.println("2. Back to Main Menu");


            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    MainMenu.run();
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    loginMenu();
                    break;
            }
        }
    }

    private static void login() throws IOException, ParseException {
        String username = UtilService.getStringInput("Enter username: ");
        String password = UtilService.getStringInput("Enter password: ");
        String jwt = com.example.newClientWebservice.Service.UserService.login(username, password);
        if (jwt != null) {
            System.out.println("Login successful!");
            UserMenu.userMenu(jwt);
        } else {
            System.out.println("Login failed. Please try again.");
            login();
        }
    }
}
