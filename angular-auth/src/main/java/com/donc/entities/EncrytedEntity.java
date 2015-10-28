package com.donc.entities;

import org.hibernate.annotations.*;
import org.jasypt.hibernate4.type.EncryptedStringType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by donovan on 15/10/27.
 */
@Entity
@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class, parameters = {
        @org.hibernate.annotations.Parameter(name = "encryptorRegisteredName", value = "hibernateStringEncryptor")
})
public class EncrytedEntity {

    private Long id;
    private String text1;
    private String text2;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Type(type = "encryptedString")
    @Column(nullable = false)
    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    @Type(type = "encryptedString")
    @Column(nullable = false, length = 50)
    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
