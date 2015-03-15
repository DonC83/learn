package com.donc.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import javax.servlet.annotation.WebListener;

/**
 * Date: 2014/10/08
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
@WebListener
public class AppServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new AppServletModule(), new AppModule());
    }

}
