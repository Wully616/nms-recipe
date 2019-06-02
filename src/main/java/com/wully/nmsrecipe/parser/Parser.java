package com.wully.nmsrecipe.parser;


import com.wully.nmsrecipe.model.Item;
import com.wully.nmsrecipe.model.Language;
import com.wully.nmsrecipe.model.Product;
import com.wully.nmsrecipe.model.Recipe;
import com.wully.nmsrecipe.model.exml.Property;
import com.wully.nmsrecipe.model.exml.Template;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final Logger logger = LogManager.getLogger(Parser.class);

    public static List<Language> parseLanguage(Template template, String tableName, String itemName){

        List<Language> outputList = new ArrayList<>();

        template.getTables()
                .stream()
                .filter(table -> table.getName().equals(tableName))
                .collect(Collectors.toList())
                .forEach(
                        table -> {
                            table.getProperties()
                                    .stream()
                                    .filter(property -> property.getValue().equals(itemName))
                                    .collect(Collectors.toList())
                                    .forEach(
                                            language ->{
                                                //iterate properties and get values
                                                outputList.add(getLanguageFromProperties(language));


                                            });
                        });


        return outputList;
    }
    public static List<Product> parseSubstences(Template template, String tableName, String itemName){

        List<Product> outputList = new ArrayList<>();

        template.getTables()
                .stream()
                .filter(table -> table.getName().equals(tableName))
                .collect(Collectors.toList())
                .forEach(
                        table -> {
                            table.getProperties()
                                    .stream()
                                    .filter(property -> property.getValue().equals(itemName))
                                    .collect(Collectors.toList())
                                    .forEach(
                                            product ->{
                                                //iterate properties and get values
                                                outputList.add(getSubstanceFromProperties(product));


                                            });
                        });


        return outputList;
    }

    public static List<Product> parseProducts(Template template, String tableName, String itemName){

        List<Product> outputList = new ArrayList<>();

        template.getTables()
                .stream()
                .filter(table -> table.getName().equals(tableName))
                .collect(Collectors.toList())
                .forEach(
                        table -> {
                            table.getProperties()
                                    .stream()
                                    .filter(property -> property.getValue().equals(itemName))
                                    .collect(Collectors.toList())
                                    .forEach(
                                            product ->{
                                                //iterate properties and get values
                                                outputList.add(getProductFromProperties(product));


                                            });
                        });

        return outputList;
    }

    public static List<Recipe> parseRecipes(Template template, String tableName, String itemName){

        List<Recipe> outputList = new ArrayList<>();

        template.getTables()
                .stream()
                .filter(table -> table.getName().startsWith(tableName))
                .collect(Collectors.toList())
                .forEach(
                        table -> {
                            table.getProperties()
                                    .stream()
                                    .filter(property -> property.getValue().equals(itemName))
                                    .collect(Collectors.toList())
                                    .forEach(
                                            recipe ->{
                                                //iterate properties and get values

                                                outputList.add(getRecipeFromProperties(recipe));
                                    });
                });

        return outputList;
    }

    private static Language getLanguageFromProperties(Property property){
        Language thisLanguage = new Language();

        property.getProperty().forEach(item ->{
            switch (item.getName()){
                case "Id":
                    thisLanguage.setId(item.getValue());
                    break;
                case "English":
                    thisLanguage.setValue(item.getProperty().get(0).getValue());
                    break;
            }
        });
        return thisLanguage;
    }

    private static Product getSubstanceFromProperties(Property property){
        Product thisProduct = new Product();

        property.getProperty().forEach(item ->{
            switch (item.getName()){
                case "ID":
                    thisProduct.setId(item.getValue());
                    break;
                case "Name":
                    thisProduct.setName(item.getValue());
                    break;
            }
        });
        return thisProduct;
    }
    private static Product getProductFromProperties(Property property){
        Product thisProduct = new Product();

        property.getProperty().forEach(item ->{
            switch (item.getName()){
                case "Id":
                    thisProduct.setId(item.getValue());
                    break;
                case "Name":
                    thisProduct.setName(item.getValue());
                    break;
            }
        });
         return thisProduct;
    }
    private static Recipe getRecipeFromProperties(Property property){
        Recipe thisRecipe = new Recipe();

        property.getProperty().forEach(item -> {
            switch (item.getName()) {
                case "Name":
                    thisRecipe.setName(item.getValue());
                    break;
                case "TimeToMake":
                    thisRecipe.setTimeToMake(Integer.parseInt(item.getValue()));
                    break;
                case "Result":
                    thisRecipe.setResult(parseItem(item));
                    break;
                case "Ingredients":
                    thisRecipe.setIngredients(parseIngredients(item));
                    break;
            }
        });
        return thisRecipe;
    }

    private static Item parseItem(Property item){
        Item thisItem = new Item();

        item.getProperty().forEach(property -> {
            switch (property.getName()){
                case "Id":
                    thisItem.setId(property.getValue());
                    break;
                case "Amount":
                    thisItem.setAmount(Integer.parseInt(property.getValue()));
                    break;
            }
        });
        return thisItem;
    }

    private static List<Item> parseIngredients(Property items){
        List<Item> ingredients = new ArrayList<>();

        items.getProperty().forEach(property -> {

            ingredients.add( parseItem(property) );

        });

        return ingredients;
    }

}
