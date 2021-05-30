package com.example.demo.controller;

import com.example.demo.model.Pages;
import com.example.demo.repository.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PagesController {

    @Autowired
    PagesRepository pagesRepository;

    //    ==================================================== GET Page ============================================

    //    ====== SELECT ALL ACTIVITIES =====
    @GetMapping("/select/activities")
    public List<Pages> getActivity() {
        List<Pages> activities = pagesRepository.findAll();

        return activities;

    }
    //    ====== SELECT ONE ACTIVITIES WITH TITLE =====
        @GetMapping("/select/activity/{title}")
        public Pages getOneActivityWId(@PathVariable String title) {
            Pages pages = pagesRepository.findByTitle(title);

            return pages;
        }

    //    ==================================================== Insert Page ===========================================

    @PostMapping(value="/insert/activity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pages insertActivity(@RequestBody Pages pages){

        return pagesRepository.save(pages);

    }

    //    ==================================================== Update Page ===========================================

    @PutMapping(value="/edit/activity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void editActivityWId(@RequestBody Pages pages){
        System.out.println(pages.getTitle());

        Pages objectToUpdate = pagesRepository.findByTitle(pages.getTitle());
        System.out.println(objectToUpdate);
        if (pages.getDescription() != null){
            objectToUpdate.setDescription(pages.getDescription());
        }
        objectToUpdate.setBanner(pages.getBanner());
        objectToUpdate.setImg(pages.getImg());
        objectToUpdate.setTitle(pages.getTitle());
        System.out.println(pages);

        pagesRepository.save(objectToUpdate);

    }
//    ==================================================== DELETE Page =============================================

    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/activity/{id}")
    public void deleteActivity(@PathVariable int id){
        try {
            pagesRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }
}

