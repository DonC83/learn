package com.donc.db2.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Donovan Chong on 2015-11-10.
 */
@Entity
public class Address {

    private Long id;
    private String streeName;
    private Long personId;
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

    @Column(nullable = false, length = 200)
    public String getStreeName() {
        return streeName;
    }

    public void setStreeName(String streeName) {
        this.streeName = streeName;
    }

    @Column(nullable = false)
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Column(nullable = false, name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
