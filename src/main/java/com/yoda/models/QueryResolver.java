package com.yoda.models;

/**
 * Created by abhimanyus on 12/19/17.
 */
public class QueryResolver extends User {

    boolean queryResolver = true;

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public boolean isQueryResolver() {
        return this.queryResolver;
    }


}
