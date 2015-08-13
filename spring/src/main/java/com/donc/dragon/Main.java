package com.donc.dragon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by donovan on 15/05/22.
 */
public class Main {

    public static void main(String[] args) {
        //This class is used to load class annotated with @Configuration which loads the beans as opposed to
        //ClassPathXmlApplicationContext which loads beans from xml file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        DragonKnight dk = context.getBean(DragonKnight.class);
        dk.startQuest();
        context.close();
    }
}
