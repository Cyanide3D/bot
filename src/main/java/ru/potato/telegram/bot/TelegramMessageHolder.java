package ru.potato.telegram.bot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramMessageHolder {

    private final List<String> messages = new ArrayList<>();

    public boolean addMessage(String message) {
        return messages.add(message);
    }

    public List<String> getMessages() {
        List<String> temp = new ArrayList<>(messages);
        messages.clear();
        return temp;
    }

}
