package com.cydeo.repository;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeRepositoryImpl implements RecipeRepository{

    public static List<Recipe> recipeList = new ArrayList<>();
    @Override
    public boolean saveRecipe(Recipe recipe) {
        return recipeList.add(recipe);
    }
}
