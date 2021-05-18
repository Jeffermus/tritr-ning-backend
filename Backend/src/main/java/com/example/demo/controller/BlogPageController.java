package com.example.demo.controller;

import com.example.demo.model.BlogPage;
import com.example.demo.repository.BlogPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPageController {

    @Autowired
    BlogPageRepository blogPageRepository;

    //    ==================================================== GET BLOG ================================================

//    ====== SELECT ALL BLOG =====

    //    ====== SELECT ALL Blogs =====
    @GetMapping("/select/blogs")
    public List<BlogPage> getBlogs(){
        List<BlogPage> blogs = blogPageRepository.findAll();

        return blogs;
    }

    //    ====== SELECT ONE BLOG =====
    @GetMapping("/select/blog/{id}")
    public BlogPage getOneBlogWId(@PathVariable int id){
        BlogPage blogPage = blogPageRepository.findById(id);

        return blogPage;
    }

    //    ====== SELECT ALL BLOGS WITH ID =====
    @GetMapping("/select/all/blogs/{id}")
    public List<BlogPage> getAllBlogsWId(@PathVariable int id){
        System.out.println(id);
        List<BlogPage> blogPages = blogPageRepository.findAllById(id);

        return blogPages;
    }

    //    ==================================================== POST BLOG ================================================

//    =======  INSERT BLOG =====

    @PostMapping(value = "/insert/blog", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPage insertBlog(@RequestBody BlogPage blogPage) {
        System.out.println(blogPage);

        return blogPageRepository.save(blogPage);
    }

    //    ==================================================== DELETE BLOG ================================================

    @ResponseStatus(code=HttpStatus.OK)
    @PostMapping("/delete/blog/{id}")
    public void deleteBlog(@PathVariable int id){
        System.out.println("ID================"+id);
        try {
            blogPageRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }
}
