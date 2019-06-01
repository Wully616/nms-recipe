package com.wully.nmsrecipe.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class nms {

    @Value("${files.defaultreality}")
    public String realityFile;

    @Value("${files.producttable}")
    public String productFile;

    @Value("${files.substancetable}")
    public String substanceFile;

    @Value("${files.languagefiles}")
    public String languageFiles;

    public nms() {
        System.out.println("hello");
    }
}
