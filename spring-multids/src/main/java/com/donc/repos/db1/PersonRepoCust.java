package com.donc.repos.db1;

import com.donc.db1.entities.Person;

import java.util.Date;
import java.util.List;

/**
 * Created by Donovan Chong on 2015-11-11.
 */
public interface PersonRepoCust {

    List<Person> personCreatedBetween(Date start, Date end);
}
