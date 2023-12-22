package com.example.newClientWebservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Long id;
    private String name;
    private int cost;
    private String description;
    private int quantity;

//    private History history;

    public Article(String name, int cost, String description, int quantity) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.quantity = quantity;
    }

}
