package com.gs.qiuzhi;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceConfiguration
 * @Description: 单数据源配置
 */
@Configuration
@MapperScan(basePackages = "com.gs.qiuzhi.pojo")
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource readDataSource() {
        return new DruidDataSource();
    }
}
