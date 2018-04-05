package com.beesightsoft.training6.service.model;

import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("id")
    private String id;

    @SerializedName("postId")
    private String postId;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String niceEmail;

    @SerializedName("body")
    private String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNiceEmail() {
        return niceEmail;
    }

    public void setNiceEmail(String niceEmail) {
        this.niceEmail = niceEmail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
