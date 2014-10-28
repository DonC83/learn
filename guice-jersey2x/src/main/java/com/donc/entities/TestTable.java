package com.donc.entities;

import javax.persistence.*;

/**
 * Date: 2014/10/09
 * <p/>
 *
 * @author <a href="mailto:donovan.chong@gmail.com">Donovan</a>
 */
@Entity
@Table(name = "testtable")
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "testtable_seq", allocationSize = 1, initialValue = 1)
public class TestTable {

    private int id;
    private String text;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
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
