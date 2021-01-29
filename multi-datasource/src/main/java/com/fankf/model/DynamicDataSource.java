package com.fankf.model;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author fankunfeng
 * 2021-01-28 18:23
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDataSource();
    }
}
