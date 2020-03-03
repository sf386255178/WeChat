package com.kevin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AUTHOR:Kevin Ding
 * TIME:2020/3/3
 * TODO:echarts控制层
 */
@Controller
@RequestMapping("/echarts/")
public class EchartsController {

    @RequestMapping("toPage")
    public String toPage(){
        return "echarts/demo1";
    }
}