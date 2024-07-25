package com.example.demo.oracle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "oracleFactoryBean",
        transactionManagerRef = "oracleManager",
        basePackages = "com.example.demo.OracleRepo"
)
public class DataSourceConfigOracle {

    @Autowired
    private Environment environment;

    //Datasource

    @ConfigurationProperties(prefix = "spring.oracle.datasource")
    @Bean
    public DataSourceProperties oracleDataSourceProperties()
    {
       return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource oracleDataSource()
    {
        DriverManagerDataSource managerDataSource=new DriverManagerDataSource();
        managerDataSource.setUrl(oracleDataSourceProperties().getUrl());
        managerDataSource.setUsername(oracleDataSourceProperties().getUsername());
        managerDataSource.setPassword(oracleDataSourceProperties().getPassword());
        managerDataSource.setDriverClassName(oracleDataSourceProperties().getDriverClassName());
        return managerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean oracleFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("oracleDataSource") DataSource dataSource)
    {
        return builder.dataSource(dataSource)
                .packages("com.example.demo.EntityPackageOracle")
                .build();
    }

    @Bean
    public PlatformTransactionManager oracleManager(@Qualifier("oracleFactoryBean") LocalContainerEntityManagerFactoryBean factoryBean)
    {
       return new JpaTransactionManager(Objects.requireNonNull(factoryBean.getObject()));
    }

}
