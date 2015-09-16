package com.donc.controllers;

import com.donc.TestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donovan on 15/09/16.
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<TestDTO> getAFNotes() {
        List<TestDTO> list = new ArrayList<>();
        TestDTO dto = new TestDTO("key1", "value1");
        list.add(dto);
        TestDTO dto2 = new TestDTO("key2", "value2");
        list.add(dto2);
        return list;
    }

}
