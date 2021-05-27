package com.example.demo.controller;

//import com.example.demo.model.Blog;
import com.example.demo.model.BlogPage;
import com.example.demo.repository.BlogPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class BlogPageController {

    @Autowired
    BlogPageRepository blogPageRepository;

    //    ==================================================== GET BLOG ================================================

//    ====== SELECT ALL BLOG =====

    @GetMapping("/select/blogs")
    public List<BlogPage> getBlogs(){
        List<BlogPage> blogs = blogPageRepository.findAll();

        return blogs;
    }

    //    ====== SELECT ONE BLOG =====
    @GetMapping("/select/blog/{title}")
    public BlogPage getOneBlogWTitle(@PathVariable String title){
        BlogPage blogPage = blogPageRepository.findByTitle(title);

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

    //    =======  EDIT BLOG =====

    @PutMapping(value="/edit/blog", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void editBlog(@RequestBody BlogPage blogPage){
        System.out.println(blogPage.getId());

        BlogPage objectToUpdate = blogPageRepository.findById(blogPage.getId());
        System.out.println(objectToUpdate);
        if (blogPage.description != null){
            objectToUpdate.setDescription(blogPage.getDescription());
        }
        objectToUpdate.setAuthor(blogPage.getAuthor());
        objectToUpdate.setDescription(blogPage.getDescription());
        objectToUpdate.setImg(blogPage.getImg());
        objectToUpdate.setTitle(blogPage.getTitle());
        objectToUpdate.setDatetime(blogPage.getDatetime());
        System.out.println(blogPage);

        blogPageRepository.save(objectToUpdate);

    }

    //    ==================================================== DELETE BLOG ================================================

    @ResponseStatus(code=HttpStatus.OK)
    @DeleteMapping("/delete/blog/{id}")
    public void deleteBlog(@PathVariable int id){
        System.out.println("ID================"+id);
        try {
            blogPageRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }
}
