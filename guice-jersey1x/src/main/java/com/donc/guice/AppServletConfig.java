package com.donc.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import javax.servlet.annotation.WebListener;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
@WebListener
public class AppServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new AppServletModule(), new AppModule());
    }
}
