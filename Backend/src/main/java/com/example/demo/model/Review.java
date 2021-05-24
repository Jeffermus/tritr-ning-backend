package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private String author;
    private String reviewImage;
    private String description;

    public Review(){

    }

    public Review(String author, String reviewImage, String description) {
        this.author = author;
        this.reviewImage = reviewImage;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviewImage() {
        return reviewImage;
    }

    public void setReviewImage(String reviewImage) {
        this.reviewImage = reviewImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String editorCopy) {
        this.description = editorCopy;
    }
}
