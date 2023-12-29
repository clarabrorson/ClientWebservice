package com.example.newClientWebservice.Service;

import com.example.newClientWebservice.Models.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.newClientWebservice.Service.UtilService.*;

@Service
public class ArticleService {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

//    public static ArrayList<Article> getAllArticles() {
//        try {
//
//            HttpGet request = new HttpGet("http://localhost:8081/webshop/articles");
//            CloseableHttpResponse response = httpClient.execute(request);
//
//            if (response.getCode() != 200) {
//                System.out.println("Error occurred. HTTP response code: " + response.getCode());
//                return null;
//            }
//
//            HttpEntity entity = response.getEntity();
//            ObjectMapper mapper = new ObjectMapper();
//            ArrayList<Article> articles = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<Article>>() {});
//
//            for (Article article : articles) {
//                System.out.println(String.format("Article: %s \n Price: %d \n Description: %s \n Quantity: %d \n", article.getName(), article.getCost(), article.getDescription(), article.getQuantity()));
//            }
//            return articles;
//
//        } catch (IOException | ParseException e) {
//            System.out.println("Error: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
public static ArrayList<Article> getAllArticles() {
    try {
        HttpGet request = new HttpGet("http://localhost:8081/webshop/articles");
        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error occurred. HTTP response code: " + response.getCode());
            return null;
        }

        HttpEntity entity = response.getEntity();
        ObjectMapper mapper = new ObjectMapper();
        // Simply return the articles without printing
        return mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<Article>>() {});
    } catch (IOException | ParseException e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
}

    public static Article getOneArticle(int id) throws IOException, ParseException {

        HttpGet request = new HttpGet(String.format("http://localhost:8081/webshop/articles/%d", id));

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error occurred. HTTP response code: " + response.getCode());
            return null;
        }
        HttpEntity entity = response.getEntity();

        ObjectMapper mapper = new ObjectMapper();
        Article article = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Article>() {});

        System.out.println(String.format("Article: %s \n Price: %d", article.getName(), article.getCost()));
        return article;
    }

    public static Article createArticle() {
        Article article = new Article();

        article.setName(getStringInput("Enter the name of the article:"));
        article.setCost(getIntInput("Enter the price of the article:"));
        article.setDescription(getStringInput("Enter the description of the article:"));
        article.setQuantity(getIntInput("Enter the quantity of the article:"));
        return article;
    }

    public static void addArticle(String jwt) throws IOException, ParseException {

       Article newArticle = createArticle();

        HttpPost request = new HttpPost("http://localhost:8081/webshop/articles");

        ObjectMapper mapper = new ObjectMapper();
        StringEntity payload = new StringEntity(mapper.writeValueAsString(newArticle), ContentType.APPLICATION_JSON);

        request.setEntity(payload);

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error occurred");
            return;
        }

        HttpEntity entity = response.getEntity();

        Article responseArticle = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Article>() {});

        if (responseArticle.getName().equals(newArticle.getName()) && responseArticle.getCost() == newArticle.getCost()
                && responseArticle.getDescription().equals(newArticle.getDescription()) && responseArticle.getQuantity() == newArticle.getQuantity()) {
            System.out.println(String.format("The article: %s, has been added", responseArticle.getName()));
        } else {
            System.out.println("Something went wrong");
        }
    }

    public static Void updateArticle(int id, String jwt) throws IOException, ParseException {

        Article article = createArticle();

        HttpPatch request = new HttpPatch(String.format("http://localhost:8081/webshop/articles/%d", id));

        ObjectMapper mapper = new ObjectMapper();
        StringEntity payload = new StringEntity(mapper.writeValueAsString(article), ContentType.APPLICATION_JSON);

        request.setEntity(payload);

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error uppstod");
            return null;
        }

        HttpEntity entity = response.getEntity();

        Article responseArticle = mapper.readValue(EntityUtils.toString(entity), new TypeReference<Article>() {});

        if (responseArticle.getName().equals(article.getName()) && responseArticle.getCost() == article.getCost()
                && responseArticle.getDescription().equals(article.getDescription()) && responseArticle.getQuantity() == article.getQuantity()) {
            System.out.println(String.format("The article: %s, has been updated", responseArticle.getName()));
        } else {
            System.out.println("Something went wrong");
        }
        return null;
    }

    public static void deleteArticle(int id, String jwt) throws IOException, ParseException {

        HttpDelete request = new HttpDelete(String.format("http://localhost:8081/webshop/articles/%d", id));

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getCode() != 200) {
            System.out.println("Error occurred");
            return;
        }

        System.out.println(String.format("The article with ID: %d has been deleted", id));
    }
}
