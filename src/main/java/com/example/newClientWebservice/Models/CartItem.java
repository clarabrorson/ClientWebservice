package com.example.newClientWebservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    private Long id;
    private Cart cart;
    private Article article;
    private int quantity;

    public CartItem(Article article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
