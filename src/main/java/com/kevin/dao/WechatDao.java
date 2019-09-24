package com.kevin.dao;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface WechatDao {
     List getInfo(int page_num,int page_size,String keyword);
     int getCount(String keyword);
}
