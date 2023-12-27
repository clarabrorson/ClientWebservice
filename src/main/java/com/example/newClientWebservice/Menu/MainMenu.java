package com.example.newClientWebservice.Menu;

import com.example.newClientWebservice.Service.UtilService;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class MainMenu {
   private static boolean isRunning = true;
    public static void run() throws IOException, ParseException {
        while (isRunning) {
            printMainMenu();
            int choice = UtilService.getIntInput("Enter your choice: ");
            userChoice(choice);

        }
    }

    private static void printMainMenu() {
        String [] menuItems = {"1. Login", "2. Register","3. View articles", "4. Exit"};
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }

    public static void userChoice(int choice) throws IOException, ParseException {
        switch (choice) {
            case 1:
                //login();
                Login.loginMenu();
                break;
            case 2:
                //register();
                Register.register();
                break;
            case 3:
                //viewArticles();
                ArticlesMenu.printArticlesMenu();
                break;
            case 4:
                System.out.println("Exiting...");
                isRunning = false;
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                break;
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        run();
    }
}
