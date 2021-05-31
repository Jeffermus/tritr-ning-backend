package com.example.demo.repository;

import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Review findById(int id);
    Review deleteById(int id);
    List<Review> findAll();
    Review findByAuthor(String author);

}
