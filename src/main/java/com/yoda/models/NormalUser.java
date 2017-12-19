package com.yoda.models;

/**
 * Created by abhimanyus on 12/19/17.
 */
public class NormalUser extends User{

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public boolean isQueryResolver() {
        return false;
    }
}
