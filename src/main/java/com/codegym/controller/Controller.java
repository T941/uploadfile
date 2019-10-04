package com.codegym.controller;


import com.codegym.model.FormUploadFile;
import com.codegym.model.Upload;
import com.codegym.service.ServiceUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("upload")
public class Controller {
    @Autowired
    Environment env;

    @Autowired
    private ServiceUpload serviceUpload;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listUpload() {
        ModelAndView modelAndView = new ModelAndView("/upload/list");
        List<Upload> uploadList = serviceUpload.findAll();
        modelAndView.addObject("uploads", uploadList);
        return modelAndView;
    }

    @GetMapping("/uploadfile")
    public String uploadfileForm(Model model) {
        model.addAttribute("formUploadFile", new FormUploadFile());
        return "/upload/uploadfile";
    }
    @PostMapping("/save-uploadfile")
    public ModelAndView saveUpload(@ModelAttribute FormUploadFile formUploadFile,BindingResult result){
        if (result.hasErrors()) {
            System.out.println("Result Error Occured" + result.getAllErrors());
        }
        MultipartFile multipartFile=formUploadFile.getAvatar();
        String fileName=multipartFile.getOriginalFilename();
        String fileUpload=env.getProperty("file_upload").toString();
        try {
            //multipartFile.transferTo(imageFile);
            FileCopyUtils.copy(formUploadFile.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Upload uploadObject=new Upload(formUploadFile.getAvatar(),formUploadFile.getId(), fileName);
        serviceUpload.save(uploadObject);
        ModelAndView modelAndView=new ModelAndView("/upload/uploadfile");
        modelAndView.addObject("formUploadFile",new Upload());
        return modelAndView;
    }


}





