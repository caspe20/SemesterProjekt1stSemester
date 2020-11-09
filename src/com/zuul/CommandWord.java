package com.zuul;

public enum CommandWord {
    GO("go"),
    QUIT("quit"),
    HELP("help"),
    UPGRADE("upgrade"),
    NEXTTURN("next"),
    BACK("back"),
    UNKNOWN("?"),
    STATS("stats");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
