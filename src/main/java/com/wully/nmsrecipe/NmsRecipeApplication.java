package com.wully.nmsrecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class NmsRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmsRecipeApplication.class, args);
	}

}
