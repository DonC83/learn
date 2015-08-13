package com.donc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by donovan on 15/06/09.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.donc.repo.jpa"})
public class SpringDataJpaConfig {

}
