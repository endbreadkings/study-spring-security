package me.doyoung.resourceserver.web;

import org.springframework.web.bind.annotation.GetMapping;

public class MessageController {
    @GetMapping("/messages")
    public String[] getMessages() {
        return new String[]{"Message 1", "Message 2", "Message 3"};
    }
}
