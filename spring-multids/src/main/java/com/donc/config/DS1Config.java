package com.donc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by Donovan Chong on 2015-11-10.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.donc.repos.db1"},
        entityManagerFactoryRef = "db1EntityManagerFactory",
        transactionManagerRef = "db1TransactionManager"
)
@EnableTransactionManagement
public class DS1Config {

    @Bean
    public DataSource db1DataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("org.postgresql.Driver");
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/testdb1");
        ds.setUser("donovan");
        ds.setPassword("helmet9853");
        ds.setMinPoolSize(5);
        ds.setMaxPoolSize(10);
        ds.setMaxIdleTime(1000);
        return ds;
    }

    @Bean
    public JpaVendorAdapter db1JpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        return adapter;
    }

    @Bean
    public AbstractEntityManagerFactoryBean db1EntityManagerFactory(@Qualifier("db1DataSource") DataSource dataSource,
                                                                    @Qualifier("db1JpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("com.donc.db1.entities");
        return emfb;
    }

    @Bean
    public JpaTransactionManager db1TransactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
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


}
