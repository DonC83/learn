package com.donc;

import com.donc.config.RemoteConfig;
import com.donc.config.SpringDataJpaConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by donovan on 15/06/02.
 */
//public class AppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        System.out.println("Hello world");
//    }
//}

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.getProperties().put("spring.profiles.active", "dev");
        return new Class<?>[] { SpringDataJpaConfig.class, RemoteConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}