package com.api.drinktakeaway_core_back.persistenceConf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "DTAEntityManagerFactory", transactionManagerRef = "DTATransactionManager", basePackages = {
        "com.api.drinktakeaway_core_back.repository.DTA" })
public class PersistenceDTAAutoConfiguration {

    @Primary
    @Bean(name = "DTADataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource drink_take_awayDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "DTAEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
            @Qualifier("DTADataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.api.drinktakeaway_core_back.entity.DTA")
                .persistenceUnit("drink_take_away").build();
    }

    @Primary
    @Bean(name = "DTATransactionManager")
    public PlatformTransactionManager productTransactionManager(
            @Qualifier("DTAEntityManagerFactory") EntityManagerFactory DTAEntityManagerFactory) {
        return new JpaTransactionManager(DTAEntityManagerFactory);
    }
}
