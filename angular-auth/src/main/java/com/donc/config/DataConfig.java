package com.donc.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.hibernate4.encryptor.HibernatePBEStringEncryptor;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by donovan on 15/09/16.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.donc.repo"})
public class DataConfig {

    @Bean
    public DataSource getDevDataSource() throws SQLException {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName("angulartest");
        ds.setUser("donovan");
        ds.setServerName("localhost");
        ds.setUrl("jdbc:postgresql://localhost:5432/angulartest?user=donovan");
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return adapter;
    }

    @Bean
    public StandardPBEStringEncryptor standardPBEStringEncryptor() {
        StandardPBEStringEncryptor pbeStringEncryptor = new StandardPBEStringEncryptor();
        pbeStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        pbeStringEncryptor.setPassword("J%4h78hd");
        return pbeStringEncryptor;
    }

    @Bean
    public HibernatePBEStringEncryptor hibernatePBEStringEncryptor(StandardPBEStringEncryptor standardPBEStringEncryptor) {
        HibernatePBEStringEncryptor encryptor = new HibernatePBEStringEncryptor();
        encryptor.setRegisteredName("hibernateStringEncryptor");
        encryptor.setEncryptor(standardPBEStringEncryptor);
        return encryptor;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("com.donc.entities");
        return emfb;
    }

    /**
     * This bean is used for Spring how to understand JPA's @PersistenceUnit and @PersistenceContext annotations and
     * know to inject an EntityManagerFactory and EntityManager respectively.  This is required to be configured
     * for jpa persistence.
     *
     * @return PersistenceAnnotationBeanPostProcessor
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    /**
     * This allows Spring to translate persistence related exceptions in s "spring-friendly" way.
     *
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
