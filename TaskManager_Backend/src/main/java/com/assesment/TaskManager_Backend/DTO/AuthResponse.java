package com.assesment.TaskManager_Backend.DTO;

public class AuthResponse {
    private String token;

    // Constructor
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter for
    public String getToken() {
        return token;
    }
}
