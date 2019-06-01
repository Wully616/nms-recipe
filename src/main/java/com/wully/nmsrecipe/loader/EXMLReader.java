package com.wully.nmsrecipe.loader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wully.nmsrecipe.model.exml.Template;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class EXMLReader {

    private static final Logger logger = LogManager.getLogger(EXMLReader.class);

    private XmlMapper xmlMapper;

    public EXMLReader() {

        xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public Template parseExml(String exmlFile){
        return deserialzeExml(getExmlFile(exmlFile));
    }
    public String getExmlFile(String exmlFile){
        StringBuilder sb = new StringBuilder();
        Resource resource = new ClassPathResource(exmlFile);
        try {

            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (Exception e ){
            logger.error("Cannot load exmlFile: " + e.getMessage());
        }

        return  sb.toString();
    }

    public Template deserialzeExml(String xml){
        Template template = new Template();
        try{
            template = xmlMapper.readValue(xml, Template.class);
        } catch (Exception e) {
            logger.error("Failed to map exml to template: " + e.getMessage());
        }
        return template;
    }
}
