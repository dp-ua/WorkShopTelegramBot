package com.epam.workshop.command;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parser {
    private static final Logger log = LogManager.getLogger(Parser.class);
    private String botName;

    public Parser(String botName) {
        this.botName = botName;
    }

    public ParsedCommand getParsedCommand(String text) {
        log.debug("Try to parse text:{" + text + "}, botName:{" + botName + "}");

        // TODO: 3/1/2020 write parse function

        throw new UnsupportedOperationException();
    }
}
