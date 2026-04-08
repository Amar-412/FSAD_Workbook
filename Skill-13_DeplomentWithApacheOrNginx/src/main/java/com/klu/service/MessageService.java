package com.klu.service;

import org.springframework.stereotype.Service;
import com.klu.model.Message;

@Service
public class MessageService {

    public Message getMessage() {
        return new Message("Hello from Production Ready Backend");
    }
}

