package com.donc.repo;

import com.donc.entities.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by donovan on 15/09/16.
 */
public interface TestTableRepo extends JpaRepository<TestTable, Integer> {
}
