package com.kevin.dao.impl;

import com.kevin.dao.WechatDao;
import com.kevin.model.WechatModel;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/23
 * 查询接口实现类
 */
@Component
public class WechatDaoImpl implements WechatDao {
    @Resource
    private NutDao dao;


    @Override
    public List getInfo(int page_num, int page_size, String keyword) {
        Criteria cri = Cnd.cri();
        cri.getOrderBy().desc("id");
        if (keyword!=null){
            cri.where().andLike("keyword",keyword);
        }
        List<WechatModel> info = dao.query(WechatModel.class,cri,dao.createPager(page_num,page_size));
        return info;
    }

    @Override
    public int getCount(String keyword) {
        Criteria cri = Cnd.cri();
        if (keyword!=null){
            cri.where().andLike("keyword",keyword);
        }
        int total = dao.count(WechatModel.class,cri);
        return total;

    }
}