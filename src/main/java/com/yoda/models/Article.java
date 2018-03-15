package com.yoda.models;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * Created by abhimanyus on 2/27/18.
 */
@Document
public class Article {

    @Id
    private String articleId;
    private String title;
    private ImageInfo imageInfo;
    private String body;

    private DateTime createdTimestamp;
    private DateTime updatedTimestamp;

    public Article() {
        this.articleId = UUID.randomUUID().toString();
        this.createdTimestamp = DateTime.now();
        this.updatedTimestamp = DateTime.now();

    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedTimestamp(DateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public void setUpdatedTimestamp(DateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public String getBody() {
        return body;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp.toDate();
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp.toDate();
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }
}
