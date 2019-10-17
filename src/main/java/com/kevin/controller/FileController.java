package com.kevin.controller;

import com.kevin.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/10/15
 * TODO:Excel文件上传
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private FileService service;

    @RequestMapping(value = "/toPage")
    public String toPage(){
        return "file/file";
    }

    @RequestMapping(value = "/import")
    @ResponseBody
    public  String uploadFile(@RequestParam("file")MultipartFile file){
        System.out.println("文件名为"+file.getOriginalFilename());
        if (file!=null && !file.isEmpty()){

            return   service.upFile(file);
        }else {
            return "未收到文件";
        }

    }

    @RequestMapping(value = "test")
    @ResponseBody
    public boolean upSucc(){
        return true;
    }

}