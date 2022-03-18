package com.fankf.file.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fankunfeng
 * @date 2022-01-13 10:06:08
 */
@Data
public class CompanyManagerPOI implements Serializable {

    private static final long serialVersionUID = -8528679192922359821L;

    /**
     * 企业名称
     */
    @Excel(name = "企业名称" ,orderNum = "0")
    private String companyName;

}
