package com.cydeo.service.impl;

import com.cydeo.model.Ingredients;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
    }

    @Override
    public boolean prepareRecipe() {
        Recipe recipe=new Recipe();
        Faker faker= new Faker();
        List<Ingredients> ingredientsList= new ArrayList<>();

        int i=0;
        while(i<8){
            Ingredients ingredients= new Ingredients();

            ingredients.setName(faker.food().ingredient());
            ingredients.setQuantity(faker.number().randomDigit());
            //ingredients.setQuantityType(faker.);
            ingredientsList.add(ingredients);

            i++;
        }

        recipe.setIngredients(ingredientsList);
        recipeRepository.saveRecipe(recipe);
        shareService.share(recipe);
        //initialize list of ingredients by using faker
//        recipeRepository.saveRecipe();
//        shareService.share();
        return true;
    }
}
