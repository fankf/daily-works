package com.fankf.model;

import com.fankf.enums.DataSourceEnum;

/**
 * @author fankunfeng
 * 2021-01-28 18:25
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DataSourceEnum> contextHolder = new ThreadLocal<>();

    public static void setDataSource(DataSourceEnum dataSourceEnum) {
        contextHolder.set(dataSourceEnum);
    }

    public static DataSourceEnum getDataSource() {
        return contextHolder.get();
    }
}
