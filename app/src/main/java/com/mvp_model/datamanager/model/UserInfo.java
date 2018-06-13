package com.mvp_model.datamanager.model;

public class UserInfo {

    String name, number, email;
    int id;

    public UserInfo(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public UserInfo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }
}
