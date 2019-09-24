package com.kevin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/23
 * 测试
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String toTest(){
        return "test/page";
    }

}