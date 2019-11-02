package com.kevin.service;

import com.kevin.dao.WechatDao;
import com.kevin.util.NutzDaoUtil;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/23
 * 微信任务服务层
 */
@SuppressWarnings("all")
@Service
public class WechatService {
//    @Autowired
    @Resource
    private WechatDao dao;

    @Qualifier("kfDao")
    @Autowired
    private NutDao nutDao;

    public Map getInfo(int page_num, int page_size ,String keyword){
        int total = dao.getCount(keyword);
        List data = dao.getInfo(page_num,page_size,keyword);
        Map map = new HashMap();
        map.put("data",data);
        map.put("total",total);

        return map ;
    }

    public Map utilTest(){
        String sql = "SELECT * FROM wechat_public_test WHERE `status` = @status AND request_id = @request_id limit @limit";
        String sql2 = "SELECT * FROM mobile_baidu_waimai_product_task_daily WHERE id%10 ORDER BY id DESC   LIMIT 6";

        Map param = new HashMap();

        param.put("request_id",20190723);
        param.put("limit",2);
        param.put("status",0);
//        List data = NutzDaoUtil.queryInfo(sql,nutDao);
        List data = NutzDaoUtil.query(sql,nutDao,param);
        List data2 = NutzDaoUtil.query(sql2,nutDao,null);
        int num = nutDao.count("wechat_public_test");
        Map map = new HashMap();
        map.put("data",data);
        map.put("total",num);
        map.put("data2",data2);
        return  map;
    }

    public int update(Map param){
        return dao.updateInfo(param);
    }

    public int insert(Map param){
        return  dao.insertTask(param);
    }

    public int del(Integer id){
        return  dao.del(id);
    }



}