package com.example.newClientWebservice.Service;

import com.example.newClientWebservice.Models.Cart;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class CartService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void getAllCarts(String jwt) throws IOException, ParseException {

        //Skapa ett objekt av HttpGet klassen. Inkludera URL
        HttpGet request = new HttpGet("http://localhost:8081/carts");

        //Inkludera en Authorization metod till request
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        //Exekvera Request
        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Something went wrong");
            return;
        }

        //Visa upp response payload i console
        HttpEntity entity = response.getEntity();
        //System.out.println(EntityUtils.toString(entity));

        //Konvertera ResponsePayload till användbart objekt.
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Cart> carts = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<Cart>>() {});

        //Loopa igenom och skriv ut carts med tillhörande användare och artiklar
        for (Cart cart : carts) {
            System.out.println(String.format("Cart %s belongs to %s and contains %s", (Object) cart.getId(), (Object) cart.getUser(), (Object) cart.getArticles()));
        }
    }


}
