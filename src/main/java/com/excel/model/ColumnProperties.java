package com.excel.model;

public class ColumnProperties {
    private Integer index;
    private String name;
    private String type;

    public ColumnProperties() {
    }

    public ColumnProperties(Integer index, String name, String type) {
        this.index = index;
        this.name = name;
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
