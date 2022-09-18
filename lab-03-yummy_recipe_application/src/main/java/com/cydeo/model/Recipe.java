package com.cydeo.model;

import com.cydeo.proxy.RecipeType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Recipe {
    private Long id;
    private String name;
    private Random duration;
    private String preparation;
    private List<Ingredients> ingredients;
    private RecipeType recipeType;
}
