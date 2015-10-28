package com.donc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by donovan on 15/06/08.
 */
@Configuration
@ComponentScan("com.donc.repo.springjpa")
public class SpringJpaConfig {

//    @Bean
//    public LocalEntityManagerFactoryBean getLocalEntityManagerFactoryBean() {
//        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//        emfb.setPersistenceUnitName("testPU");
//        return emfb;
//    }

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("org.postgresql.Driver");
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/test?user=donovan");
        ds.setMinPoolSize(5);
        ds.setMaxPoolSize(10);
        ds.setMaxIdleTime(1000);
//        ds.setUser("");
//        ds.setPassword("");
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


    @Configuration
    @EnableTransactionManagement
    public static class TransactionConfig implements TransactionManagementConfigurer {
        @Inject
        private EntityManagerFactory emf;

        public PlatformTransactionManager annotationDrivenTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        }
    }


//    /**
//     * This bean is used to look up a EntityManagerFactory that may already be configured with JNDI if the application
//     * is deployed in a container
//     *
//     * @return
//     */
//    @Bean
//    public JndiObjectFactoryBean entityManagerFactory() {
//        JndiObjectFactoryBean jndiFB = new JndiObjectFactoryBean();
//        jndiFB.setJndiName("jdbc/TestDS");
//        return jndiFB;
//    }

}
