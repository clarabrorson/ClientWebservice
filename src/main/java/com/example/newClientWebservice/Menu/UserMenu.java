package com.example.newClientWebservice.Menu;

import com.example.newClientWebservice.Models.Cart;
import com.example.newClientWebservice.Service.CartService;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

import static com.example.newClientWebservice.Menu.Login.getUserChoice;
import static com.example.newClientWebservice.Service.ArticleService.getAllArticles;
import static com.example.newClientWebservice.Service.CartService.*;
import static com.example.newClientWebservice.Service.HistoryService.getCurrentUserHistory;

public class UserMenu {

    private static void userMenu() throws IOException, ParseException {

    public static void userMenu() {

        while (true) {
            System.out.println("Welcome to Fruit Haven!");
            System.out.println("1. View all fruits");
            System.out.println("2. Add a fruit to the basket"); // Ska användaren kunna skapa en ny frukt eller välja från en lista?
            System.out.println("3. View basket");
            System.out.println("4. Remove a fruit from the basket");
            System.out.println("5. Want more fruits? Update the quantity of a fruit in the basket");
            System.out.println("6. History of purchases");
            System.out.println("6. Ready to checkout? Proceed to checkout");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    getAllArticles(); // ID behöver skrivas ut
                    break;
                case 2:

                    addArticleToCart();
                    //addFruitToBasket();

                    //addArticleToCart();

                    break;
                case 3:
                    //getOneCartById();
                    break;
                case 4:
                    //deleteArticleFromCart();
                    break;
                case 5:
                   // updateArticleCount();
                    break;
                case 6:
                   // getCurrentUserHistory();
                    break;
                case 7:
                   // purchaseArticles();
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    userMenu();
                    break;
            }
        }
    }

    /*private static void addFruitToBasket() throws IOException, ParseException {
        System.out.println("Enter the ID of the fruit you want to add to the basket:");
        int articleId = getUserChoice();
        System.out.println("Enter the quantity:");
        int quantity = getUserChoice();
        System.out.println("Enter the ID of the basket you want to add the fruit to:");
        int cartId = getUserChoice();

        CartService.addArticleToCart(cartId, articleId, String.valueOf(quantity));
    }*/

}