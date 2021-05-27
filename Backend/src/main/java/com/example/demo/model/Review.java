package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String reviewImage;
    private String description;

    @OneToOne(mappedBy = "review")
    private ImageTable imageTable;

    public Review(){

    }

    public Review(String author, String reviewImage, String description) {
        this.author = author;
        this.reviewImage = reviewImage;
        this.description = description;
    }

    public ImageTable getImageTable() {
        return imageTable;
    }

    public void setImageTable(ImageTable imageTable) {
        this.imageTable = imageTable;
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

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", reviewImage='" + reviewImage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
