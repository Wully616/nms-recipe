package com.wully.nmsrecipe.loader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wully.nmsrecipe.model.exml.Template;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class EXMLReader {

    private static final Logger logger = LogManager.getLogger(EXMLReader.class);

    private XmlMapper xmlMapper;

    public EXMLReader(String exmlFile) {

        xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }


    private String getExmlFile(String exmlFile){
        StringBuilder sb = new StringBuilder();
        File file = new File("classpath:" + exmlFile);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (Exception e ){
            logger.error("Cannot load exmlFile: " + e.getMessage());
        }

        return  sb.toString();
    }

    public Template deserialzeSubstances(String xml) throws Exception{
        return xmlMapper.readValue(xml, Template.class);
    }
}
