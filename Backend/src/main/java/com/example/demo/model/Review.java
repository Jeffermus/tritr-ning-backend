package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    public int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String author;
    private String reviewImage;
    private String editorCopy;

    public Review(){

    }

    public Review(String author, String reviewImage, String editorCopy) {
        this.author = author;
        this.reviewImage = reviewImage;
        this.editorCopy = editorCopy;
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

    public String getEditorCopy() {
        return editorCopy;
    }

    public void setEditorCopy(String editorCopy) {
        this.editorCopy = editorCopy;
    }
}
