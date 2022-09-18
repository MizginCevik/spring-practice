package com.cydeo.database;

import com.cydeo.model.Ingredients;
import com.cydeo.model.Recipe;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    Faker faker;

    public DataBase(Faker faker) {
        this.faker = faker;
    }

    public static List<Ingredients> ingredientsList = new ArrayList<>();
    public static List<Recipe> recipeList = new ArrayList<>();
}
