package com.donc.dto;

import java.io.Serializable;

/**
 * Created by donovan on 15/08/12.
 */
public class TestDTO implements Serializable {

    private Integer id;
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
