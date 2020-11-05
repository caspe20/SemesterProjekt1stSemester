public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UPGRADE("upgrade"),NEXTTURN("next"), BACK("back"), UNKNOWN("?");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
