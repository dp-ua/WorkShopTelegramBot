package com.epam.workshop.command;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private static final String botName = "botName";
    public static final String TEXT_FOR_TEST = "text For test";

    private Parser parser;

    @Before
    public void setParser() {
        parser = new Parser(botName);
    }

    @Test
    public void getParsedCommand_TestBasicGlobalCommandsWithoutText() {
        Map<Command, String> globalCommands = getGlobalCommands();

        for (Map.Entry<Command, String> entry : globalCommands.entrySet()) {
            String inputText = entry.getValue();
            ParsedCommand parsedCommand = parser.getParsedCommand(inputText);
            assertEquals(entry.getKey(), parsedCommand.getCommand());
        }
    }

    @Test
    public void getParsedCommand_TestCommandsWithText() {
        Map<Command, String> globalCommands = getGlobalCommands();

        for (Map.Entry<Command, String> entry : globalCommands.entrySet()) {
            String inputText = entry.getValue() + " " + TEXT_FOR_TEST;
            ParsedCommand parsedCommand = parser.getParsedCommand(inputText);
            assertEquals(entry.getKey(), parsedCommand.getCommand());
            assertEquals(TEXT_FOR_TEST, parsedCommand.getText());
        }
    }

    @Test
    public void getParsedCommand_None() {
        ParsedCommand parsedCommandAndText = parser.getParsedCommand(TEXT_FOR_TEST);
        assertEquals(Command.$NONE, parsedCommandAndText.getCommand());
        assertEquals(TEXT_FOR_TEST, parsedCommandAndText.getText());
    }

    @Test
    public void getParsedCommand_NotForMe() {
        Map<Command, String> globalCommands = getGlobalCommands();
        for (Map.Entry<Command, String> entry : globalCommands.entrySet()) {
            String text = entry.getValue() + "@another_Bot";
            ParsedCommand parsedCommandAndText = parser.getParsedCommand(text);
            assertEquals(Command.$NOTFORME, parsedCommandAndText.getCommand());
        }
    }

    private Map<Command, String> getGlobalCommands() {
        Map<Command, String> result = new HashMap<>();
        result.put(Command.START, "/start");
        result.put(Command.HELP, "/help");
        return result;
    }
}