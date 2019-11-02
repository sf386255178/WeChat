package com.kevin.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface WechatDao {
     List getInfo(int page_num,int page_size,String keyword);

     int getCount(String keyword);

     int updateInfo(Map param);

     int insertTask(Map param);

     int del(Integer id);

}
