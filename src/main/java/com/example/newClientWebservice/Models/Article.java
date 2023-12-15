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
    private Double cost;
    private String description;
    private Integer quantity;

    private History history;

}
