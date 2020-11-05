public class Game {
    private Parser parser;
    private Room currentRoom;
    public TurnCounter turncounter;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room devilheadquater, matas, laundry, cardealer, dock;
        turncounter = new TurnCounter(2000,0);

        devilheadquater = new DevilsRoom("in Devil's Headquater",turncounter);
        matas = new Room("in Matas");
        laundry = new Room("in the Laundry");
        cardealer = new Room("in the car dealership");
        dock = new Room("at the dock");

        devilheadquater.setExit("north", matas);
        devilheadquater.setExit("south", laundry);

        matas.setExit("south",devilheadquater);
        matas.setExit("east", cardealer);

        cardealer.setExit("west",matas);
        cardealer.setExit("south",dock);

        dock.setExit("north",cardealer);
        dock.setExit("west",laundry);

        laundry.setExit("north",devilheadquater);
        laundry.setExit("east",dock);

        currentRoom = devilheadquater;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.NEXTTURN) {
            goTurn(command);
            System.out.println(turncounter.getYear());
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

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
