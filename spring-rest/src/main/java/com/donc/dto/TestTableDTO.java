package com.donc.dto;

/**
 * Created by donovan on 15/09/16.
 */
public class TestTableDTO {

    private Integer id;
    private String text;

    public TestTableDTO() {
    }

    public TestTableDTO(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

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
