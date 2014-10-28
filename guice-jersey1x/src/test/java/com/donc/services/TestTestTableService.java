package com.donc.services;

import com.donc.entities.TestTable;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Date: 2014/10/21
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
public class TestTestTableService extends TestModule {


    private TestService service;
    private static List<Integer> ids = new ArrayList<Integer>();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        service = in.getInstance(TestService.class);
    }

    @Test
    public void testAdd() throws Exception {
        service.add("Test text");
        service.add("Test text2");
        assertTrue(true);
    }

    @Test
    public void testAll() throws Exception {
        List<TestTable> list = service.getAll();
        assertNotNull(list);
        assertTrue(list.size()>0);
        for (TestTable tt : list) {
            ids.add(tt.getId());
        }
    }

    @Test
    public void testDelete() throws Exception {
        assertTrue("No ids to delete", ids.size()>0);
        for (int i : ids) {
            service.deleteText(i);
        }
    }

    @Test
    public void testDeleteText() throws Exception {
        service.deleteText("Test text2");
        assertTrue(true);

    }
}
