package com.charles.api.config.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * 使用DatabaseContextHolder获取当前线程的DatabaseType
 *
 * @author <a href="mailto:weijie_huang@sui.com"> weijie_huang </a>
 * 2018/1/15 18:56
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }
}
