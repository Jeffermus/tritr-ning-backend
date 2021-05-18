package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;
    //    ==================================================== GET TICKET ================================================

    @GetMapping("/select/ticket")
    public List<Contact> findAllTickets(){
    List<Contact> contactTicket = contactRepository.findAll();

        return contactTicket;
    }
    //    ==================================================== POST TICKET ================================================

    @PostMapping(value="/insert/ticket", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact insertTicket(@RequestBody Contact insertContactTicket){
        System.out.println(insertContactTicket);

        return contactRepository.save(insertContactTicket);
    }
}
