package com.example.newClientWebservice.Menu;

import com.example.newClientWebservice.Service.UtilService;

import static com.example.newClientWebservice.Menu.Login.getUserChoice;
import static com.example.newClientWebservice.Menu.UserMenu.userMenu;
import static com.example.newClientWebservice.Service.ArticleService.*;
import static com.example.newClientWebservice.Service.CartService.*;
import static com.example.newClientWebservice.Service.HistoryService.getAllHistory;
import static com.example.newClientWebservice.Service.HistoryService.getCurrentUserHistory;
import static com.example.newClientWebservice.Service.UserService.getUsers;
import static com.example.newClientWebservice.Service.UtilService.getIntInput;

public class AdminMenu {


//    public static void adminMenu1() {
//        while (true) {
//            System.out.println("Choose an option:");
//            System.out.println("1. User menu");
//            System.out.println("2. Admin menu");
//            System.out.println("3. Exit.");
//
//            int choice = getIntInput("Enter your choice: ");
//
//            switch (choice) {
//                case 1:
//                    userMenu();
//                    break;
//                case 2:
//                    adminMenu2();
//                    break;
//                case 3:
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
//                    adminMenu1();
//                    break;
//            }
//        }
//    }
//
//
//
//    public static void adminMenu2() {
//        while (true) {
//            System.out.println("Admin menu:n\n");
//            System.out.println("1. View all carts");
//            System.out.println("2. View all histories");
//            System.out.println("3. View all users");
//            System.out.println("4. Add article");
//            System.out.println("5. Update article");
//            System.out.println("6. Delete article");
//
//            int choice = UtilService.getIntInput("Enter your choice: ");
//
//            switch (choice) {
//                case 1:
//                   getAllCarts();
//                    break;
//                case 2:
//                    getAllHistory();
//                    break;
//                case 3:
//                   getUsers();
//                    break;
//                case 4:
//                    addArticle();
//                    break;
//                case 5:
//                   updateArticle();
//                    break;
//                case 6:
//                    deleteArticle();
//                    break;
//                default:
//                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
//                    adminMenu2();
//                    break;
//            }
//
//        }
//    }
}
