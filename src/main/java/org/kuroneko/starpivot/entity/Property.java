package org.kuroneko.starpivot.entity;

import java.io.Serializable;

public class Property implements Serializable{
    String key;
    String value;
    boolean isFinal;
    String resource;

    public Property(String key, String value, boolean isFinal, String resource) {
        this.key = key;
        this.value = value;
        this.isFinal = isFinal;
        this.resource = resource;
    }
}
