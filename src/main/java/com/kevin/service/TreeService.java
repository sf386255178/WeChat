package com.kevin.service;

import com.kevin.dao.TreeDao;
import com.kevin.model.TreeModel;
import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/24
 * 树控件服务层
 */
@Service
public class TreeService {
    @Autowired
    private TreeDao dao;

    public List treeData(){
        List<TreeModel> treeLists = new ArrayList<TreeModel>();//树需要的标准数据
        List<Record> records = dao.getInfo();//全部数据集合
        for (Record r: records) {//遍历每一个节点数据
            Integer pid = r.getInt("pid");//父节点id
            TreeModel vo = new TreeModel();//封装节点数据为标准数据类型
            vo.setId(r.getInt("id"));
            vo.setLabel(r.getString("name"));
            vo.setChildren(new ArrayList<TreeModel>());
            if (pid == 0){//为父节点时直接添加到数据模型中
                treeLists.add(vo);
            }else {//次级节点的处理
                for (int i = 0;i<treeLists.size();i++){
                    TreeModel seconds = treeLists.get(i);//获取父级节点
                    if (seconds != null && pid == seconds.getId()){//次级节点的id等于父id时，加入数据模型的children中
                        seconds.getChildren().add(vo);//获取父节点的child，然后赋值
                        break;
                    }
                }
            }
        }
        return  treeLists;

    }

}