package com.example.demo.controller;

import com.example.demo.model.Auth;
import com.example.demo.model.Users;
import com.example.demo.repository.AuthRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthRepository authRepository;


//    ==================================================== GET USERS ===================================================

    //     === SELECT ALL USERS ===
    @GetMapping(value="/select/users")
    public List<Users> getAllUsers(){

        List <Users> user = userRepository.findAll();

        System.out.println("USER FOUND==="+user);

        return user;
    }

//   ==================================================== POST USERS TO DB =============================================

    //     === INSERT USER ===
    @PostMapping(value = "/insert/user", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Users insertUser(@RequestBody Users users) {
        System.out.println(users);

        return userRepository.save(users);
    }

    //     === INSERT AUTH ===
    @PostMapping(value = "/insert/auth", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Auth insertAuth(@RequestBody Auth auth) {
        System.out.println(auth);

        return authRepository.save(auth);
    }

    //     === UPDATE ONE PROFILE ===
    @PostMapping(value = "/update/user", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserCredentials(@RequestBody Users users) {
        System.out.println("USERS ==="+users);
        User oneUser = userRepository.findById(users.getId());
        oneUser.setMail(users.getMail());
        if(users.getPassword() != null){
            oneUser.setPassword(users.getPassword());
        }
        System.out.println("ONE USER ==="+oneUser);
        userRepository.save(oneUser);
    }

//    ==================================================== DELETE PROFILE ==============================================

    @ResponseStatus(code=HttpStatus.OK)
    @PostMapping("/delete/profile/{id}")
    public void deleteProfile(@PathVariable int id){
        System.out.println("ID=============="+id);
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }


}