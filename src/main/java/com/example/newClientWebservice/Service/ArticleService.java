package com.example.newClientWebservice.Service;

import com.example.newClientWebservice.Models.Article;
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

public class ArticleService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static ArrayList<Article> getAllArticles(String jwt) throws IOException, ParseException {

        HttpGet request = new HttpGet("http://localhost:8081/article");

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error uppstod");
            return null;
        }

        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Article> articles = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<Article>>() {});

        for (Article article : articles) {
            System.out.println(String.format("Artikeln %s kostar %s", article.getName(), article.getCost()));
        }
        return articles;
    }
}
