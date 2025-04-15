package com.example.startspring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public List<Message> getMessages() {
        return messages;
    }
    @PostMapping
    public String addMessage(@RequestBody Message message) {
        messages.add(message);
        return message.getName();
    }
}
