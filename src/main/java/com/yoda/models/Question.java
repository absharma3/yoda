package com.yoda.models;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by abhimanyus on 12/18/17.
 */

@Document
public class Question {

    @Id
    private String questionId;
    private String userId;
    private String questionString;
    private List<String> comments = new ArrayList<String>();
    private String iPAddress;
    private String answerString;


    private DateTime createdTimestamp;
    private DateTime updatedTimestamp;

    public Question() {
        this.questionId = UUID.randomUUID().toString();
        this.createdTimestamp = DateTime.now();
        this.updatedTimestamp = DateTime.now();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getiPAddress() {
        return iPAddress;
    }

    public void setiPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public String getAnswerString() {
        return answerString;
    }

    public void setAnswerString(String answerString) {
        this.answerString = answerString;
    }

    public void addComment(String comment){
        comments.add(comment);
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
}

