package com.example.newClientWebservice.Service;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class ArticleService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void getAllArticles() {

        HttpGet request = new HttpGet("http://localhost:8081/article");

        CloseableHttpResponse response = httpClient.execute(request);


    }

}
