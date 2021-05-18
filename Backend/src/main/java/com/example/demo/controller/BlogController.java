package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    //    ==================================================== GET BLOG ================================================

//    ====== SELECT ALL BLOG =====

    @GetMapping("/select/Blogs")
    public List<Blog> findAllBlogs() {
        List<Blog> blogs = BlogRepository.findAll();

        return blogs;
    }

    //    ====== SELECT ONE BLOG =====
    @GetMapping("/select/blog/{id}")
    public Blog getOneActivityWId(@PathVariable int id){
        Blog blog = blogRepository.findById(id);

        return blog;
    }

    //    ==================================================== POST BLOG ================================================

//    =======  INSERT BLOG =====

    @PostMapping(value = "/insert/blog", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog insertBlog(@RequestBody Blog blog) {
        System.out.println(blog);

        return blogRepository.save(blog);
    }

    //    ==================================================== DELETE BLOG ================================================

    @ResponseStatus(code=HttpStatus.OK)
    @PostMapping("/delete/blog/{id}")
    public void deleteBlog(@PathVariable int id){
        System.out.println("ID================"+id);
        try {
            blogRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }
}
