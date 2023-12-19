package com.example.newClientWebservice.Service;

import com.example.newClientWebservice.Models.Cart;
import com.example.newClientWebservice.Models.LoginResponse;
import com.example.newClientWebservice.Models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

import java.util.ArrayList;

public class UserService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void getUsers(String jwt) throws IOException, ParseException {

            HttpGet request = new HttpGet("http://localhost:8081/webshop/user");

            request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

            CloseableHttpResponse response = httpClient.execute(request);
            if (response.getCode() != 200) {
                System.out.println("Something went wrong");
                return;
            }

            HttpEntity entity = response.getEntity();

            ObjectMapper mapper = new ObjectMapper();
            ArrayList<User> users = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<User>>() {});

        for (User user : users) {
            System.out.println(String.format("Id: %d  Username: %s",user.getId(), user.getUsername()));
        }
    }
//    public static void register()throws IOException, ParseException{
//        // skapa ett username och password
//        String username = getStringInput("Enter username");
//        String password = getStringInput("Enter your password");
//
//        User newUser = new User(0L, username, password);
//
//        HttpPost request = new HttpPost("http://localhost:8081/webshop/auth/register");
//
//        request.setEntity(createPayload(newUser));
//
//        CloseableHttpResponse response = httpClient.execute(request);
//
//        if (response.getCode() != 200){
//            System.out.println("Something went wrong");
//            return;
//        }
//
//        HttpEntity payload = response.getEntity();
//
//        ObjectMapper mapper = new ObjectMapper();
//        User responseUser = mapper.readValue(EntityUtils.toString(payload), new TypeReference<User>() {});
//
//        System.out.println(String.format("User %s has been created with the id %d",responseUser.getUsername(), responseUser.getId()));
//    }
//
//    public static LoginResponse login(String username, String password) throws IOException, ParseException{
//        //Skapa user objekt
//        User loginUser = new User(0L, username, password);
//
//        //skapa ett nytt request
//        HttpPost request = new HttpPost("http://localhost:8081/webshop/auth/login");
//        //skapa en payload
//        request.setEntity(createPayload(loginUser));
//
//        //send request
//        CloseableHttpResponse response = httpClient.execute(request);
//        if (response.getCode() != 200){
//            System.out.println("Något har gått fel vi inloggning");
//            return null;
//        }
//
//        //hämta Payload från response
//        HttpEntity payload = response.getEntity();
//
//        //skapa User objekt från payload
//        ObjectMapper mapper = new ObjectMapper();
//        LoginResponse loginResponse = mapper.readValue(EntityUtils.toString(payload), new TypeReference<LoginResponse>() {});
//        return loginResponse;
//    }

    public static void main(String[] args) throws IOException, ParseException {
        // Replace with your actual JWT token
        String jwtToken = "";

        getUsers(jwtToken);
    }
}
