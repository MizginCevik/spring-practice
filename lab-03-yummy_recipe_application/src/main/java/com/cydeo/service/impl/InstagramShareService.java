package com.cydeo.service.impl;

import com.cydeo.model.Recipe;
import com.cydeo.service.ShareService;
import org.springframework.stereotype.Component;

@Component
public class InstagramShareService implements ShareService {
    @Override
    public void share(Recipe recipe) {
        System.out.println();
    }
}
