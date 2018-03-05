package com.yoda.models;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * Created by abhimanyus on 2/27/18.
 */
@Document
public class Article {

    @Id
    private String articleId;
    private String title;
    private String imageUrl;
    private String body;

    private DateTime createdTimestamp;
    private DateTime updatedTimestamp;

    public Article() {
        this.articleId = UUID.randomUUID().toString();
        this.createdTimestamp = DateTime.now();
        this.updatedTimestamp = DateTime.now();

    }


    public String getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBody() {
        return body;
    }

    public DateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public DateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }
}
