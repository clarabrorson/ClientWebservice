package com.example.newClientWebservice.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilService {

    public static String getStringInput(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String input = scan.nextLine();

//        if (input.matches(".*\\d.*")) {
//            System.out.println("Invalid input. Please do not enter numbers.\n");
//            return getStringInput(prompt);
//        } else if (input.equals("")) {
//            System.out.println("Try again.");
//            return getStringInput(prompt);
//        }
        return input;
    }

    public static int getIntInput(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);

        try {
            int input = scan.nextInt();

            if (input == 0) {
                System.out.println("Try again");
                return getIntInput(prompt);
            }
            return input;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.\n");
            scan.next(); // discard the invalid input
            return getIntInput(prompt);
        }
    }

    public static StringEntity createPayload(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        StringEntity payload = new StringEntity(mapper.writeValueAsString(object), ContentType.APPLICATION_JSON);

        return payload;
    }

    public static String getStringInputForHttpPatch(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String input = scan.nextLine();

        if (input.equals("")) {
            System.out.println("No changes made.");
        }
        return input;
    }

    public static int getIntInputForHttpPatch(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String input = scan.nextLine();

        if (input.isEmpty()) {
            System.out.println("No changes made.");
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getIntInputForHttpPatch(prompt);
        }
    }
}
