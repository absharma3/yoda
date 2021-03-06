package com.yoda.models;

import org.joda.time.DateTime;

import java.util.Date;
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


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp.toDate();
    }

    public void setCreatedTimestamp(DateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp.toDate();
    }

    public void setUpdatedTimestamp(DateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getJokeId() {

        return jokeId;
    }
}
