package com.donc.guice;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

/**
 * Date: 2014/10/28
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
@ApplicationPath("webapi")
public class AppConfig extends ResourceConfig {

    @Inject
    public AppConfig(ServiceLocator serviceLocator) {
        // Indicates what resources you are serving.  This was done in the Guice servlet module in 1.x and was mapped
        // with the code snippet below:
        // Map<String, String> params = newHashMap();
        // params.put("com.sun.jersey.config.property.packages","com.donc.api");
        // serve("/webapi/*").with(GuiceContainer.class, params);

        packages("com.donc.api");

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(AppServletConfig.getGuiceInjector());
    }

}
