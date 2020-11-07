package com.zuul;

import com.zuul.rooms.*;

public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Creates the world in the game
     */
    private void createRooms() {
        Room devilheadquater, matas, laundry, cardealer, dock;

        devilheadquater = new DevilsRoom("in Devil's Headquater");

        matas = new UpgradeRoom("in Matas",
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("Svanemærket", 0.0, 1.0),
                                new Upgrade("Håndsæbe", 1.0, 2.0),
                                new Upgrade("Shampoo", 2.0, 3.0),
                                new Upgrade("Balsam", 3.0, 4.0),
                                new Upgrade("Face Scrub Cream", 4.0, 5.0),
                                new Upgrade("Barberskum", 5.0, 6.0),
                                new Upgrade("Mascara", 6.0, 7.0),
                                new Upgrade("Foundation", 7.0, 8.0),
                                new Upgrade("Lip Gloss", 8.0, 9.0),
                                new Upgrade("Clean Laundry bod", 9.0, 10.0),
                                new Upgrade("Concealer", 10.0, 11.0),
                                new Upgrade("Footscrub", 11.0, 12.0),
                                new Upgrade("Self Tan Bronzing Cream", 12.0, 13.0),
                                new Upgrade("Glimmer", 13.0, 14.0),
                                new Upgrade("Tandpasta", 14.0, 15.0)

                        }
                ),
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("Aldrig", 0.0, 1.0),
                                new Upgrade("1 gang om året", 1.0, 2.0),
                                new Upgrade("2 gange om året", 2.0, 3.0),
                                new Upgrade("1 gang i kvartalet", 3.0, 4.0),
                                new Upgrade("1 gang om måneden", 4.0, 5.0),
                                new Upgrade("2 gange om måneden", 5.0, 6.0),
                                new Upgrade("1 gang om ugen", 6.0, 7.0),
                                new Upgrade("2 gange om ugen", 7.0, 8.0),
                                new Upgrade("1 gang om dagen", 8.0, 9.0),
                                new Upgrade("2 gange om dagen", 9.0, 10.0),
                                new Upgrade("3 gange om dagen", 10.0, 11.0),
                                new Upgrade("4 gange om dagen", 11.0, 12.0),
                                new Upgrade("6 gange om dagen", 12.0, 13.0),
                                new Upgrade("1 gang i timen", 13.0, 14.0),
                                new Upgrade("1 gang i kvarteret", 14.0, 15.0)

                        }
                )
        );
        //Mangler Hvad der skal vaskes.
        laundry = new UpgradeRoom("At the laundrette",
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("Svanemærket", 0.0, 1.0),
                                new Upgrade("Håndsæbe", 1.0, 2.0),
                                new Upgrade("Shampoo", 2.0, 3.0),
                                new Upgrade("Balsam", 3.0, 4.0),
                                new Upgrade("Face Scrub Cream", 4.0, 5.0),
                                new Upgrade("Barberskum", 5.0, 6.0),
                                new Upgrade("Mascara", 6.0, 7.0),
                                new Upgrade("Foundation", 7.0, 8.0),
                                new Upgrade("Lip Gloss", 8.0, 9.0),
                                new Upgrade("Clean Laundry bod", 9.0, 10.0),
                                new Upgrade("Concealer", 10.0, 11.0),
                                new Upgrade("Footscrub", 11.0, 12.0),
                                new Upgrade("Self Tan Bronzing Cream", 12.0, 13.0),
                                new Upgrade("Glimmer", 13.0, 14.0),
                                new Upgrade("Tandpasta", 14.0, 15.0)

                        }
                ),
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("Aldrig", 0.0, 1.0),
                                new Upgrade("2 gange om året", 1.0, 2.0),
                                new Upgrade("4 gange om året", 2.0, 3.0),
                                new Upgrade("1 gang om måneden", 3.0, 4.0),
                                new Upgrade("2 gange om måneden", 4.0, 5.0),
                                new Upgrade("3 gange om måneden", 5.0, 6.0),
                                new Upgrade("1 gang om ugen", 6.0, 7.0),
                                new Upgrade("2 gange om ugen", 7.0, 8.0),
                                new Upgrade("3 gange om ugen", 8.0, 9.0),
                                new Upgrade("4 gange om ugen", 9.0, 10.0),
                                new Upgrade("5 gange om ugen", 10.0, 11.0),
                                new Upgrade("6 gange om ugen", 11.0, 12.0),
                                new Upgrade("1 gang om dagen", 12.0, 13.0),
                                new Upgrade("2 gange om dagen", 13.0, 14.0),
                                new Upgrade("4 gange om dagen", 14.0, 15.0)

                        }
                )
        );

        cardealer = new UpgradeRoom("At the cardealer",
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("Bare fødder", 0.0, 1.0),
                                new Upgrade("Sneaks", 1.0, 2.0),
                                new Upgrade("Skateboard", 2.0, 3.0),
                                new Upgrade("Cykel", 3.0, 4.0),
                                new Upgrade("Offentlig Transport", 4.0, 5.0),
                                new Upgrade("Volkswagen UP", 5.0, 6.0),
                                new Upgrade("Ford Focus", 6.0, 7.0),
                                new Upgrade("Mercedes CLA", 7.0, 8.0),
                                new Upgrade("Ferrari", 8.0, 9.0),
                                new Upgrade("Formel 1", 9.0, 10.0),
                                new Upgrade("Lastbil", 10.0, 11.0),
                                new Upgrade("MonsterTruck", 11.0, 12.0)

                        }
                ),
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("0 km om uge", 0.0, 1.0),
                                new Upgrade("5 km om ugen", 1.0, 2.0),
                                new Upgrade("10 km om ugen", 2.0, 3.0),
                                new Upgrade("20 km om ugen", 3.0, 4.0),
                                new Upgrade("40 km om ugen", 4.0, 5.0),
                                new Upgrade("60 km om ugen", 5.0, 6.0),
                                new Upgrade("80 km om ugen", 6.0, 7.0),
                                new Upgrade("100 km om ugen", 7.0, 8.0),
                                new Upgrade("125 km om ugen", 8.0, 9.0),
                                new Upgrade("150 km om ugen", 9.0, 10.0),
                                new Upgrade("175 km om ugen", 10.0, 11.0),
                                new Upgrade("200 km om ugen", 11.0, 12.0),
                                new Upgrade("250 km om ugen", 12.0, 13.0),
                                new Upgrade("300 km om ugen", 13.0, 14.0),
                                new Upgrade("400 km om ugen", 14.0, 15.0)

                        }
                )
        );

        dock = new UpgradeRoom("At the dock",
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("Brødkrummer", 0.0, 1.0),
                                new Upgrade("Sugerør", 1.0, 2.0),
                                new Upgrade("Slikpapir", 2.0, 3.0),
                                new Upgrade("Plastikflaske", 3.0, 4.0),
                                new Upgrade("Plastikpose", 4.0, 5.0),
                                new Upgrade("Actionman", 5.0, 6.0),
                                new Upgrade("Vandkande", 6.0, 7.0),
                                new Upgrade("IKEA-kasse", 7.0, 8.0),
                                new Upgrade("Badeflamingo", 8.0, 9.0),
                                new Upgrade("Bildæk", 9.0, 10.0),
                                new Upgrade("Presenning", 10.0, 11.0),
                                new Upgrade("Rutchebane", 11.0, 12.0),
                                new Upgrade("Havetrampolin", 12.0, 13.0),
                                new Upgrade("Kayak", 13.0, 14.0),
                                new Upgrade("Havepool", 14.0, 15.0)


                        }
                ),
                new UpgradePath("Forbrug",
                        new Upgrade[] {
                                new Upgrade("Aldrig", 0.0, 1.0),
                                new Upgrade("1 gang om året", 1.0, 2.0),
                                new Upgrade("2 gange om året", 2.0, 3.0),
                                new Upgrade("1 gang i kvartalet", 3.0, 4.0),
                                new Upgrade("1 gang om måneden", 4.0, 5.0),
                                new Upgrade("2 gange om måneden", 5.0, 6.0),
                                new Upgrade("1 gang om ugen", 6.0, 7.0),
                                new Upgrade("2 gange om ugen", 7.0, 8.0),
                                new Upgrade("1 gang om dagen", 8.0, 9.0),
                                new Upgrade("2 gange om dagen", 9.0, 10.0),
                                new Upgrade("3 gange om dagen", 10.0, 11.0),
                                new Upgrade("4 gange om dagen", 11.0, 12.0),
                                new Upgrade("6 gange om dagen", 12.0, 13.0),
                                new Upgrade("1 gang i timen", 13.0, 14.0),
                                new Upgrade("1 gang i kvarteret", 14.0, 15.0)

                        }
                )
        );

        devilheadquater.setExit("north", matas);
        devilheadquater.setExit("south", laundry);

        matas.setExit("south", devilheadquater);
        matas.setExit("east", cardealer);

        cardealer.setExit("west", matas);
        cardealer.setExit("south", dock);

        dock.setExit("north", cardealer);
        dock.setExit("west", laundry);

        laundry.setExit("north", devilheadquater);
        laundry.setExit("east", dock);

        currentRoom = devilheadquater;
    }

    /**
     * Main method for gameplay.
     */
    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            // Record user input
            Command command = parser.getCommand();
            // Process the command.
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Prints welcome message.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Checks whether a valid command has been called and executes that command.
     *
     * @param command
     * @return true if the command "quit" has been written.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        // If invalid command has been written.
        // This is a note for the team. Since com.zuul.CommandWord.UNKNOWN
        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.UPGRADE && currentRoom instanceof UpgradeRoom) {
            selectUpgrade((UpgradeRoom) currentRoom);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.NEXTTURN) {
            goTurn(command);
            System.out.println(GameStats.getYear());
        }
        return wantToQuit;
    }

    /**
     * Prints commands and help screen to the user.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Method to go from door to door. It uses the com.zuul.rooms.Room class to decide whether the
     * current selected room exists. If it does sets currentRoom to be the selected
     * room.
     *
     * @param command com.zuul.Command used to go to next room.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * Method to select upgrade and uses the com.zuul.Parser class to record which upgrade to
     * select.
     *
     * @author Casper
     * @param room is current room, but is used to find current selectable upgrades.
     */
    private void selectUpgrade(UpgradeRoom room) {
        // Error Handling
        // if(room.upgradePathQuantity == null || room.upgradePathQuantity.upgrades ==
        // null){
        // System.out.println("Error: Upgrades is NULL");
        // return;
        // }

        // find upgrades
        // com.zuul.Upgrade[] upgrades = room.upgradePathQuantity.upgrades;

        // If there are no more upgrades
        // if(upgrades.length < 1){
        // System.out.println("You and you adviser has been left to");
        // System.out.println("wander what to upgrade, and have");
        // System.out.println("decided that nothing is left.");
        // return;
        // }

        // Flavour text
        System.out.println("You decided it would be profitable to upgrade this");
        System.out.println("countries' industry.");
        System.out.println();
        System.out.println("You consult your adviser, which inform you that the");
        System.out.println("following upgrades are available.");
        System.out.println();

        // Input loop
        // while(true){
        //
        // // Print upgrade flavour text
        // System.out.println("upgrades:");
        // for(int i = 0; i < upgrades.length; i++){
        // System.out.print(" " + (i+1) +"# - ");
        // System.out.println(upgrades[i].getUpgradeName());
        // }
        //
        // // Get console command
        // com.zuul.Command command = parser.getCommand();
        //
        // // Process "UPGRADE #"
        // if(command.getCommandWord() == com.zuul.CommandWord.UPGRADE) {
        // // Error handling
        // if (command.hasSecondWord()) {
        // System.out.println("Please select an upgrade");
        // System.out.println();
        // continue;
        // }
        //
        // // Handle upgrade.
        //
        // // Process "BACK"
        // }else if (command.getCommandWord() == com.zuul.CommandWord.BACK){
        // System.out.println(room.getLongDescription());
        // break;
        // }else{
        // System.out.println("Please select a valid command word at this time.");
        // System.out.println();
        // System.out.println("Commands:");
        // System.out.println(com.zuul.CommandWord.UPGRADE.toString() + " " +
        // com.zuul.CommandWord.BACK.toString());
        // System.out.println();
        // continue;
        // }
        //
    }

    public void goTurn(Command command) {
        GameStats.SimulateTurn(1);
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
