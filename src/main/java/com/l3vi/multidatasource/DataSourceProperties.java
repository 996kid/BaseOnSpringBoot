package com.l3vi.multidatasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 996kid@gmail.com
 * @Description DataSourceProperties
 * @Date 2022/5/26 16:15
 */
@EnableConfigurationProperties
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.multiple")
public class DataSourceProperties {

    @Data
    static class Properties {
        private String username;

        private String password;

        private String url;

        private String driverClassName;
    }

    private Properties low;

    private Properties high;

    public Properties getLow() {
        return low;
    }

    public void setLow(Properties low) {
        this.low = low;
    }

    public Properties getHigh() {
        return high;
    }

    public void setHigh(Properties high) {
        this.high = high;
    }

    @Bean
    public CustomDataSource customDataSource(DataSource lowDataSource, DataSource highDataSource) {
        CustomDataSource customDataSource = new CustomDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(SourceTypeEnum.LOW, lowDataSource);
        targetDataSources.put(SourceTypeEnum.HIGH, highDataSource);
        // 维护一个 key 和 数据源的映射
        customDataSource.setTargetDataSources(targetDataSources);
        customDataSource.setDefaultTargetDataSource(lowDataSource);
        return customDataSource;
    }

    @Bean
    public DataSource lowDataSource() {
        return DataSourceBuilder.create().username(low.getUsername())
                .password(low.getPassword()).url(low.getUrl())
                .driverClassName(low.getDriverClassName()).build();
    }

    @Bean
    public DataSource highDataSource() {
        return DataSourceBuilder.create().username(high.getUsername())
                .password(high.getPassword()).url(high.getUrl())
                .driverClassName(high.getDriverClassName()).build();
    }

}
