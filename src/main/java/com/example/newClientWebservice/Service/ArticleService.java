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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ArticleService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static ArrayList<Article> getAllArticles() throws IOException, ParseException {

        HttpGet request = new HttpGet("http://localhost:8081/articles");

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error uppstod");
            return null;
        }

        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Article> articles = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<Article>>() {});

        for (Article article : articles) {
            System.out.println(String.format("Artikel: %s \n Pris: %.2f \n ", article.getName(), article.getCost()));
        }
        return articles;
    }

    public static void getOneArticle(int id) throws IOException, ParseException {

        HttpGet request = new HttpGet(String.format("http://localhost:8081/articles/%d", id));

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error uppstod");
            return;
        }
        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        Article article = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Article>() {});

        System.out.println(String.format("Artikeln %s kostar %.2f", article.getName(), article.getCost()));
    }
}
