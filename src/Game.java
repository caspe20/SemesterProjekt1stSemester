public class Game {
    private Parser parser;
    private Room currentRoom;
    public TurnCounter turncounter;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Creates the world in the game
     */
    private void createRooms() {
        Room devilheadquater, matas, laundry, cardealer, dock;
        turncounter = new TurnCounter(2000, 0);

        devilheadquater = new DevilsRoom("in Devil's Headquater", turncounter);

        matas = new Room("in Matas");
        laundry = new Room("in the Laundry");
        cardealer = new Room("in the car dealership");
        dock = new Room("at the dock");

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
        // This is a note for the team. Since CommandWord.UNKNOWN
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
            System.out.println(turncounter.getYear());
        } else if (commandWord == CommandWord.UPGRADE){

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
     * Method to go from door to door. It uses the Room class to decide whether the
     * current selected room exists. If it does sets currentRoom to be the selected
     * room.
     * 
     * @param command Command used to go to next room.
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
     * Method to select upgrade and uses the Parser class to record which upgrade to
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
        // Upgrade[] upgrades = room.upgradePathQuantity.upgrades;

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
        // Command command = parser.getCommand();
        //
        // // Process "UPGRADE #"
        // if(command.getCommandWord() == CommandWord.UPGRADE) {
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
        // }else if (command.getCommandWord() == CommandWord.BACK){
        // System.out.println(room.getLongDescription());
        // break;
        // }else{
        // System.out.println("Please select a valid command word at this time.");
        // System.out.println();
        // System.out.println("Commands:");
        // System.out.println(CommandWord.UPGRADE.toString() + " " +
        // CommandWord.BACK.toString());
        // System.out.println();
        // continue;
        // }
        //
    }

    public void goTurn(Command command) {
        turncounter.SimulateTurn(1);
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
