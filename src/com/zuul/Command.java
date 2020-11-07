package com.zuul;

public class Command {
    private CommandWord commandWord;
    private String secondWord;

    /**
     * Default constructor for Commands
     * @param commandWord
     * @param secondWord
     */
    public Command(CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * @return the com.zuul.CommandWord that is associated with the command
     */
    public CommandWord getCommandWord() {
        return commandWord;
    }

    /**
     * @return The rest of the input string
     */
    public String getSecondWord() {
        return secondWord;
    }


    public boolean isUnknown() {
        return (commandWord == CommandWord.UNKNOWN);
    }


    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
