package com.donc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by donovan on 15/09/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.donc.controllers")
public class AppConfig extends WebMvcConfigurerAdapter {


}
