package com.donc.guice;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.Arrays;
import java.util.List;

/**
 * Created by donovan on 15/04/09.
 */
public class AppServletModule extends GuiceResteasyBootstrapServletContextListener {

    @Override
    protected void withInjector(Injector injector) {
        super.withInjector(injector);
        injector.getInstance(PersistService.class).start();
    }

    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Arrays.asList(new JpaPersistModule("testPU"), new AppModule());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}
