package com.wully.nmsrecipe.model.exml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "Template")
public class Template {


    @JacksonXmlProperty(isAttribute = true)
    private String template;

    @JacksonXmlProperty(localName = "Property")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Table> tables = new ArrayList<>();

    public String getTemplate() {
        return template;
    }

    public List<Table> getTables() {
        return tables;
    }

    @Override
    public String toString() {
        return "Template{" +
                "template='" + template + '\'' +
                ", tables=" + tables +
                '}';
    }
}
