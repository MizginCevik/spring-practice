package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class YummyRecipeApplication {

    public static void main(String[] args) {

        ApplicationContext container = SpringApplication.run(YummyRecipeApplication.class, args);


    }

}
