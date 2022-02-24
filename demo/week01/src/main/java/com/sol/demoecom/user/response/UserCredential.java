package com.sol.demoecom.user.response;

public class UserCredential {
    private String token;

    public UserCredential(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
