package com.example.java21Microservice;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "queryManagerFactory",
        basePackages = {
            "com.example.java21Microservice.Repositories.Query"
        }, transactionManagerRef = "queryTransactionManager")
public class QueryConfig {
    @Bean(name = "queryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource queryDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:sqlserver://localhost;databaseName=AdventureWorks2022;encrypt=false;")
                .username("sa")
                .password("sqlserver")
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .build();
    }

    @Bean(name = "queryManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean queryManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(queryDataSource());
        em.setPackagesToScan(
                new String[] { "com.example.java21Microservice.Repositories.Query",
                        "com.example.java21Microservice.DbEntities" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Primary
    @Bean(name = "queryTransactionManager")
    public PlatformTransactionManager queryTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                queryManagerFactory().getObject());
        return transactionManager;
    }
}
