package com.kevin.model;

import java.util.List;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/24
 * 树控件实体类,格式化树形控件的数据类型
 */

public class TreeModel {
    private  int id;
    private  String label;
    private List<TreeModel> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }
}