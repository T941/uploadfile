package com.codegym.repository.impl;

import com.codegym.model.Upload;
import com.codegym.repository.UploadRepository;

import java.util.ArrayList;
import java.util.List;

public class UploadRepositoryImpl implements UploadRepository {
    List<Upload> uploadList = new ArrayList<>();

    {
        uploadList.add(new Upload("A7.jpeg"));
        uploadList.add(new Upload("M20.jpeg"));
    }

    @Override
    public List<Upload> findAll() {
        return uploadList;
    }

    @Override
    public void save(Upload upload) {
        uploadList.add(upload);
    }
}


