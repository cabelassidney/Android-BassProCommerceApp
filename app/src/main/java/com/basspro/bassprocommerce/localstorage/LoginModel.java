package com.basspro.bassprocommerce.localstorage;

/**
 * Created by manep on 3/7/2018.
 */

public class LoginModel {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String username, password,email;
}
