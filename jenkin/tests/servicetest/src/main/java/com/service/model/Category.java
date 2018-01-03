package com.service.model;

/**
 * Created by Admin on 11/2/2017.
 */
public class Category {

    /**
     * Category types
     *
     * @author Rajesh
     */
    public static enum TYPE {
        SERVICE, RESOURCE;
    }

    private String name;
    private TYPE type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public Category(String name, TYPE type) {
        this.name = name;
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("{\"name\": \"%s\", \"type\":\"%s\"}", name, type);
    }
}
