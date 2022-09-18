package com.cydeo.service;

import com.cydeo.database.DataBase;
import com.cydeo.model.Ingredients;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
    }

    @Override
    public boolean prepareRecipe() {
        //initialize list of ingredients by using faker
//        recipeRepository.saveRecipe();
//        shareService.share();
        return true;
    }
}
