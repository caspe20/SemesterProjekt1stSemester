package com.zuul.application;

public enum CommandWord {
    GO("gå"),
    QUIT("afslut"),
    HELP("hjælp"),
    UPGRADE("opgrader"),
    NEXTTURN("næste"),
    BACK("tilbage"),
    UNKNOWN("?"),
    STATS("stats"),
    CONTINUE("fortsæt");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
