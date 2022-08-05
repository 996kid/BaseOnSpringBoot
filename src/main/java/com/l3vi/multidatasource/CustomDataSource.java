package com.l3vi.multidatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 996kid@gmail.com
 * @Description CustomDataSource
 * @Date 2022/5/26 16:13
 */
public class CustomDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
//        return DataSoutceContextHolder.getSourceName();
        return DataSourceStackContextHolder.peek();
    }
}
