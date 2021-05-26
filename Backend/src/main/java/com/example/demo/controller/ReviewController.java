package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080/")
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;


    //    ==================================================== GET REVIEW ================================================


    //    ====== SELECT ALL REVIEW =====
    @GetMapping("/select/all/reviews")
    public List<Review> getReview(){
        List<Review> reviews = reviewRepository.findAll();

        return reviews;
    }

    //    ====== SELECT ONE REVIEW =====
    @GetMapping("/select/review/{id}")
    public Review getOneReviewWId(@PathVariable int id){
        Review review = reviewRepository.findById(id);

        return review;
    }


    //    ==================================================== POST REVIEW =============================================

//    =======  INSERT REVIEW =====

    @PostMapping(value = "/insert/review", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Review insertReview(@RequestBody Review review) {
        System.out.println(review);

        return reviewRepository.save(review);
    }

    //    =======  UPDATE REVIEW =====

    @PutMapping(value="/edit/review", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody Review review){
        System.out.println("REVIEW==="+review);
        Review oneReview = reviewRepository.findById(review.getId());
        oneReview.setAuthor(review.getAuthor());
        oneReview.setDescription(review.getDescription());
        oneReview.setReviewImage(review.getReviewImage());
        System.out.println("ONE REVIEW ==="+oneReview);

        reviewRepository.save(oneReview);
    }

    //    ==================================================== DELETE BLOG =============================================

    @ResponseStatus(code=HttpStatus.OK)
    @PostMapping("/delete/review/{id}")
    public void deleteReview(@PathVariable int id){
        System.out.println("ID================"+id);
        try {
            reviewRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }
}

