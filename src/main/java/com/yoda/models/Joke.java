package com.yoda.models;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Created by abhimanyus on 3/5/18.
 */
public class Joke {

    private String jokeId;
    private String body;
    private String heading;

    private DateTime createdTimestamp;
    private DateTime updatedTimestamp;

    public Joke() {
        this.jokeId = UUID.randomUUID().toString();
        this.createdTimestamp = DateTime.now();
        this.updatedTimestamp = DateTime.now();
    }
}
