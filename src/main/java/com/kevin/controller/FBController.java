package com.kevin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AUTHOR:Kevin Ding
 * TIME:2020/2/24
 * TODO:ihg 测试
 */
@Controller
@RequestMapping("fb/")
public class FBController {

    @RequestMapping("toPage")
    public String toIndex(){
        return "views/test/BrandPerformance";
    }
}