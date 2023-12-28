package com.example.newClientWebservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

        private Long id;
        private User user;
        private Set<Article> articles;
        private String username;
        public Cart(Long id) {
                this.id = id;
        }

        /**
         * Den här metoden tar emot ett LoginResponse-objekt och returnerar CartId
         * @param loginResponse LoginResponse-objekt som innehåller ett User-objekt som i sin tur innehåller ett Cart-objekt
         * @return CartId som är en Long eller null om CartId inte finns
         */
        public static Long getCartIdFromUser(LoginResponse loginResponse) {
                if (loginResponse != null && loginResponse.getUser() != null) {
                        return loginResponse.getUser().getCart().getId();
                }
                return null;
        }

}
