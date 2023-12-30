package com.example.newClientWebservice.Service;

import com.example.newClientWebservice.Models.Cart;
import com.example.newClientWebservice.Models.History;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
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

import static com.example.newClientWebservice.Service.UserService.login;

public class CartService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void getAllCarts(String jwt) throws IOException, ParseException {

        HttpGet request = new HttpGet("http://localhost:8081/webshop/cart");

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Something went wrong");
            System.out.println(response.getCode());
            return;
        }

        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Cart> carts = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<Cart>>() {});

        for (Cart cart : carts) {
            System.out.println(String.format("Cart %s belongs to %s and contains %s", (Object) cart.getId(), (Object) cart.getUsername(), (Object) cart.getArticles()));
        }
    }

    public static void getOneCartById(int id, String jwt) throws IOException, ParseException {

        HttpGet request = new HttpGet(String.format("http://localhost:8081/webshop/cart/%d", id));

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Something went wrong");
            System.out.println(response.getCode());
            return;
        }
        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        Cart cart = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Cart>() {});

        System.out.println(String.format("Cart %s belongs to %s and contains %s", cart.getId(), cart.getUsername(), cart.getArticles()));
    }

    public static void addArticleToCart(int cartId, int articleId, String jwt) throws IOException, ParseException {
        HttpPost request = new HttpPost(String.format("http://localhost:8081/webshop/cart/%d", articleId));

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Something went wrong");
            System.out.println(response.getCode());
            return;
        }

        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        Cart cart = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Cart>() {});

        System.out.println(String.format("Article %s added to cart %s", articleId, cartId));
    }




    public static void updateArticleCount(int cartId, int articleId, int quantity, String jwt) throws IOException, ParseException {

        HttpPatch request = new HttpPatch(String.format("http://localhost:8081/webshop/cart/%d/articles/%d?quantity=%d", cartId, articleId, quantity));

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Something went wrong");
            System.out.println(response.getCode());
            return;
        }

        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        Cart cart = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Cart>() {});

        System.out.println(String.format("Article %s in cart %s has updated its quantity to %d", articleId, cartId, quantity));
    }

    public static void deleteArticleFromCart(int cartId, int articleId, String jwt) throws IOException, ParseException {

        HttpDelete request = new HttpDelete(String.format("http://localhost:8081/webshop/cart/%d/articles/%d", cartId, articleId));

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Something went wrong");
            System.out.println(response.getCode());
            return;
        }

        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        Cart cart = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Cart>() {});

        //Skriv ut cart och artikel som har tagits bort
        System.out.println(String.format("Article %s has been deleted from cart %s", articleId, cartId));
    }

    public static void purchaseArticles(String jwt) {
        try {
            HttpPost request = new HttpPost("http://localhost:8081/webshop/history/purchase");

            request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                if (response.getCode() != 200) {
                    System.out.println(response.getCode());
                    System.out.println("Error");
                    return;
                }

                System.out.println("Purchase completed successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {

   String jwt = String.valueOf(login().getJwt());


          // getOneCartById(1, jwt);
         //addArticleToCart(4, 1, jwt);
        //getAllCarts(jwt);
//            purchaseArticles(jwt);
            //updateArticleCount(1, 1, 5, jwt);
//            deleteArticleFromCart(1, 1, jwt);

    }

}
