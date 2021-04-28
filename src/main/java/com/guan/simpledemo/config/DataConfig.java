package com.guan.simpledemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 8:42
 */
@Configuration
public class DataConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource getDataSource() {
        return new DruidDataSource();
    }
}
