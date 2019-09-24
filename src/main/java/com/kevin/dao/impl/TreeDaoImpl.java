package com.kevin.dao.impl;

import com.kevin.dao.TreeDao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/24
 * 树控件数据接口
 */
@Component
public class TreeDaoImpl implements TreeDao {
    @Resource
    private NutDao dao;


    @Override
    public List getInfo() {
        String sql = "SELECT * FROM treemenu";
        Sql userSql = Sqls.create(sql);
        userSql.setEntity(dao.getEntity(Record.class));
        userSql.setCallback(Sqls.callback.entities());
        dao.execute(userSql);
        List<Record> records = userSql.getList(Record.class);
        System.out.println(records.toString());
        return records;
    }
}