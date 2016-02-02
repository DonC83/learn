package com.donc.db1.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Donovan Chong on 2015-11-10.
 */
@Entity
public class Person {

    private Long id;
    private String name;
    private Timestamp createdAt = getCreationStamp();

    @Transient
    protected Timestamp getCreationStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false, name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}