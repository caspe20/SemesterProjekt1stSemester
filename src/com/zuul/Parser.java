package com.zuul;

import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;


    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Method to return the command that the user created for the game.
     * @return com.zuul.Command with the command given by the user. E.g. "Go" "North"
     */
    public Command getCommand() {
        //Declaration
        String inputLine;
        String word1 = null;
        String word2 = null;

        //Text beautification
        System.out.print("> ");

        //Read the next input and store it in the declared variable
        inputLine = reader.nextLine();

        //Store the new line in a variable
        Scanner tokenizer = new Scanner(inputLine);
        //If line has a word in it
        if (tokenizer.hasNext()) {
            //Store that word in a variable
            word1 = tokenizer.next();
            //If that line still has a word in it
            if (tokenizer.hasNext()) {
                //Stor that word in another variable
                word2 = tokenizer.next();
            }
        }

        //Return new command of the type Commad(word1, word2).
        //Makes sure that word1 is a command word.
        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * prints all viable commands.
     */
    public void showCommands() {
        commands.showAll();
    }
}
