package com.donc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by donovan on 15/05/21.
 */
@Component
public class MessagePrinter {

    private final MessageService service;

    @Autowired
    public MessagePrinter(MessageService service) {
        this.service =  service;
    }

    public void printMessage() {
        System.out.println(service.getMessage());
    }

}
