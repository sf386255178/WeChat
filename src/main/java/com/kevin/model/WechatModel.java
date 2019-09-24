package com.kevin.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * AUTHOR:Kevin Ding
 * 2019/9/23
 * 微信任务表实体类
 */
@Table("wechat_public_test")
public class WechatModel {
    @Id
    @Column
    private int id;
    @Column
    private String keyword;
    @Column
    private String biz;
    @Column
    private String wechat_key;
    @Column
    private int status;
    @Column
    private int page_index;
    @Column
    private int request_id;
    @Column
    private int key_status;
    @Column
    private String pass_ticket;

    public WechatModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getBiz() {
        return biz;
    }

    public void setBiz(String biz) {
        this.biz = biz;
    }

    public String getWechat_key() {
        return wechat_key;
    }

    public void setWechat_key(String wechat_key) {
        this.wechat_key = wechat_key;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPage_index() {
        return page_index;
    }

    public void setPage_index(int page_index) {
        this.page_index = page_index;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getKey_status() {
        return key_status;
    }

    public void setKey_status(int key_status) {
        this.key_status = key_status;
    }

    public String getPass_ticket() {
        return pass_ticket;
    }

    public void setPass_ticket(String pass_ticket) {
        this.pass_ticket = pass_ticket;
    }
}