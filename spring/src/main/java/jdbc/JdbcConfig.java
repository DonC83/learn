package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by donovan on 15/06/03.
 */
@Configuration
@ComponentScan("jdbc")
public class JdbcConfig {

    //    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("org.hsqldb.jdbcDriver");
//        ds.setUsername("SA");
//        ds.setPassword("");
//        ds.setUrl("jdbc:hsqldb:mem:testdb");
//        return ds;
//    }

    @Profile("embedded")
    @Bean
    public DataSource getPoolDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("org.hsqldb.jdbcDriver");
        ds.setJdbcUrl("jdbc:hsqldb:mem:testdb");
        ds.setUser("SA");
        ds.setPassword("");
        return ds;
    }

    @Profile("external")
    @Bean
    public DataSource getPGDataSource() throws PropertyVetoException {
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
    public JdbcTemplate getJdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
