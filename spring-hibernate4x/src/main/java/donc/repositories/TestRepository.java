package donc.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by donovan on 15/06/05.
 */
@Repository
public class TestRepository {

    @Autowired
    private AnnotationSessionFactoryBean session;



}
