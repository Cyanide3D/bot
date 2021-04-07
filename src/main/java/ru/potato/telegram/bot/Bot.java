package ru.potato.telegram.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.potato.telegram.bot.commands.HelpCommand;

import javax.annotation.PostConstruct;

@Component
public class Bot extends TelegramLongPollingCommandBot {

    private final Logger logger = LoggerFactory.getLogger(Bot.class);
    @Autowired
    private TelegramMessageHolder messageHolder;
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String token;

    @PostConstruct
    private void init() {
        botConnect();
        commandRegister();
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        String message = update.getChannelPost().getText();
        messageHolder.addMessage(message);
    }

    @Override
    public String getBotToken() {
        return token;
    }

    private void botConnect() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(this);
            logger.info("Bot started...");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void commandRegister() {
        register(new HelpCommand());
    }

}
