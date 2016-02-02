package com.donc.repos.db1;

import com.donc.db1.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Donovan Chong on 2015-11-10.
 */
public interface PersonRepo extends JpaRepository<Person, Long>, PersonRepoCust {
}
