package com.codegym.model;



public class Upload {
    private String avatar;
    private int id;


    public Upload() {
    }

    public Upload(String avatar,int id) {
        this.avatar = avatar;
        this.id=id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
