package com.example.demo.controller;


import com.example.demo.service.JavaEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class ContactController {

    @Autowired
    private JavaEmailService javaEmailService;

    @RequestMapping("/send-mail")
    public void sendMail() throws MessagingException{
        javaEmailService.send("andreas1992@outlook.dk", "Test mail from Spring", "howdy");
    }
}
