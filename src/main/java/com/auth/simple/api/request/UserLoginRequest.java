package com.auth.simple.api.request;


public class UserLoginRequest {

    private String email;
    private String password;

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

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
