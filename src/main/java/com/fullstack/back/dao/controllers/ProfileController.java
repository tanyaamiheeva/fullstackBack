package com.fullstack.back.dao.controllers;

import com.fullstack.back.dao.entity.ProfileEntity;
import com.fullstack.back.dao.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("com.fullstack.back.dao.controllers.ProfileController")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/login")
    public Boolean login(@RequestParam("login") String login,
                         @RequestParam("password") String password) {
        return profileService.login(login, password);
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signup(@RequestBody ProfileEntity profile) {
        return profileService.create(profile.getLogin(), profile.getPassword());
    }

    @GetMapping("/profile")
    public String getEmailAndGroup(@RequestParam("id") Long id) {
        return profileService.getEmail(id) + " " + profileService.getGroup(id);
    }

    @PostMapping("/profile")
    @ResponseBody
    public String changeInfo(@RequestBody ProfileEntity newProfile) {
        return profileService.update(newProfile);
    }
}
