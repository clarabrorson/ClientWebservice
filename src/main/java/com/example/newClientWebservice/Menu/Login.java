package com.example.newClientWebservice.Menu;

import com.example.newClientWebservice.Models.LoginResponse;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

import static com.example.newClientWebservice.Models.Cart.getCartIdFromUser;
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
                    // Loggar in och får tillbaka ett LoginResponse-objekt
                    // Skickar in LoginResponse-objektet till getCartIdFromUser-metoden i Cart-klassen
                    // Returnerar CartId som användaren behöver ange för att utföra CRUD-operationer på sin Cart
                    LoginResponse loginResponse = login();
                    Long cartId = getCartIdFromUser(loginResponse);

                    if (cartId != null) {
                        System.out.println("Ready to go shopping? Don't forget your Cart ID: " + cartId);
                        UserMenu.userMenu(loginResponse.getJwt());
                    } else {
                        System.out.println("Something went wrong. Please try again.");
                    }
                    break;
                case 2:
                    MainMenu.runMeny();
                    return;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    loginMenu();
                    break;
            }
        }


    }
//public static void main(String[] args) throws IOException, ParseException {
//        loginMenu();
//    }


}
