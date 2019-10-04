package com.codegym.service.impl;

import com.codegym.model.Upload;
import com.codegym.repository.UploadRepository;
import com.codegym.service.ServiceUpload;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceUploadImpl implements ServiceUpload {
    @Autowired
    private UploadRepository uploadRepository;

    @Override
    public List<Upload> findAll() {
        return uploadRepository.findAll();
    }

    @Override
    public void save(Upload upload) {
uploadRepository.save(upload);
    }
}
