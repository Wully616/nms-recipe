package com.wully.nmsrecipe.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String name;
    private int timeToMake;
    private List<Item> ingredients;
    private Item result;

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeToMake() {
        return timeToMake;
    }

    public void setTimeToMake(int timeToMake) {
        this.timeToMake = timeToMake;
    }

    public List<Item> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Item> ingredients) {
        this.ingredients = ingredients;
    }

    public Item getResult() {
        return result;
    }

    public void setResult(Item result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", timeToMake=" + timeToMake +
                ", ingredients=" + ingredients +
                ", result=" + result +
                '}';
    }
}
