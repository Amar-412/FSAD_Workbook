package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Message;
import com.klu.service.MessageService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MessageController {	

    @Autowired
    private MessageService service;

    @GetMapping("/message")
    public Message fetchMessage() {
        return service.getMessage();
    }
}
