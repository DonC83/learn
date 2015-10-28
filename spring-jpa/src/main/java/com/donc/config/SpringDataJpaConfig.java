package com.donc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.sf.ehcache.hibernate.EhCacheProvider;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
 * Created by donovan on 15/06/09.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.donc.repo.springdata"})
public class SpringDataJpaConfig {


    @Profile("dev")
    @Bean
    public DataSource getDevDataSource() throws PropertyVetoException {
        System.out.println("Using dev");
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

    @Profile("production")
    @Bean
    public DataSource getProdDataSource() throws PropertyVetoException {
        System.out.println("Using production");
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
        emfb.getJpaPropertyMap().put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        emfb.getJpaPropertyMap().put("hibernate.cache.use_second_level_cache", true);
        emfb.getJpaPropertyMap().put("hibernate.cache.use_query_cache", true);
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

//    @Configuration
//    @EnableTransactionManagement
//    public static class TransactionConfig {
//        @Inject
//        private EntityManagerFactory emf;
//
//        public JpaTransactionManager transactionManager() {
//            JpaTransactionManager transactionManager = new JpaTransactionManager();
//            transactionManager.setEntityManagerFactory(emf);
//            return transactionManager;
//        }
//    }

}
