package com.wangp.myaop.design_pattern.structural.proxy.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <pre>
 * classname DynamicDataSource
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 22:48
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        return DataSourceContextHolder.getDBType();
    }
}
