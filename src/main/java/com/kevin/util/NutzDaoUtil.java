/**
*@author      :Kevin  Ding
*@Date        :2019��11��1��-����2:07:05
*@Description :TODO
**/
package com.kevin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Component;

@Component
public class NutzDaoUtil {
	public static NutDao getDao() {
		SimpleDataSource dataSource = new SimpleDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/a");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		NutDao dao = new NutDao(dataSource);
		return dao;
	}
	
	
	public static List<Record> queryInfo(String sql,NutDao dao){
		Sql sqls = Sqls.create(sql);
		sqls.setEntity(dao.getEntity(Record.class));
		sqls.setCallback(Sqls.callback.entities());
		dao.execute(sqls);
		List<Record> res = sqls.getList(Record.class);
		return res;
	}

	/**
	 * 含有占位符的查询操作
	 * @param sql 自定义的sql
	 * @param dao
	 * @param param 变量占位符
	 * @return
	 */
	public static List<Record> query(String sql, NutDao dao, Map param){
		Sql sqls = Sqls.create(sql);
		sqls.setEntity(dao.getEntity(Record.class));
		sqls.setCallback(Sqls.callback.entities());
		List p = new ArrayList();
		if (null != param &&  0 < param.size() && !param.isEmpty()){
			for (Object key: param.keySet()) {
				p.add(key);
			}
			for (int i = 0; i <p.size() ; i++) {
				sqls.setParam(p.get(i).toString(),param.get(p.get(i)));
			}
		}
		dao.execute(sqls);
		System.out.println(sqls.toString());
		List<Record> res = sqls.getList(Record.class);
		return res;
	}
}
