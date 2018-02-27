package com.yoda.models;

import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * Created by abhimanyus on 12/19/17.
 */
public abstract class User {


    @Id
    UUID userId;
    String userName;
    String email;
    String mobile;
    String address;
    String password;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract boolean isAdmin();
    public abstract boolean isQueryResolver();

}
