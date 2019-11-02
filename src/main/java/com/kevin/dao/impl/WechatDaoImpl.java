package com.kevin.dao.impl;

import com.kevin.dao.WechatDao;
import com.kevin.model.WechatModel;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Criteria;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public int updateInfo(Map param) {
        int id = Integer.parseInt(param.get("id").toString()) ;
        int res = dao.update("wechat_public_test", Chain.from(param),Cnd.where("id","=",id));
        return res;
    }

    @Override
    public int insertTask(Map param) {
        param.put(".table","wechat_public_test");
        int res = 0 ;

        try {
            dao.insert(param);
            System.out.println("插入成功");
            res++;
        } catch (Exception e) {
            System.out.println("插入任务失败");
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int del(Integer id) {
        int res = 0;
        try {
            res = dao.delete(WechatModel.class,id);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
        return res;
    }
}