package com.donc.services;

import com.donc.guice.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerProperties;
import org.junit.After;
import org.junit.Before;

/**
 * Date: 2014/10/22
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public abstract class TestModule {

    protected static final Injector in = Guice.createInjector(new AppModule());

    protected Server server = new Server();

    static {
        in.getInstance(TestInitialiser.class);
    }

    public TestModule() {
//        server.setDatabaseName(0, "rest_learn");
//        server.setDatabasePath(0, "./testdb/");
//        server.setLogWriter(null);
//        server.setErrWriter(null);
//        server.start();

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

}
