package com.l3vi.multidatasource;

/**
 * @author 996kid@gmail.com
 * @Description DataSoutceContextHolder
 * @Date 2022/5/26 16:20
 */
public class DataSoutceContextHolder {

    // 存数据源名称
    private static final ThreadLocal<SourceTypeEnum> contextHolder = new ThreadLocal<>();

    public static SourceTypeEnum getSourceName() {
        return contextHolder.get();
    }

    public static void setSourceName(SourceTypeEnum sourceName) {
        contextHolder.set(sourceName);
    }
}
