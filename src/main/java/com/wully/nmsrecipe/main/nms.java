package com.wully.nmsrecipe.main;

import com.wully.nmsrecipe.loader.EXMLReader;
import com.wully.nmsrecipe.model.Item;
import com.wully.nmsrecipe.model.Language;
import com.wully.nmsrecipe.model.Product;
import com.wully.nmsrecipe.model.Recipe;
import com.wully.nmsrecipe.model.exml.Template;
import com.wully.nmsrecipe.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nms {

    private static final Logger logger = LogManager.getLogger(nms.class);


    public String realityFile;
    public String productFile;
    public String substanceFile;
    public String[] languageFiles;

    public EXMLReader exmlReader;

    public Template reality;
    public Template product;
    public Template substances;
    public List<Template> language;

    private List<Recipe> recipes;
    private List<Product> products;
    private List<Language> languages;

    public nms(String realityFile, String productFile, String substanceFile, String languageFiles) {
        recipes = new ArrayList<>();
        products = new ArrayList<>();
        languages = new ArrayList<>();

        this.realityFile = realityFile;
        this.productFile = productFile;
        this.substanceFile = substanceFile;
        this.languageFiles = languageFiles.split(",");
        this.language = new ArrayList<>();

        logger.info("DefaultReality: " + realityFile);
        logger.info("Substances: " + substanceFile);
        logger.info("Products: " + productFile);
        logger.info("Languages: " + languageFiles);

        exmlReader = new EXMLReader();

        parseFiles();
        updateNames();

    }

    private void updateNames(){

        Map<String,String> languageMap = new HashMap<>();
        for(Language l : languages){
            languageMap.put(l.getId(),l.getValue());
        }

        Map<String,Product> productMap = new HashMap<>();
        for(Product p : products){
            p.setRealName( languageMap.get( p.getName() ));
            productMap.put(p.getId(), p);
        }

        recipes.forEach(r ->{
            Product resultProduct = productMap.get(r.getResult().getId());
            r.getResult().setRealName( resultProduct.getRealName() );
//TODO: add in lookup in language files for the recipe name, based on Recipe NAME and language ID

            r.getIngredients().forEach(i -> {
                if(i != null) {
                    Product ingredientProduct = productMap.get(i.getId());
                    if(ingredientProduct == null){
                        logger.warn("Product does not have an ID for: " + i.getId());
                    } else {
                        i.setRealName(ingredientProduct.getRealName());
                    }


                }
            });


        });

        logger.info(recipes);

    }

    private void parseFiles(){
        reality = exmlReader.parseExml(realityFile);
        recipes = Parser.parseRecipes(reality, "RefinerRecipeTable", "GcRefinerRecipe.xml");

        product = exmlReader.parseExml(productFile);
        products.addAll(Parser.parseProducts(product, "Table", "GcProductData.xml"));

        substances = exmlReader.parseExml(substanceFile);
        products.addAll(Parser.parseSubstences(substances, "Table", "GcRealitySubstanceData.xml"));

        for(String l: languageFiles){
            languages.addAll(Parser.parseLanguage(exmlReader.parseExml(l), "Table", "TkLocalisationEntry.xml"));
        }

    }

}
