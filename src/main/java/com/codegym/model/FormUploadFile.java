package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;


public class FormUploadFile {
    private int id;
    private MultipartFile avatar;

    public FormUploadFile() {
    }

    public FormUploadFile(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FormUploadFile(int id, MultipartFile avatar) {
        this.id = id;
        this.avatar = avatar;
    }
}
