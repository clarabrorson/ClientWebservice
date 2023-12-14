package com.example.newClientWebservice.Service;

import com.example.newClientWebservice.Models.Cart;
import com.example.newClientWebservice.Models.User;
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

public class UserService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void getUser(String jwt) throws IOException, ParseException {

            HttpGet request = new HttpGet("http://localhost:8081/webshop/user");

            request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

            CloseableHttpResponse response = httpClient.execute(request);
            if (response.getCode() != 200) {
                System.out.println("Something went wrong");
                return;
            }

            HttpEntity entity = response.getEntity();

            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(EntityUtils.toString(entity), new TypeReference<User>() {});

        System.out.println(user.toString());

    }
    public static void register()throws IOException, ParseException{
        // skapa ett username och password
    }


    public static void main(String[] args) throws IOException, ParseException {
        // Replace with your actual JWT token
        String jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiamFmYXIiLCJpYXQiOjE3MDI1ODQ5NzEsInJvbGVzIjoiVVNFUiJ9.vzqbptQ1S9vMixxTkyTAH4_oolzXPeXOnYUOqXy11YEsVVFTbPnTTvvLA-i2sZq8RFLO4sngO_dxkscpXlumvfbhr62_sjRgqhROCAgCWzOzzV0OjbhkAMO1Io5lGxz_ueGH13cgSDUJFYu04ITBa5lzRbmkSJBaQ1owENaSFztMfN9dI4hCsfpjS24W0u7g7WDid_WsJFSMBDhbNzHk6Z2yMRZY4kwmzFrVDO2Kinzh91igpklmwwaKUvFQajf4072KSqfYMxaDC1S1dtODV8twipHLe5j5dZUnOdeDXWTTZqFGnyFGRqBK7Atbufl2v30lhFSTYaWTvKpEyLAVng";

        getUser(jwtToken);
    }
}
