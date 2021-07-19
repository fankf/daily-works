package com.fankf.base;

/**
 * @author fankf
 * @date 2021/5/26 16:45
 * @description
 */
/**
 * Copyright 2021 bejson.com
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Auto-generated: 2021-05-26 16:50:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Cal {
    @JSONField(name = "id")
    private String id;
    @JSONField(name = "pid")
    private String pid;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "caseLibraryId")
    private String caseLibraryId;
    @JSONField(name = "createUser")
    private String createUser;
    @JSONField(name = "createTime")
    private String createTime;
    @JSONField(name = "updateUser")
    private String updateUser;
    @JSONField(name = "updateTime")
    private String updateTime;
    @JSONField(name = "sort")
    private String sort;
    @JSONField(name = "count")
    private int count;
    @JSONField(name = "allCount")
    private int allCount;
    @JSONField(name = "tableId")
    private String tableId;
    @JSONField(name = "children")
    private List<Cal> children;



}
