package com.cydeo.service;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class InstagramShareService implements ShareService{
    @Override
    public void share(Recipe recipe) {
        System.out.println();
    }
}
