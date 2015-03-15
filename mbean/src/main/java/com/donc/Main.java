package com.donc;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by donovan on 15/02/23.
 */
public class Main {

    public static void main(String[] args) {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        try {
            ObjectName name = new ObjectName("com.donc:type=Hello");
            Hello mBean = new Hello();
            server.registerMBean(mBean, name);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | InstanceAlreadyExistsException | MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }
}
