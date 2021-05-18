package com.example.demo.controller;

import com.example.demo.model.ActivityPage;
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
    public List<ActivityPage> getActivity() {
        List<ActivityPage> activities = activityPageRepository.findAll();

        return activities;

    }
    //    ====== SELECT ONE ACTIVITIES WITH TITLE =====
        @GetMapping("/select/activity/{title}")
        public ActivityPage getOneActivityWTitle(@PathVariable String title) {
            ActivityPage activityPage = activityPageRepository.findByTitle(title);

            return activityPage;
        }

    //    ====== SELECT ALL ACTIVITIES WITH TITLE =====
    @GetMapping("/select/all/activities/{title}")
    public List<ActivityPage> getAllEventsWTitle(@PathVariable String title){
        System.out.println(title);
        List<ActivityPage> activities = activityPageRepository.findAllByTitle(title);

        return activities;
    }

    //    ==================================================== POST PROFILES ================================================

    @PostMapping(value="/insert/activity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityPage insertActivity(@RequestBody ActivityPage activityPage){

        return activityPageRepository.save(activityPage);

    }

    @PostMapping(value="/edit/activity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityPage editActivity(@RequestBody ActivityPage activityPage){

        return activityPageRepository.save(activityPage);

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

