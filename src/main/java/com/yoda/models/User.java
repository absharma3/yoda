package com.yoda.models;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

/**
 * Created by abhimanyus on 12/19/17.
 */
public abstract class User {


    @Id
    private String userId;
    private String userName;
    private String email;
    private String mobile;
    private String address;
    private String password;

    private DateTime createdTimestamp;
    private DateTime updatedTimestamp;


    public User() {
        userId = UUID.randomUUID().toString();
        createdTimestamp = DateTime.now();
        updatedTimestamp = DateTime.now();
    }


    public void setEmail(String email) {
        this.email = email;
        this.updatedTimestamp = DateTime.now();
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
        this.updatedTimestamp = DateTime.now();
    }

    public void setAddress(String address) {
        this.address = address;
        this.updatedTimestamp = DateTime.now();
    }

    public void setPassword(String password) {
        this.password = password;
        this.updatedTimestamp = DateTime.now();
    }

    public String getUserId() {

        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp.toDate();
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp.toDate();
    }

    public abstract boolean isAdmin();
    public abstract boolean isQueryResolver();


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreatedTimestamp(DateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public void setUpdatedTimestamp(DateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}
