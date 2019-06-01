package com.wully.nmsrecipe.main;

import com.wully.nmsrecipe.loader.EXMLReader;
import com.wully.nmsrecipe.model.Recipe;
import com.wully.nmsrecipe.model.exml.Template;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public nms(String realityFile, String productFile, String substanceFile, String languageFiles) {
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
    }

    private void parseFiles(){
        reality = exmlReader.parseExml(realityFile);

        product = exmlReader.parseExml(productFile);

        substances = exmlReader.parseExml(substanceFile);


        for(String l: languageFiles){
            language.add(exmlReader.parseExml(l));

        }


    }

}
