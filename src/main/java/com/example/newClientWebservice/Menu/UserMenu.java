package com.example.newClientWebservice.Menu;

import com.example.newClientWebservice.Models.Article;
import com.example.newClientWebservice.Models.Cart;
import com.example.newClientWebservice.Models.LoginResponse;
import com.example.newClientWebservice.Service.ArticleService;
import com.example.newClientWebservice.Service.CartService;
import com.example.newClientWebservice.Service.HistoryService;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.List;

import static com.example.newClientWebservice.Menu.ArticlesMenu.printArticlesMenu;
import static com.example.newClientWebservice.Service.UtilService.getIntInput;

public class UserMenu {

    public static void userMenu(String jwt) throws IOException, ParseException {

            while (true) {
                System.out.println("Welcome to Fruit Haven!");
                System.out.println("1. View all fruits");
                System.out.println("2. Add a fruit to the basket");
                System.out.println("3. View basket");
                System.out.println("4. Remove a fruit from the basket");
                System.out.println("5. Want more fruits? Update the quantity of a fruit in the basket");
                System.out.println("6. History of purchases");
                System.out.println("6. Ready to checkout? Proceed to checkout");

                int choice = getIntInput("Enter your choice: ");

                switch (choice) {
                    case 1:
                        printArticlesMenu(); //Fungerar
                        break;
                    case 2:
                        addFruitToCart(jwt); //Fungerar inte
                        break;
                    case 3:
                        viewCart(jwt); //Fungerar
                        break;
                    case 4:
                        deleteFruitFromCart(jwt); //Fungerar
                        break;
                    case 5:
                        updateFruitQuantity(jwt); //Fungerar
                        break;
                    case 6:
                        getHistory(jwt); // TODO
                        break;
                    case 7:
                        purchaseCart(jwt); // TODO
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 7.");
                        userMenu(jwt);
                        break;
                }
            }
        }


    private static void addFruitToCart(String jwt) throws IOException, ParseException {
        printArticlesMenu();
        int articleNumber = getIntInput("Enter the article number of a fruit to add to the basket: ");
        int quantity = getIntInput("Enter the quantity: ");

        // Hämtar artiklar från databasen
        List<Article> articles = ArticleService.getAllArticles();
        if (articleNumber > 0 && articleNumber <= articles.size()) {
            Article selectedArticle = articles.get(articleNumber - 1);
            int cartId = getIntInput("Enter the cart ID: ");

            // Lägger till artiklar i Cart
            // Math to int exact konverterar från long till int
            CartService.addArticleToCart(cartId, Math.toIntExact(selectedArticle.getId()), quantity, jwt);
        } else {
            System.out.println("Invalid article number. Please try again.");
        }
    }

    private static void viewCart(String jwt) throws IOException, ParseException {
        int cartId = getIntInput("Enter the cart ID: ");
        CartService.getOneCartById(cartId, jwt);
    }

    private static void deleteFruitFromCart(String jwt) throws IOException, ParseException {
        int cartId = getIntInput("Enter the cart ID: ");
        int articleId = getIntInput("Enter the article ID: ");
        CartService.deleteArticleFromCart(cartId, articleId, jwt);
    }

    private static void updateFruitQuantity(String jwt) throws IOException, ParseException {
        int cartId = getIntInput("Enter the cart ID: ");
        int articleId = getIntInput("Enter the article ID: ");
        int quantity = getIntInput("Enter the new quantity: ");
        CartService.updateArticleCount(cartId, articleId, quantity, jwt);
    }

    private static void getHistory(String jwt) throws IOException, ParseException {
        HistoryService.getCurrentUserHistory(jwt);
    }

    private static void purchaseCart(String jwt) throws IOException, ParseException {
        CartService.purchaseArticles(jwt);
    }
}


