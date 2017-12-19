package com.yoda.models;

import org.springframework.data.annotation.Id;

/**
 * Created by abhimanyus on 12/19/17.
 */
public class AdminUser extends User {

    boolean admin = true;

    @Override
    public boolean isAdmin() {
        return this.admin;
    }

    @Override
    public boolean isQueryResolver() {
        return false;
    }
}
