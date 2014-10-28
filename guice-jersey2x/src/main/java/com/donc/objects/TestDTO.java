package com.donc.objects;

/**
 * Date: 2014/10/07
 * <p/>
 *
 * @author <a href="mailto:donovan@guruhut.com">Donovan</a>
 */
public class TestDTO {

    private int id;
    private String text;

    public TestDTO() {
    }

    public TestDTO(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
