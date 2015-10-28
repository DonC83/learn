package com.donc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by donovan on 15/10/28.
 */
@Configuration
@ComponentScan(basePackages = { "com.donc.controllers" })
@EnableWebMvc //this is required for the http calls to work
public class WebConfig extends WebMvcConfigurerAdapter {

    //This and extending the WebMvcConfigurerAdapter is required to allow pages to load
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
