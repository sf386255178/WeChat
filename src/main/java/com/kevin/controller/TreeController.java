package com.kevin.controller;

import com.kevin.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/24
 * 树控件控制层
 */
@Controller
@RequestMapping("tree/")
public class TreeController {
    @Autowired
    private TreeService service;

    @RequestMapping("toPage")
    public  String toPage(){
        return "tree/tree";
    }
    @RequestMapping("toInfo")
    @ResponseBody
    public List toInfo(){
        return  service.treeData();
    }
}