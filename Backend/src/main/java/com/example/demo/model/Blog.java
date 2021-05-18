package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private int blogId;
    private String blogTitle;
    private String blogDescription;
    private String blogImg;
    private String blogDate;
    private String blogAuthor;

    public Blog() {
    }

    public Blog(String blogTitle, String blogDescription, String blogImg, String blogDate, String blogAuthor) {
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
        this.blogImg = blogImg;
        this.blogDate = blogDate;
        this.blogAuthor = blogAuthor;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getBlogImg() {
        return blogImg;
    }

    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogDescription='" + blogDescription + '\'' +
                ", blogImg='" + blogImg + '\'' +
                ", blogDate='" + blogDate + '\'' +
                ", blogAuthor='" + blogAuthor + '\'' +
                '}';
    }
}
