package com.donc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
@Entity
@Table(name = "testtable")
public class TestTable {

    private int id;
    private String text;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "text", nullable = true)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
