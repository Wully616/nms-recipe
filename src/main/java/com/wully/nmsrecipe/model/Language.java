package com.wully.nmsrecipe.model;

public class Language {

    private String Id;
    private String Value;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }


    @Override
    public String toString() {
        return "Language{" +
                "Id='" + Id + '\'' +
                ", Value='" + Value + '\'' +
                '}';
    }
}
