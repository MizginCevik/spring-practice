package com.cydeo;

import com.cydeo.config.AuthorConfig;
import com.cydeo.service.RecipeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class YummyRecipeApplication {

    public static void main(String[] args) {

        ApplicationContext container = SpringApplication.run(YummyRecipeApplication.class, args);
        RecipeService recipeService = container.getBean(RecipeService.class);
        recipeService.prepareRecipe();

        AuthorConfig author = container.getBean(AuthorConfig.class);

        System.out.println("Here you are! Author information of the recipe");
        System.out.println("First Name:" + author.getName() + " Last Name:" + author.getLastName()
                + "\n" + "Phone Number:"  + author.getPhone() + "\n" + "Social Media Links:"
                + author.getSocialMedias() + "\n" + "Email:" + author.getEmail());


    }

}
