package com.example.java21Microservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "commandManagerFactory",
        basePackages = {
                "com.example.java21Microservice.Repositories.Command"
        }, transactionManagerRef = "commandTransactionManager")
public class CommandConfig {
    @Bean(name = "commandDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource commandDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:sqlserver://localhost;databaseName=AdventureWorks2022;encrypt=false;")
                .username("sa")
                .password("sqlserver")
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .build();
    }

    @Bean(name = "commandManagerFactory")
    public LocalContainerEntityManagerFactoryBean commandManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(commandDataSource());
        em.setPackagesToScan(
                new String[] { "com.example.java21Microservice.Repositories.Query",
                        "com.example.java21Microservice.DbEntities" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean(name = "commandTransactionManager")
    public PlatformTransactionManager commandTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                commandManagerFactory().getObject());
        return transactionManager;
    }
}
