package org.example.model;

public class UserResponse{
    public boolean success;
    public String accessToken;
    public String refreshToken;

    public UserResponse(boolean success, String accessToken, String refreshToken) {
        this.success = success;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
    public String getAccessToken() {
        return accessToken;
    }

}
