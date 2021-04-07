package ru.potato.telegram.bot.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.potato.telegram.bot.MessageSender;
import ru.potato.telegram.bot.TelegramMessageHolder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageSender sender;
    @Autowired
    private TelegramMessageHolder messageHolder;

    @GetMapping("/send")
    public void send(@RequestParam("message") String message) {
        sender.sendTextMessage(message);
    }

    @GetMapping("/get")
    public List<String> get() {
        return messageHolder.getMessages();
    }

}
