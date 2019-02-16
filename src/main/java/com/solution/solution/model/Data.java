package com.solution.solution.model;

/**
 * @Author Miguel Borja
 */
public class Data {

    public Data(String value) {
        this.value = value;
    }

    public Data() {
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
