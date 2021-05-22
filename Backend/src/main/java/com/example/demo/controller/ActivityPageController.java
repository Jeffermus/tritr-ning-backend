package com.example.demo.controller;

import com.example.demo.model.Pages;
import com.example.demo.repository.ActivityPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityPageController {

    @Autowired
    ActivityPageRepository activityPageRepository;

    //    ==================================================== GET Activity ================================================

    //    ====== SELECT ALL ACTIVITIES =====
    @GetMapping("/select/activities")
    public List<Pages> getActivity() {
        List<Pages> activities = activityPageRepository.findAll();

        return activities;

    }
    //    ====== SELECT ONE ACTIVITIES WITH TITLE =====
        @GetMapping("/select/activity/{title}")
        public Pages getOneActivityWTitle(@PathVariable String title) {
            Pages pages = activityPageRepository.findByTitle(title);

            return pages;
        }

    //    ====== SELECT ALL ACTIVITIES WITH TITLE =====
    @GetMapping("/select/all/activities/{title}")
    public List<Pages> getAllEventsWTitle(@PathVariable String title){
        System.out.println(title);
        List<Pages> activities = activityPageRepository.findAllByTitle(title);

        return activities;
    }

    //    ==================================================== POST PROFILES ================================================

    @PostMapping(value="/insert/activity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pages insertActivity(@RequestBody Pages pages){

        return activityPageRepository.save(pages);

    }

    @PostMapping(value="/edit/activity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pages editActivity(@RequestBody Pages pages){

        return activityPageRepository.save(pages);

    }
//    ==================================================== DELETE PROFILES =============================================

    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/activity/{id}")
    public void deleteActivity(@PathVariable int id){
        try {
            activityPageRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }
}

