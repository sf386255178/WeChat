package com.kevin.controller;

import com.kevin.model.Page;
import com.kevin.service.WechatService;
import org.nutz.mvc.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/23
 * 微信任务类控制层
 */
@Controller
@RequestMapping("wechat/")
public class WechatController {
    @Resource
    private WechatService service;

    @RequestMapping("toPage")
    public  String toPage(){
        return "wechat/page";
    }

    @RequestMapping("getInfo")
    @ResponseBody
    public Map getInfo(int page_num,String keyword){
        System.err.println("参数为"+page_num);
        return service.getInfo(page_num,10,keyword);
    }



}