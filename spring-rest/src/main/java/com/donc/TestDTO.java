package com.donc;

/**
 * Created by donovan on 15/09/16.
 */
public class TestDTO {

    private String key;
    private String value;

    public TestDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
