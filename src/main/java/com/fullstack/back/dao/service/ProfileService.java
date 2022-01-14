package com.fullstack.back.dao.service;

import com.fullstack.back.dao.entity.ProfileEntity;
import com.fullstack.back.dao.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public String create(String login, String password) {
        ProfileEntity profile = ProfileEntity.builder()
                .login(login)
                .password(password)
                .email(null)
                .groupname(null)
                .build();

        // checking if such login is already taken
        ProfileEntity exists = profileRepository.findByLogin(login);
        if (exists != null) {
            return "BUSY_LOGIN";
        }

        profileRepository.save(profile);
        return profile.getId().toString();
    }

    public Boolean login(String login, String password) {
        ProfileEntity neededUser = profileRepository.findByLogin(login);
        return neededUser != null && neededUser.getPassword().equals(password);
    }

    public String getEmail(Long id) {
        ProfileEntity neededUser = profileRepository.getById(id);
        return neededUser.getEmail();
    }

    public String update(ProfileEntity newProfile) {
        try {
            ProfileEntity oldProfile = profileRepository.getById(newProfile.getId());
            profileRepository.delete(oldProfile);
            profileRepository.save(newProfile);
        } catch (Exception e) {
            return "ERROR";
        }

        return "OK";
    }

    public String getGroup(Long id) {
        ProfileEntity neededUser = profileRepository.getById(id);
        return neededUser.getGroupname();
    }
}

