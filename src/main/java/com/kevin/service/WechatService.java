package com.kevin.service;

import com.kevin.dao.WechatDao;
import com.kevin.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service
public class WechatService {
//    @Autowired
    @Resource
    private WechatDao dao;

    public Map getInfo(int page_num, int page_size ,String keyword){
        int total = dao.getCount(keyword);
        List data = dao.getInfo(page_num,page_size,keyword);
        Map map = new HashMap();
        map.put("data",data);
        map.put("total",total);
        return map ;
    }

}