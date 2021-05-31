package com.example.demo.controller;

import com.example.demo.model.ImageTable;
import com.example.demo.model.Review;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "ui")
public class UIController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/get/review")
    public List<ImageTable> getAllReviews(){
        return imageRepository.findAllByReview();
    }
}
