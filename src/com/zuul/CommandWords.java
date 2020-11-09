package com.zuul;

import java.util.HashMap;

public class CommandWords {
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor
     * Looks through all enum commands and adds them to a HashMap
     */
    public CommandWords() {
        validCommands = new HashMap<String, CommandWord>();
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN || command != CommandWord.BACK) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Returns the command word as long as it exists in valid commands...
     * otherwise it returns com.zuul.CommandWord.UNKNOWN;
     * @param commandWord
     * @return com.zuul.Command
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Displays all valid command for the player
     */
    public void showAll() {
        for (String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
