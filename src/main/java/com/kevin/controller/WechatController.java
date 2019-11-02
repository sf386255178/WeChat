package com.kevin.controller;

import com.kevin.service.WechatService;
import com.kevin.util.NutzDaoUtil;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/23
 * 微信任务类控制层
 */
@Controller
@RequestMapping("wechat/")
public class WechatController {
    @Autowired
    private WechatService service;

    @Resource
    private NutDao dao;

    @RequestMapping("toPage")
    public  String toPage(){
        return "wechat/page";
    }

    @RequestMapping("getInfo")
    @ResponseBody
    public Map getInfo(@RequestBody Map param){
        int page_num =Integer.parseInt( param.get("page_num").toString());
        String keyword = param.get("keyword").toString();
        System.err.println("参数为"+page_num);
        return service.getInfo(page_num,10,keyword);
    }

    @RequestMapping("util")
    @ResponseBody
    public Map toData(){
        return service.utilTest();
    }

    @RequestMapping("update")
    @ResponseBody
    public  int updata(@RequestBody Map param){
        return  service.update(param);
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insert(@RequestBody Map param){
        return  service.insert(param);
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    public  int del(@PathVariable Integer id){
        return  service.del(id);
    }

    @RequestMapping("list")
    @ResponseBody
    public List toList(){
        String sql = "SELECT * FROM wechat_public_test WHERE `status` = 0 AND request_id = 20190723 LIMIT 2";

        List data = NutzDaoUtil.queryInfo(sql,dao);
        return  data;
    }


}