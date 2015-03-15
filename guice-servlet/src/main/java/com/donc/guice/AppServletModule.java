package com.donc.guice;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.Map;
import static com.google.common.collect.Maps.newHashMap;
/**
 * Date: 2014/10/08
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
public class AppServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        Map<String, String> params = newHashMap();
        params.put("com.sun.jersey.config.property.packages",
                "com.donc.api;org.codehaus.jackson.jaxrs");

        serve("/api/*").with(GuiceContainer.class);
    }

}
