package com.epam.workshop.bot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TelegramBot {
    Logger log = LogManager.getLogger(TelegramBot.class);

    private String botName;
    private String botToken;

    public TelegramBot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;
    }
}
