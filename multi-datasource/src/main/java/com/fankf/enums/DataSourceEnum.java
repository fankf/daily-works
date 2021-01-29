package com.fankf.enums;

import lombok.Getter;

/**
 * @author fankunfeng
 * 2021-01-28 18:29
 */
@Getter
public enum DataSourceEnum {

    S0(1, "s0"),
    S1(2, "s1"),
    ;
    private Integer key;
    private String value;

    DataSourceEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
}
