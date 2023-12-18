package com.example.newClientWebservice.Service;

import com.example.newClientWebservice.Models.Article;
import com.example.newClientWebservice.Models.History;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

public class HistoryService {
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static ArrayList<History> getAllHistory(String jwt) { //för admin
        //skapa ett objekt av http get klassen
        HttpGet request = new HttpGet("http://localhost:8081/webshop/history");

        //Inludera en Authorization metod till request
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        // Exekvera Request
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getCode() != 200) {
                System.out.println("Error");
                return null;
            }

            //Visa upp response payload i console
            HttpEntity entity = response.getEntity();

            //Konvertera ResponsePayload till användbart objekt.
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<History> histories = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<History>>() {
            });

            for (History history : histories) {
                System.out.println(String.format("Article: %s", history.getPurchasedArticles()));
            }
            return histories;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<History> getCurrentUserHistory(String jwt){
        HttpGet request = new HttpGet("http://localhost:8081/webshop/history/currentUserHistory");

        //Inludera en Authorization metod till request
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
        // Exekvera Request
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getCode() != 200) {
                System.out.println("Error");
                return null;
            }

            //Visa upp response payload i console
            HttpEntity entity = response.getEntity();

            //Konvertera ResponsePayload till användbart objekt.
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<History> histories = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<History>>() {
            });

            for (History history : histories) {
                System.out.println(String.format("Article: %s", history.getPurchasedArticles()));
            }
            return histories;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
