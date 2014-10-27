package com.donc.service;

import com.donc.entities.TestTable;
import com.donc.guice.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 2014/10/27
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class TestTestService {

    private final static Injector in = Guice.createInjector(new AppModule());

    private TestService service;
    private static int id;
    private String text;

    @Before
    public void setUp() throws Exception {
        service = in.getInstance(TestService.class);
        text = "testing text";
    }

    @Test
    public void testAdd() throws Exception {
        TestTable tt = new TestTable();
        tt.setText(text);
        tt = service.create(tt);
        id = tt.getId();
        assertTrue(tt.getId()>0);
    }

    @Test
    public void testGet() throws Exception {
        assertTrue(id>0);
        TestTable tt = service.get(id);
        if (tt==null) {
            tt = new TestTable();
            tt.setText(text);
            tt = service.create(tt);
        }
        assertNotNull(tt);
        assertEquals(text, tt.getText());
    }

    @Test
    public void testUpdate() throws Exception {
        assertTrue(id>0);
        TestTable tt = service.get(id);
        if (tt==null) {
            tt = new TestTable();
            tt.setText(text);
            tt = service.create(tt);
        }
        final String updatedText = "changing text";
        tt.setText(updatedText);
        service.update(tt);
        tt = service.get(tt.getId());
        assertEquals(updatedText, tt.getText());
    }

    @Test
    public void testDelete() throws Exception {
        TestTable tt = new TestTable();
        tt.setText(text);
        tt = service.create(tt);
        id = tt.getId();
        assertTrue(tt.getId()>0);
        service.delete(id);
        assertTrue(true);
    }
}
