package com.example.demo.controller;

import com.example.demo.model.Blog;
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

    @GetMapping("/select/blogs")
    public List<Blog> getBlogs(){
        List<Blog> blogs = blogPageRepository.findAll();

        return blogs;
    }

    //    ====== SELECT ONE BLOG =====
    @GetMapping("/select/blog/{id}")
    public Blog getOneBlogWId(@PathVariable int id){
        Blog blog = blogPageRepository.findById(id);

        return blog;
    }

    //    ====== SELECT ALL BLOGS WITH ID =====
    @GetMapping("/select/all/blogs/{id}")
    public List<Blog> getAllBlogsWId(@PathVariable int id){
        System.out.println(id);
        List<Blog> blogs = blogPageRepository.findAllById(id);

        return blogs;
    }

    //    ==================================================== POST BLOG ================================================

//    =======  INSERT BLOG =====

    @PostMapping(value = "/insert/blog", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog insertBlog(@RequestBody Blog blog) {
        System.out.println(blog);

        return blogPageRepository.save(blog);
    }

    //    =======  EDIT BLOG =====

    @PostMapping(value="/edit/blog", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog editBlog(@RequestBody Blog blog){

        return blogPageRepository.save(blog);

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
