package com.example.controller;

import com.example.core.R;
import com.example.model.Message;
import com.example.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final MessageRepository messageRepository;

    public ApiController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @GetMapping("/messages")
    public R messages() {
        Iterable<Message> messages = this.messageRepository.findAll();
        return R.ok().data(messages);
    }

}
