package ru.potato.telegram.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MessageSender {

    private final Bot bot;
    @Value(("${chat.id}"))
    private String chatId;

    public MessageSender(Bot bot) {
        this.bot = bot;
    }

    public void sendTextMessage(String text) {
        try {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(text);
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
