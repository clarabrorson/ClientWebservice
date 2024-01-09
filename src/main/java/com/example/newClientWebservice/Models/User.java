package com.example.newClientWebservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
/**
 * @Author Jafar
 * Denna klass används för att skapa objekt av typen User.
 * det är en behållare för användarinformation
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Cart cart;
    private Set<Role> authorities;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean accountNonExpired;


    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

}
