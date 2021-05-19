package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    ProfileRepository profileRepository;

    //    ==================================================== GET Activity ================================================

    //    ====== SELECT ALL ACTIVITIES =====
    @GetMapping("/select/profile/about")
    public List<Profile> getProfileAbout() {
        List<Profile> profiles = profileRepository.findAll();

        return profiles;

    }

    //    ==================================================== POST PROFILES ================================================

//    @PostMapping(value="/insert/profile/about", consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Profile insertProfileAbout(@RequestBody Profile profile){
//
//        return profileRepository.save(profile);
//
//    }

    @PostMapping(value="/edit/profile/about", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Profile editProfileAbout(@RequestBody Profile profile){

        return profileRepository.save(profile);

    }
//    ==================================================== DELETE PROFILES =============================================

//    @ResponseStatus(code=HttpStatus.NO_CONTENT)
//    @DeleteMapping("/delete/activity/{id}")
//    public void deleteActivity(@PathVariable int id){
//        try {
//            profileRepository.deleteById(id);
//        } catch (EmptyResultDataAccessException ex) {
//            System.out.println("FEJL i DELETE =" + ex.getMessage());
//        }
//    }
}
