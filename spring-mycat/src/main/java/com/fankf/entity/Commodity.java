package com.fankf.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Commodity)实体类
 *
 * @author makejava
 * @since 2021-01-29 10:50:33
 */
public class Commodity implements Serializable {
    private static final long serialVersionUID = -75173667328819662L;

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