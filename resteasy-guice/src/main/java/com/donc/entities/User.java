package com.donc.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by donovan on 15/04/14.
 */
@Entity
@Table(name="user_")
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
public class User implements Serializable {

    private int id;
    private String username;
    private String password;
    private boolean active;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
