package com.cydeo.service;

import com.cydeo.model.Recipe;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FacebookShareService implements ShareService{
    @Override
    public void share(Recipe recipe) {
        System.out.println();
    }
}
