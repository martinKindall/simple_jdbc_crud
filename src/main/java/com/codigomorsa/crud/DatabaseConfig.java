package com.codigomorsa.crud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${datasource.customs.query-timeout}")
    private int queryTimeout;

    @Bean
    @ConfigurationProperties(prefix = "datasource.my-connection")
    public DataSource crudDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean
    public JdbcTemplate crudJdbcTemplate(DataSource crudDataSource) {
        var jdbcTemplate = new JdbcTemplate(crudDataSource);
        jdbcTemplate.setQueryTimeout(queryTimeout);
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate crudNamedParameterJdbcTemplate(JdbcTemplate crudJdbcTemplate) {
        return new NamedParameterJdbcTemplate(crudJdbcTemplate);
    }
}
