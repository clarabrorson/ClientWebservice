package com.example.newClientWebservice.Menu;

import static com.example.newClientWebservice.Menu.Login.getUserChoice;
import static com.example.newClientWebservice.Service.ArticleService.getAllArticles;
import static com.example.newClientWebservice.Service.CartService.*;
import static com.example.newClientWebservice.Service.HistoryService.getCurrentUserHistory;

public class UserMenu {

    private static void userMenu() {
        while (true) {
            System.out.println("Welcome to Fruit Haven!");
            System.out.println("1. View all fruits");
            System.out.println("2. Add a fruit to the basket");
            System.out.println("3. View basket");
            System.out.println("4. Remove a fruit from the basket");
            System.out.println("5. Want more fruits? Update the quantity of a fruit in the basket");
            System.out.println("6. History of purchases");
            System.out.println("6. Ready to checkout? Proceed to checkout");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    getAllArticles();
                    break;
                case 2:
                    addArticleToCart(); // TODO: addArticleToCart
                    break;
                case 3:
                    getOneCartById();
                    break;
                case 4:
                    deleteArticleFromCart();
                    break;
                case 5:
                    updateArticleCount();
                    break;
                case 6:
                    getCurrentUserHistory();
                    break;
                case 7:
                    purchaseArticles();
            }
        }
    }
}