package com.donc.entities;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by donovan on 15/06/04.
 */
@Entity
@Table(name = "testtable")
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "testtable_seq", allocationSize = 1, initialValue = 1)
public class TestTable {

    private int id;
    private String text;

    public TestTable() {
    }

    public TestTable(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
//    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public static final class TestTableRowMapper implements RowMapper<TestTable> {

        @Override
        public TestTable mapRow(ResultSet rs, int i) throws SQLException {
            TestTable tt = new TestTable();
            tt.setId(rs.getInt("id"));
            tt.setText(rs.getString("text"));
            return tt;
        }
    }
}
