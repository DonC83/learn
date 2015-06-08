package donc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by donovan on 15/06/05.
 */
@Configuration
public class HibernateConfig {


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


    @Bean
    public AnnotationSessionFactoryBean getSessionFactory(DataSource dataSource) {
        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
        asfb.setPackagesToScan("com.donc.entities");
        asfb.setDataSource(dataSource);
        Properties props = new Properties();
        props.put("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        asfb.setHibernateProperties(props);
        return asfb;
    }

}
