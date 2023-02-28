package com.codigomorsa.crud.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "datasource.my-connection")
    public DataSource crudDataSource() {
        return DataSourceBuilder.create().build();
    }
}
