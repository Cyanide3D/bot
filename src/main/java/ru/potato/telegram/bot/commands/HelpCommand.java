package ru.potato.telegram.bot.commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class HelpCommand implements IBotCommand {

    @Override
    public String getCommandIdentifier() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "It's help";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
    }



}
