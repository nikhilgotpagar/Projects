package com.jwtauth.model;

public class JwtRequest {

    String username;
    String passowrd;

    public JwtRequest(String username, String passowrd) {
        this.username = username;
        this.passowrd = passowrd;
    }

    public JwtRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    @Override
    public String toString() {
        return "JwtRequest{" +
                "username='" + username + '\'' +
                ", passowrd='" + passowrd + '\'' +
                '}';
    }
}
