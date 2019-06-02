package com.wully.nmsrecipe.model;

public class Product {

    private String Id;
    private String Name;
    private String RealName;

    public Product() {
    }

    public String getRealName() {
        if(RealName == null){
            return Name;
        }
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", RealName='" + RealName + '\'' +
                '}';
    }
}
