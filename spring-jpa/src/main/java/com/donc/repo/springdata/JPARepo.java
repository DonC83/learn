package com.donc.repo.springdata;

import com.donc.entities.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by donovan on 15/06/09.
 */
public interface JPARepo extends JpaRepository<TestTable, Integer> {

    TestTable findByText(String text);

}
