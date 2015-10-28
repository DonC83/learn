package com.donc.repo;

import com.donc.entities.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by donovan on 15/09/16.
 */
public interface TestTableRepo extends JpaRepository<TestTable, Integer> {

    List<TestTable> findByText(String text);
}
