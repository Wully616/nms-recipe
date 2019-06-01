package com.wully.nmsrecipe.model.exml;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

public class Property {

    @JacksonXmlProperty(isAttribute = true)
    private String value;

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "Property")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Property> property = new ArrayList<>();

    @Override
    public String toString() {
        return "Property{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", property=" + property +
                '}';
    }
}

