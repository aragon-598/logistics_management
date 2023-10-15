package com.ingeneo.logisticmanagement.security.dto;

public class JwtDto {
    
    private String token;


    public JwtDto(String token) {
        this.token = token;
    }


    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
