package com.charles.api.config.dataSource;

/**
 * 保存一个线程安全的DatabaseType容器
 *
 * @author <a href="mailto:weijie_huang@sui.com"> weijie_huang </a>
 * 2018/1/15 18:57
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DatabaseType type){
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }
}
