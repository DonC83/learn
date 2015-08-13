package com.donc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by donovan on 15/06/05.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.donc.repositories")
public class HibernateConfig implements TransactionManagementConfigurer {

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("org.postgresql.Driver");
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/test?user=donovan");
        ds.setMinPoolSize(5);
        ds.setMaxPoolSize(10);
        ds.setMaxIdleTime(1000);
        ds.setUser("");
        ds.setPassword("");
        return ds;
    }


    /**
     * Notice that with Hibernate 4 you need to use the LocalSessionFactoryBean class
     * and not the AnnotationSessionFactoryBean you use with Hibernate3
     * @param dataSource
     * @return
     */
    @Bean
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setPackagesToScan("com.donc.entities");
        sfb.setDataSource(dataSource);
        Properties props = new Properties();
        props.put("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "create");
        sfb.setHibernateProperties(props);
        return sfb;
    }


    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;

    }


}
