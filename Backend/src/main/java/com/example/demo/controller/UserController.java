package com.example.demo.controller;

import com.example.demo.model.Auth;
import com.example.demo.model.Users;
import com.example.demo.repository.AuthRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
    public Auth insertUser(@RequestBody Users users) {

        Users userSaved = userRepository.save(users);
        Auth auth = new Auth();
        auth.setRole("USER_ADMIN");
        auth.setUsers(userSaved);

        System.out.println("blabla" + userSaved);

        return authRepository.save(auth);
    }

//    ==================================================== DELETE USER ==============================================

    @ResponseStatus(code=HttpStatus.OK)
    @PostMapping("/delete/user/{id}")
    public void deleteUser(@PathVariable int id){
        System.out.println("ID=============="+id);
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("FEJL i DELETE =" + ex.getMessage());
        }
    }


}