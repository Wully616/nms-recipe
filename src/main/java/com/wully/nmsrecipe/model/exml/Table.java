package com.wully.nmsrecipe.model.exml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Table {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "Property")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Property> properties = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}
