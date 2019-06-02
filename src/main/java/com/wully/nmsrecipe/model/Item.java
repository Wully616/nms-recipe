package com.wully.nmsrecipe.model;

public class Item {
    private String Id;
    private int Amount;
    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Id='" + Id + '\'' +
                ", Amount=" + Amount +
                ", realName='" + realName + '\'' +
                '}';
    }
}
