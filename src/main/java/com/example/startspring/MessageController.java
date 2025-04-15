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

    @GetMapping("{/id}")
    public String findById(@PathVariable String id) {
        return id;
    }

    @GetMapping("/delete/{id}")
    public String deleteMessages(@PathVariable String id){
        boolean delete = messages.removeIf(message -> message.getId().equals(id));
        return delete ? "deleted" : "not found";
    }


}
