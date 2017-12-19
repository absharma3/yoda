package com.yoda.models;

import org.springframework.data.annotation.Id;

/**
 * Created by abhimanyus on 12/19/17.
 */
public abstract class User {


    @Id
    String userId;
    String userName;
    String emailAddress;
    String mobile;
    String address;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public abstract boolean isAdmin();
    public abstract boolean isQueryResolver();

}
