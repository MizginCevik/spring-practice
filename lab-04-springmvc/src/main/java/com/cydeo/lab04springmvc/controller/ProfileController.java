package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String getProfile(Model model){

        Profile profile = new Profile();
        profile.setName("Mike");
        profile.setSurname("Smith");
        profile.setUserName("msmith");
        profile.setEmail("msmith@cydeo.com");
        profile.setPhoneNumber("+1234567890");
        profile.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile", profile);

        return "profile/profile-info";
    }
}
