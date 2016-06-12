package com.daykm.database;


import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("SQLServerDriver")
                .username("master")
                .url("localhost/SQLEXPRESS")
                .build();
    }
}
