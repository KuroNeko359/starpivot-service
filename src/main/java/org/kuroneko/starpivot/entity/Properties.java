package org.kuroneko.starpivot.entity;

import java.io.Serializable;
import java.util.List;

public class Properties implements Serializable{
    List<Property> data;

    public void addProperty(Property property) {
        data.add(property);
    }

    public List<Property> getData() {
        return data;
    }

    public void setData(List<Property> data) {
        this.data = data;
    }


}
