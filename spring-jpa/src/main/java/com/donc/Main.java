package com.donc;

import com.donc.config.SpringDataJpaConfig;
import com.donc.entities.TestTable;
import com.donc.repo.springdata.JpaRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by donovan on 15/08/05.
 */
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("spring.profiles.active", "dev");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDataJpaConfig.class);
        JpaRepo repo = context.getBean(JpaRepo.class);
        TestTable tt = new TestTable();
        tt.setText("dsfsdfs");
        tt.setId(10);
        repo.save(tt);
    }
}
