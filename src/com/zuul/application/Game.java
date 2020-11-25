package com.zuul.application;

import com.zuul.application.rooms.*;

public class Game {
    private Parser parser;

    public static Room getCurrentRoom() {
        return currentRoom;
    }

    private static Room currentRoom;
    private Room devilheadquater;
    private UpgradeRoom matas, laundry, cardealer, dock;
    private double CurrentFishSouls = 0d;
    private boolean wantToQuit = false;
    private final String gameName = "Hades' Manglende Fisk";

    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Creates the world in the game
     */
    private void createRooms() {
        devilheadquater = new DevilsRoom("i Djævlens' hovedkvarter");

        matas = new Matas("i Matas",
                new UpgradePath("Product",
                        new Upgrade[] { new Upgrade("Svanemærket", 0.0, 1.0), new Upgrade("Håndsæbe", 1.0, 2.0),
                                new Upgrade("Shampoo", 2.0, 3.0), new Upgrade("Balsam", 3.0, 4.0),
                                new Upgrade("Face Scrub Cream", 4.0, 5.0), new Upgrade("Barberskum", 5.0, 6.0),
                                new Upgrade("Mascara", 6.0, 7.0), new Upgrade("Foundation", 7.0, 8.0),
                                new Upgrade("Lip Gloss", 8.0, 9.0), new Upgrade("Clean Laundry bod", 9.0, 10.0),
                                new Upgrade("Concealer", 10.0, 11.0), new Upgrade("Footscrub", 11.0, 12.0),
                                new Upgrade("Self Tan Bronzing Cream", 12.0, 13.0), new Upgrade("Glimmer", 13.0, 14.0),
                                new Upgrade("Tandpasta", 14.0, 15.0)

                        }),
                new UpgradePath("Forbrug", new Upgrade[] { new Upgrade("Aldrig", 0.0, 1.0),
                        new Upgrade("1 gang om året", 1.0, 2.0), new Upgrade("2 gange om året", 2.0, 3.0),
                        new Upgrade("1 gang i kvartalet", 3.0, 4.0), new Upgrade("1 gang om måneden", 4.0, 5.0),
                        new Upgrade("2 gange om måneden", 5.0, 6.0), new Upgrade("1 gang om ugen", 6.0, 7.0),
                        new Upgrade("2 gange om ugen", 7.0, 8.0), new Upgrade("1 gang om dagen", 8.0, 9.0),
                        new Upgrade("2 gange om dagen", 9.0, 10.0), new Upgrade("3 gange om dagen", 10.0, 11.0),
                        new Upgrade("4 gange om dagen", 11.0, 12.0), new Upgrade("6 gange om dagen", 12.0, 13.0),
                        new Upgrade("1 gang i timen", 13.0, 14.0), new Upgrade("1 gang i kvarteret", 14.0, 15.0)

                }));
        // Mangler Hvad der skal vaskes.
        laundry = new Laundry("ved Vaskeriet",
                new UpgradePath("Product",
                        new Upgrade[] { new Upgrade("Bare fødder", 0.0, 1.0), new Upgrade("Sokker", 1.0, 2.0),
                                new Upgrade("Underbukser", 2.0, 3.0), new Upgrade("Hue", 3.0, 4.0),
                                new Upgrade("Vanter", 4.0, 5.0), new Upgrade("Halstørklæde", 5.0, 6.0),
                                new Upgrade("T-shirt", 6.0, 7.0), new Upgrade("Langærmet T-shirt", 7.0, 8.0),
                                new Upgrade("Shorts", 8.0, 9.0), new Upgrade("Lange Bukser", 9.0, 10.0),
                                new Upgrade("Trøje", 10.0, 11.0), new Upgrade("Kostume", 11.0, 12.0),
                                new Upgrade("Jakke", 12.0, 13.0), new Upgrade("Skibukser", 13.0, 14.0),
                                new Upgrade("Flyverdrakt", 14.0, 15.0)

                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[] { new Upgrade("Aldrig", 0.0, 1.0), new Upgrade("2 gange om året", 1.0, 2.0),
                                new Upgrade("4 gange om året", 2.0, 3.0), new Upgrade("1 gang om måneden", 3.0, 4.0),
                                new Upgrade("2 gange om måneden", 4.0, 5.0),
                                new Upgrade("3 gange om måneden", 5.0, 6.0), new Upgrade("1 gang om ugen", 6.0, 7.0),
                                new Upgrade("2 gange om ugen", 7.0, 8.0), new Upgrade("3 gange om ugen", 8.0, 9.0),
                                new Upgrade("4 gange om ugen", 9.0, 10.0), new Upgrade("5 gange om ugen", 10.0, 11.0),
                                new Upgrade("6 gange om ugen", 11.0, 12.0), new Upgrade("1 gang om dagen", 12.0, 13.0),
                                new Upgrade("2 gange om dagen", 13.0, 14.0), new Upgrade("4 gange om dagen", 14.0, 15.0)

                        }));

        cardealer = new CarDealer("ved Bilforhandleren",
                new UpgradePath("Product",
                        new Upgrade[] { new Upgrade("Bare fødder", 0.0, 1.0), new Upgrade("Sneaks", 1.0, 2.0),
                                new Upgrade("Skateboard", 2.0, 3.0), new Upgrade("Cykel", 3.0, 4.0),
                                new Upgrade("Offentlig Transport", 4.0, 5.0), new Upgrade("Volkswagen UP", 5.0, 6.0),
                                new Upgrade("Ford Focus", 6.0, 7.0), new Upgrade("Mercedes CLA", 7.0, 8.0),
                                new Upgrade("Ferrari", 8.0, 9.0), new Upgrade("Formel 1", 9.0, 10.0),
                                new Upgrade("Lastbil", 10.0, 11.0), new Upgrade("MonsterTruck", 11.0, 12.0)

                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[] { new Upgrade("0 km om uge", 0.0, 1.0), new Upgrade("5 km om ugen", 1.0, 2.0),
                                new Upgrade("10 km om ugen", 2.0, 3.0), new Upgrade("20 km om ugen", 3.0, 4.0),
                                new Upgrade("40 km om ugen", 4.0, 5.0), new Upgrade("60 km om ugen", 5.0, 6.0),
                                new Upgrade("80 km om ugen", 6.0, 7.0), new Upgrade("100 km om ugen", 7.0, 8.0),
                                new Upgrade("125 km om ugen", 8.0, 9.0), new Upgrade("150 km om ugen", 9.0, 10.0),
                                new Upgrade("175 km om ugen", 10.0, 11.0), new Upgrade("200 km om ugen", 11.0, 12.0),
                                new Upgrade("250 km om ugen", 12.0, 13.0), new Upgrade("300 km om ugen", 13.0, 14.0),
                                new Upgrade("400 km om ugen", 14.0, 15.0)

                        }));

        dock = new Dock("ved Molen",
                new UpgradePath("Product",
                        new Upgrade[] { new Upgrade("Brødkrummer", 0.0, 1.0), new Upgrade("Sugerør", 1.0, 2.0),
                                new Upgrade("Slikpapir", 2.0, 3.0), new Upgrade("Plastikflaske", 3.0, 4.0),
                                new Upgrade("Plastikpose", 4.0, 5.0), new Upgrade("Actionman", 5.0, 6.0),
                                new Upgrade("Vandkande", 6.0, 7.0), new Upgrade("IKEA-kasse", 7.0, 8.0),
                                new Upgrade("Badeflamingo", 8.0, 9.0), new Upgrade("Bildæk", 9.0, 10.0),
                                new Upgrade("Presenning", 10.0, 11.0), new Upgrade("Rutchebane", 11.0, 12.0),
                                new Upgrade("Havetrampolin", 12.0, 13.0), new Upgrade("Kayak", 13.0, 14.0),
                                new Upgrade("Havepool", 14.0, 15.0)

                        }),
                new UpgradePath("Forbrug", new Upgrade[] { new Upgrade("Aldrig", 0.0, 1.0),
                        new Upgrade("1 gang om året", 1.0, 2.0), new Upgrade("2 gange om året", 2.0, 3.0),
                        new Upgrade("1 gang i kvartalet", 3.0, 4.0), new Upgrade("1 gang om måneden", 4.0, 5.0),
                        new Upgrade("2 gange om måneden", 5.0, 6.0), new Upgrade("1 gang om ugen", 6.0, 7.0),
                        new Upgrade("2 gange om ugen", 7.0, 8.0), new Upgrade("1 gang om dagen", 8.0, 9.0),
                        new Upgrade("2 gange om dagen", 9.0, 10.0), new Upgrade("3 gange om dagen", 10.0, 11.0),
                        new Upgrade("4 gange om dagen", 11.0, 12.0), new Upgrade("6 gange om dagen", 12.0, 13.0),
                        new Upgrade("1 gang i timen", 13.0, 14.0), new Upgrade("1 gang i kvarteret", 14.0, 15.0)

                }));

        devilheadquater.setExit("nord", matas);
        devilheadquater.setExit("syd", laundry);

        matas.setExit("syd", devilheadquater);
        matas.setExit("øst", cardealer);

        cardealer.setExit("vest", matas);
        cardealer.setExit("syd", dock);

        dock.setExit("nord", cardealer);
        dock.setExit("vest", laundry);

        laundry.setExit("nord", devilheadquater);
        laundry.setExit("øst", dock);

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
        ScreenWriter.print("Tak for at spille spillet! Vi håber du nød det :)");
    }

    /**
     * Prints welcome message.
     */
    private void printWelcome() {
        ScreenWriter.printCenterSpecial("Velkommen til " + gameName + "!", '-');
        ScreenWriter.print("I \"" + gameName + "\" spiller du som Djævlen som prøver på at øge "
                + "produktionen af fisk i underværdenen ved at slå fisk i jordens have ihjel, "
                + "ved hjælp af plastik partikler.\n\nDet er derfor din opgave som djævlen i dette spil"
                + "at dræbe alle fisk på jordens overflade, så demonerne i underverdenen igen kan nyde"
                + "deres yndlings kogekunst!\n");
        parser.waitForContinue(); // WAIT
        ScreenWriter.printCenter("Skriv '" + CommandWord.HELP + "' hvis du har brug for hjælp");
        parser.waitForContinue();
        ScreenWriter.printCenterSpecial("Dag/uge/år/halvår/etc. " + GameStats.currentTurn, '-');
        ScreenWriter.print(currentRoom.getLongDescription());
    }

    /**
     * Checks whether a valid command has been called and executes that command.
     *
     * @param command
     * @return true if the command "quit" has been written.
     */
    private boolean processCommand(Command command) {
        CommandWord commandWord = command.getCommandWord();

        // If invalid command has been written.
        // This is a note for the team. Since com.zuul.application.CommandWord.UNKNOWN
        if (commandWord == CommandWord.UNKNOWN) {
            ScreenWriter.print("Hov, jeg forstod ikke hvad du mente...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp(command);
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.UPGRADE && currentRoom instanceof UpgradeRoom) {
            selectUpgrade((UpgradeRoom) currentRoom, command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.NEXTTURN) {
            goTurn(command);

        } else if (commandWord == CommandWord.STATS) {
            GameStats.printStats();
        }
        return wantToQuit;
    }

    /**
     * Prints commands and their information to the user.
     * 
     * @param command Used to find the current command the user wants help with.
     */
    private void printHelp(Command command) {
        if (!command.hasSecondWord()) {
            // Standard help messages.
            ScreenWriter.print("Du tænker til dig selv \"Hvad er mine muligheder\","
                    + " og bedst som du tænker dette, kommer din personlige rådgiver løbende med en papyrus!\n");
            ScreenWriter.printCenterSpecial(CommandWord.HELP.toString().toUpperCase(), '-');
            ScreenWriter.print("Hvis der ønskes en yderligere forklaring på kommandoerne" + " nedenfor, så skriv \""
                    + CommandWord.HELP + " [kommando]\"." + "\n\nDisse kommandoer er tilgængelige:");
            // print kommandoerne.
            ScreenWriter.printCenter(parser.showCommands());
        } else {
            // Help med kommandoer
            CommandWord secondCommand = parser.fetchCommandWord(command.getSecondWord());
            if (secondCommand == CommandWord.NEXTTURN) {
                // Print header
                ScreenWriter.printCenterSpecial(secondCommand.toString().toUpperCase(), '-');
                // Print command view
                ScreenWriter.printCenter("\"" + CommandWord.NEXTTURN + "\" : \"[]\" - " + CommandWord.NEXTTURN
                        + " har ikke nogen sekundær kommando");
                // print command text
                ScreenWriter.print("\"" + CommandWord.NEXTTURN + "\" bliver brugt til at skifte til den næste tur.");
            } else if (secondCommand == CommandWord.GO) {
                // Print header
                ScreenWriter.printCenterSpecial(secondCommand.toString().toUpperCase(), '-');
                // Print command view
                ScreenWriter.printCenter("\"" + CommandWord.GO + "\" : \"[ nord, syd, øst, vest ]\"");
                // print command text
                ScreenWriter.print("\"" + CommandWord.GO
                        + "\", sammen med en retning, får karakteren til at gå i den retning som er "
                        + "specificeret efter kommandoen. Det er denne metode der får spilleren til at gå "
                        + "fra rum til tum!");
            } else if (secondCommand == CommandWord.QUIT) {
                // Print header
                ScreenWriter.printCenterSpecial(secondCommand.toString().toUpperCase(), '-');
                // Print command view
                ScreenWriter.printCenter("\"" + CommandWord.QUIT + "\" : \"[]\" - " + CommandWord.QUIT
                        + " har ikke nogen sekundær kommando");
                // print command text
                ScreenWriter.print("\"" + CommandWord.QUIT + "\" får spilleren til at stoppe spillet.");
            } else if (secondCommand == CommandWord.STATS) {
                // Print header
                ScreenWriter.printCenterSpecial(secondCommand.toString().toUpperCase(), '-');
                // Print command view
                ScreenWriter.printCenter("\"" + CommandWord.STATS + "\" : \"[]\" - " + CommandWord.STATS
                        + " har ikke nogen sekundær kommando");
                // print command text
                ScreenWriter.print("\"" + CommandWord.STATS
                        + "\", printer alle spillerens nuværende statistiske variabler" + "til skærmen.");
            } else if (secondCommand == CommandWord.UPGRADE) {
                // Print header
                ScreenWriter.printCenterSpecial(secondCommand.toString().toUpperCase(), '-');
                // Print command view
                ScreenWriter.printCenter("\"" + CommandWord.UPGRADE + "\" : \"[ 1, 2 ]\"");
                // print command text
                ScreenWriter
                        .print("\"" + CommandWord.UPGRADE + "\", lader dig vælge imellem de forskellige opgraderinger"
                                + " til spillet. Tager tager hvad for en opgradering der ønskes som input.");
            } else if (secondCommand == CommandWord.UNKNOWN) {
                ScreenWriter.print("I like your fancy words, magic man!");
            } else if (secondCommand == CommandWord.HELP) {
                // Print header
                ScreenWriter.printCenterSpecial(secondCommand.toString().toUpperCase(), '-');
                // Print command view
                ScreenWriter.printCenter("\"" + CommandWord.HELP + "\" : \"[kommando, ]\" - tager både "
                        + "et og ikke et sekundært input");
                // print command text
                ScreenWriter.print("\"" + CommandWord.HELP + "\" giver en oversigt over mulige kommandoer hvis et "
                        + "sekundært input ikke er specificeret. Hvis et input er specificeret, giver denne kommando "
                        + "en beskrivelse af input kommandoen.");
            }
        }
    }

    /**
     * Method to go from door to door. It uses the com.zuul.application.rooms.Room class to
     * decide whether the current selected room exists. If it does sets currentRoom
     * to be the selected room.
     *
     * @param command com.zuul.application.Command used to go to next room.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            ScreenWriter.print("Hvor vil du hen?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = this.currentRoom.getExit(direction);

        if (nextRoom == null) {
            ScreenWriter.print(
                    "Du kunne ikke finde hvad du ledte efter, og besluttede dig for at vende tilbage til hvor du kom fra.");
        } else {
            this.currentRoom = nextRoom;
            ScreenWriter.print(this.currentRoom.getLongDescription());
        }
    }

    /**
     * Method to select upgrade and uses the com.zuul.application.Parser class to record which
     * upgrade to select.
     */
    private void selectUpgrade(UpgradeRoom room, Command command) {
        if ((room.upgradePathProducts == null || room.upgradePathProducts.upgrades == null
                || room.upgradePathProducts.upgrades.length == 0)
                || (room.upgradePathUsage == null || room.upgradePathUsage.upgrades == null
                        || room.upgradePathUsage.upgrades.length == 0)) {
            // throw new Exception("Error: Upgrades is NULL");
            ScreenWriter.print("Error: Upgrades is NULL");
        }

        UpgradePath upgradePathProducts = room.upgradePathProducts;
        UpgradePath upgradePathUsage = room.upgradePathUsage;

        String upgradePath = command.getSecondWord();

        if (upgradePath == null) {
            return;
        }

        if (upgradePath.equals("1")) {
            if (upgradePathProducts.performUpgrade()) {
                ScreenWriter.print("Du har opgraderet til level: " + upgradePathProducts.getCurrentLevel());
                room.setCombinedProduction();
            } else {
                ScreenWriter.print("Det var ikke muligt at opgradere.");
            }
        } else if (upgradePath.equals("2")) {
            if (upgradePathUsage.performUpgrade()) {
                ScreenWriter.print("Du har opgraderet til level: " + upgradePathUsage.getCurrentLevel());
                room.setCombinedProduction();
            } else {
                ScreenWriter.print("Det var ikke muligt at opgradere.");
            }
        } else {
            ScreenWriter.print("Der var ikke nogle tilknyttede opgraderinger i " + upgradePath);
            return;
        }
    }

    /**
     * Method to go to the next turn. Used to set the combined production of the
     * different facilities into the player's score and checks whether the game ends
     * or not.
     * 
     * @param command Doesn't use command parameter currently.
     */
    public void goTurn(Command command) {
        matas.setCombinedProduction();
        laundry.setCombinedProduction();
        cardealer.setCombinedProduction();
        dock.setCombinedProduction();

        double currentTotalPlasticProduction = matas.combinedProduction + laundry.combinedProduction
                + cardealer.combinedProduction + dock.combinedProduction;

        GameStats.SimulateTurn(1, currentTotalPlasticProduction);

        if (GameStats.fishInOcean <= 0) {
            wantToQuit = true;
        } else {
            GameStats.printStats();
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            ScreenWriter.print("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
