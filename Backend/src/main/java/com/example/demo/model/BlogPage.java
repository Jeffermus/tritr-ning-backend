package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPage {

    @Id
    public int Id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Title;
    private String Description;
    private String Img;
    private String Date;
    private String Author;

    public BlogPage() {
    }

    public BlogPage(String Title, String Description, String Img, String Date, String Author) {
        this.Title = Title;
        this.Description = Description;
        this.Img = Img;
        this.Date = Date;
        this.Author = Author;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "BlogPage{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Img='" + Img + '\'' +
                ", Date='" + Date + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
