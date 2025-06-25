package com.unir.backend.turno.backend_digiturno.dto;

import com.unir.backend.turno.backend_digiturno.models.entities.User;

public class LoginResponse {
    private String token;
    private User user;

    public LoginResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }
}