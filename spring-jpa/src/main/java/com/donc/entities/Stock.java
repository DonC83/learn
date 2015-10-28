package com.donc.entities;

import javax.persistence.*;

/**
 * Created by donovan on 15/10/20.
 */
@Entity
@Table(name = "stock", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code"),
        @UniqueConstraint(columnNames = "name")
})
public class Stock {


    private long id;
    private String code;
    private String name;

    @Id
    @Column(unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(unique = true, nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
