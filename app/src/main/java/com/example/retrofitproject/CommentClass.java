package com.example.retrofitproject;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

public class CommentClass {
    private  int postId ;
    private  int id;
    private String name;
    private String Email;
    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public String getText() {
        return text;
    }
}
