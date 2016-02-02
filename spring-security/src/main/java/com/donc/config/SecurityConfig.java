package com.donc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by donovan on 2015/12/21.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("user").roles("USER").and()
//                .withUser("admin").password("admin").roles("USER","ADMIN");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select username, password, true from _user where username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER from _user where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Bean
//    public StandardPBEStringEncryptor standardPBEStringEncryptor() {
//        StandardPBEStringEncryptor pbeStringEncryptor = new StandardPBEStringEncryptor();
//        pbeStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
//        pbeStringEncryptor.setPassword("J%4h78hd");
//        return pbeStringEncryptor;
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll();
    }

}
