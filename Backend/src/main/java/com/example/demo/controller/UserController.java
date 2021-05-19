package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

//    ==================================================== GET USER ================================================

    //     === SELECT ALL USERS ===
    @GetMapping(value="/select/users")
    public List<User> getAllUsers(){

        List <User> user = userRepository.findAll();

        System.out.println("USER FOUND==="+user);

        return user;
    }

    //    ==================================================== POST USER ================================================

    //     === INSERT USER ===
    @PostMapping(value = "/insert/user", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User insertUser(@RequestBody User user) {
        System.out.println(user);

        return userRepository.save(user);
    }

    //     === INSERT USER ===
    @PostMapping(value = "/insert/")

    //    ==================================================== DELETE PROFILE ================================================

    @ResponseStatus(code=HttpStatus.OK)
    @DeleteMapping("/delete/profile/{id}")
    public void deleteProfile(@PathVariable int id){
        System.out.println("ID=============="+id);
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }

}