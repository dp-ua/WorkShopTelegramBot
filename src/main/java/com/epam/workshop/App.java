package com.epam.workshop;

import com.epam.workshop.bot.TelegramBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
//        ApiContextInitializer.init();

        final TelegramBot telegramBot = new TelegramBot("name", "token");
        connect(telegramBot);
    }

    private static void connect(TelegramBot telegramBot) {
//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        // TODO: connect your bot
    }
}
