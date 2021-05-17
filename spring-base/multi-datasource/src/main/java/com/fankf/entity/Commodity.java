package com.fankf.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Commodity)实体类
 *
 * @author makejava
 * @since 2021-01-29 11:15:24
 */
public class Commodity implements Serializable {
    private static final long serialVersionUID = 662776814488446765L;

    private Integer id;

    private String classifyName;

    private String commodityName;

    private Date createTime;

    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}