package com.example.demo.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "postFactoryBean",
        transactionManagerRef = "postManager",
        basePackages = "com.example.demo.PostRepo"
)
public class DataSourceConfigPostgreSql {


    @ConfigurationProperties(prefix = "spring.postgres.datasource")
    @Bean
    public DataSourceProperties dataSourceProperties()
    {
       return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresDataSource()
    {
        DriverManagerDataSource managerDataSource=new DriverManagerDataSource();
        managerDataSource.setDriverClassName(dataSourceProperties().getDriverClassName());
        managerDataSource.setUsername(dataSourceProperties().getUsername());
        managerDataSource.setPassword(dataSourceProperties().getPassword());
        managerDataSource.setUrl(dataSourceProperties().getUrl());
        return managerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean postFactoryBean(EntityManagerFactoryBuilder builder,@Qualifier("postgresDataSource") DataSource dataSource)
    {
       return builder.dataSource(dataSource)
               .packages("com.example.demo.EntityPackagePost")
               .build();
    }

    @Bean
    public PlatformTransactionManager postManager(@Qualifier("postFactoryBean") LocalContainerEntityManagerFactoryBean factoryBean)
    {
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
