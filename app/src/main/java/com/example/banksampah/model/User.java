package com.example.banksampah.model;

public class User {
    String Displayname;

    String Email;
    long createdAt;

    public User(String displayname,String email,long createdAt){
        this.Displayname=displayname;
        this.Email=email;
        this.createdAt=createdAt;
    }


    public String getDisplayname() {
        return Displayname;
    }

    public String getEmail() {
        return Email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

}