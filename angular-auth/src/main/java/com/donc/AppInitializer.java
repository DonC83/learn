package com.donc;

import com.donc.config.AppConfig;
import com.donc.config.DataConfig;
import com.donc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by donovan on 15/10/27.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
//        System.getProperties().put("spring.profiles.active", "dev");
        return new Class<?>[] { AppConfig.class, DataConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
