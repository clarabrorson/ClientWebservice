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

        // Include an Authorization method to the request
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        // Execute the Request
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getCode() != 200) {
                System.out.println("Error");
                return null;
            }

            // Display the response payload in the console
            HttpEntity entity = response.getEntity();

            // Convert ResponsePayload to a useful object.
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<History> histories = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<History>>() {
            });

            System.out.println("Histories:");
            // Print out the histories in the list
            for (History history : histories) {
                System.out.println(String.format(
                        "  History id: %d, totalCost: %d, user: %s",
                        history.getId(), history.getTotalCost(), history.getUser()
                ));
            }

            return histories;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<History> getCurrentUserHistory(String jwt) {
        HttpGet request = new HttpGet("http://localhost:8081/webshop/history/currentUserHistory");

        // Include an Authorization method to the request
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        // Execute the Request
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getCode() != 200) {
                System.out.println("Error");
                return null;
            }

            // Display the response payload in the console
            HttpEntity entity = response.getEntity();

            // Convert ResponsePayload to a useful object.
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Article> articles = mapper.readValue(EntityUtils.toString(entity), new TypeReference<ArrayList<Article>>() {
            });

            System.out.println("Purchased Articles:");
            // Print out the articles in the list
            for (Article article : articles) {
                System.out.println(String.format(
                        "  Article id: %d, name: %s, cost: %f, description: %s, quantity: %d",
                        article.getId(), article.getName(), article.getCost(), article.getDescription(), article.getQuantity()
                ));
            }

            return null;  // Update this to return the actual list of histories
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        String jwt = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYWRtaW4iLCJpYXQiOjE3MDI5MDUzMTksInJvbGVzIjoiQURNSU4ifQ.bgeiYV_AxaJggsxUT9S7_0wYKv2dvX59CsX0zf_WmLYLoXe-Kn_LnYHSHRy9NL_aw5jxykNwQUiDLhkoeVL9jdjwNEvPJO1laOmqxEP-JGQhmveBa80UxRbOknpswC77sCZAp54PrqB8YPx4R-F1ZLWvEi3dCW2vXN9b522Y8crHIwxYp13CyPWVtvnXBDZzyT7YP2vozssAFOHyH95dOy6pC_m312pOvYXxDhIyipED0pPKmeRWNWSy5LNg1vYVilHE_OyNv282FzcjMmLaneWWCT510nmtQ4-s7O_bRSNYpfEVnWTamCN0EZVSRfNgIuv0Ul3_d9vtwgu5SJ_vUw";
        getAllHistory(jwt);
    }
}
