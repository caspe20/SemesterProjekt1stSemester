package com.zuul.application;

import com.zuul.application.rooms.*;
import com.zuul.presentation.controllers.Controller;
import com.zuul.presentation.controllers.StartMenuController;
import com.zuul.presentation.controllers.UpgradeRoomController;
import com.zuul.presentation.controllers.DevilsRoomController;
import com.zuul.presentation.Wrapper;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;

public class Game extends Application {
    private static DevilsRoomController devilsRoomController;
    // Presentation layer's location
    String presentationLocation = "../presentation/";
    // Scene variables
    public static Stage primaryStage;
    public HashMap<String, Scene> scenes = new HashMap<>();
    public HashMap<String, Object> controllers = new HashMap<>();
    // Room structure variables
    public static Room currentRoom;
    public static UpgradeRoom currentUpgradeRoom;
    private Room devilheadquater;
    public static UpgradeRoom matas, laundry, cardealer, dock;
    // Name of the game
    private final String gameName = "Hades' Manglende Fisk";

    /**
     * Creates rooms and makes the game ready to play
     */
    public Game() {
        createRooms();
    }

    /**
     * Makes the game ready to play. Invokes the launch function from JavaFXM
     *
     * @param args
     */
    public static void main(String[] args) {
        devilsRoomController = new DevilsRoomController();
        launch(args);
    }

    /**
     * Overwrites the standard start function for JavaFXML
     * Make the game window and load its assets (scenes and controllers)
     *
     * @param primaryStage FXML application calls start on startup with primarystage as argument.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Make window
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Fisk til Hades");
        primaryStage.show();
        primaryStage.setResizable(false);
        // update wrapper
        Wrapper.setGame(this);
        // Get loaders for each room
        FXMLLoader[] loader = new FXMLLoader[]{
                new FXMLLoader(getClass().getResource(presentationLocation + "StartMenu.fxml")),
                new FXMLLoader(getClass().getResource(presentationLocation + "DevilRoom.fxml")),
                new FXMLLoader(getClass().getResource(presentationLocation + "UpgradeRoom.fxml"))
        };

        // Load controllers and scenes
        // scenes["startMenu"]: scene(startmenu)
        // scenes["DevilRoom"]: scene(devilsroom)
        // scenes["Martins UI2"]: scene(martinUI)
        scenes.put("StartMenu", new Scene(loader[0].load()));
        scenes.put("DevilRoom", new Scene(loader[1].load()));
        scenes.put("UpgradeRoom", new Scene(loader[2].load()));
        // controller["startMenu"]: controller(startmenu)
        // controller["DevilRoom"]: controller(devilsroom)
        // controller["Martins UI2"]: controller(martinUI)
        controllers.put("StartMenu", loader[0].getController());
        controllers.put("DevilRoom", loader[1].getController());
        controllers.put("UpgradeRoom", loader[2].getController());

        // Change scene to scene 1
        changeScene("StartMenu");
    }

    /**
     * Function for a game timer, such that the program can run with real-time screeb updates
     */
    public static void StartTimer() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(50),
                ae -> GameTick())); // Creates tick every 50 miliseconds or ca. 20 ticks a second
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Calls this function every game tick.
     */
    public static void GameTick() {
        GameStats.SimulateTurn(50d / 12000d);
        Wrapper.writeStatistics(new String[]{GameStats.getYear(), GameStats.getPlasticProduction(), GameStats.getPlastic(), GameStats.getFish()});
        calculateProgress();
    }

    /**
     * Changes the current scene
     *
     * @param scene String that denotes the scene and controller to change to
     * @throws Exception
     */
    public void changeScene(String scene) {
        Controller controller = (Controller) controllers.get(scene);

        // Change controllers to the valid type
        if (controller instanceof StartMenuController) {
            Wrapper.setStartMenuController((StartMenuController) controller);
        } else if (controller instanceof DevilsRoomController) {
            Wrapper.setDevilsRoomController((DevilsRoomController) controller);
        } else {
            Wrapper.setUpgradeRoomController((UpgradeRoomController) controller);
        }
        primaryStage.setScene(scenes.get(scene));
    }

    public static void calculateProgress() {
        double totalProgress = Math.sin(0.5 * Math.PI * (1 - ((double) GameStats.fishInOcean / GameStats.fishInOceanBeginning)));
        Wrapper.setProgressBar(totalProgress);
        System.out.println(100 * totalProgress);
        if (0.001 > (totalProgress * 100)) {
            Wrapper.setUserDescription("Well, what do we have here? Fresh new meat that wishes to serve the master of the underworld? Well then, welcome to my domain, my faithful servant! I do not tolerate failure, now go get me the fish souls I need to end the world!");
        }
        else if (0.01 > (totalProgress * 100)) {
            Wrapper.setUserDescription("You think you are good because you threw candy wrapper in the harbor once a year? Think again, pewny servant. You're just an amateur like everyone else! Come back when I see some proper progress. You disappoint me.");
        }
        else if (1 > (totalProgress * 100)) {
            Wrapper.setUserDescription("I can see you have ambition in you, servant. Do you also vision the world as a dead place? Now, that's enough positive feedback. Waste more microplastics, you imbecill!");
        }
        else if (10 > (totalProgress * 100)) {
            Wrapper.setUserDescription("So you are actually making an effort killing all the fish? Hmm.. Yes.. This is good. Yes. Keep it up, I need more souls in my collection. Give me floating mountains of microplastics! I will not settle for less.");
        }
        else if (25 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription("I can see you are well on your way polluting the world's oceans! Your small sprinkles of microplastics eventually turn in to heaps of poisonous fish food. Keep up the good work, my servant!");
        }
        else if (35 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription("I suppose you're asking for a raise at this point? As long as you don't unionize with the other polluters, I'll give you a 0.1% raise and a goat? You deserve it! Do we have a deal? *spits in hand and goes for a shake*");
        }
        else if (50 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription("Why hello there, my hero of toxic waste! You are doing a fine job providing me with souls. Go get that toothpaste from Matas and show the fish you mean serious business!");
        }
        else if (75 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription("Oh. My. God. You are doing work of wonders here! Half of the fish in the ocean have been killed, and all thanks to you. You're spreading microplastics like a maniac with your irresponsibility.  ");
        }
        else if (100 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription("This is insane. There are only 25% fish left in the ocean, you outperform even the biggest of polluters. I bow to you, my servant!");
        }
        else {
            Wrapper.setUserDescription("That's it. You've officially killed all the fish in the ocean with your microplastics. No more souls for me, and no more fish for you! Are you happy now? That's a win, I suppose. Congrats, the world is now a dead place!");
        }
    }


    /**
     * Creates the world in the game
     */
    private void createRooms() {
        devilheadquater = new DevilsRoom("Djævlens Hovedkvarter",
                "Velkommen i Djævlens' hovedkvarter");

        matas = new UpgradeRoom("Matas",
                "Velkommen til Matas! Her kan du købe en masse forskellige produkter " +
                        "som er fyldt med den fineste mikroplast. Brug dine produkter så ofte som " +
                        "muligt, så al mikroplastikken kan blive skyllet ud i havet og udslette en masse fisk",
                new UpgradePath("Product",
                        new Upgrade[]{
                                new Upgrade("svanemærkede produkter", 0.0, 5.0),
                                new Upgrade("håndsæbe", 10.0, 10.0),
                                new Upgrade("shampoo", 50.0, 15.0),
                                new Upgrade("balsam", 250.0, 25.0),
                                new Upgrade("face scrub cream", 1000.0, 35.0),
                                new Upgrade("barberskum", 5000.0, 50.0),
                                new Upgrade("mascara", 20000.0, 75.0),
                                new Upgrade("foundation", 75000.0, 125.0),
                                new Upgrade("lip gloss", 300000.0, 200.0),
                                new Upgrade("clean laundry bod", 1000000.0, 300.0),
                                new Upgrade("concealer", 4000000.0, 500.0),
                                new Upgrade("footscrub", 8000000.0, 750.0),
                                new Upgrade("self tan bronzing cream", 20000000.0, 1500.0),
                                new Upgrade("glimmer", 50000000.0, 2500.0),
                                new Upgrade("tandpasta", 100000000.0, 4000.0)
                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[]{
                                new Upgrade("1 gang om året", 10.0, 10.0),
                                new Upgrade("2 gange om året", 50.0, 15.0),
                                new Upgrade("1 gang i kvartalet", 250.0, 25.0),
                                new Upgrade("1 gang om måneden", 1000.0, 35.0),
                                new Upgrade("2 gange om måneden", 5000.0, 50.0),
                                new Upgrade("1 gang om ugen", 20000.0, 75.0),
                                new Upgrade("2 gange om ugen", 75000.0, 125.0),
                                new Upgrade("1 gang om dagen", 300000.0, 200.0),
                                new Upgrade("2 gange om dagen", 1000000.0, 300.0),
                                new Upgrade("3 gange om dagen", 4000000.0, 500.0),
                                new Upgrade("4 gange om dagen", 9000000.0, 800.0),
                                new Upgrade("6 gange om dagen", 20000000.0, 1750.0),
                                new Upgrade("1 gang i timen", 75000000.0, 3000.0),
                                new Upgrade("1 gang i kvarteret", 250000000.0, 6000.0),
                                new Upgrade("hele tiden", 0.0, 5.0)
                        }));

        cardealer = new UpgradeRoom("Bilforhandler",
                "Velkommen til Bilforhandleren! Her kan du udskifte dit køretøj. Vælg nu et rigtig tungt" +
                        "køretøj med mange hestekrafter og rigtig brede dæk. BRÆND GUMMI AF! Alle de fine plastikpartikler" +
                        "fra dækslitagen svæver med vinden til de store have.",
                new UpgradePath("Product",
                        new Upgrade[]{
                                new Upgrade("går på bare fødder", 0.0, 0.0),
                                new Upgrade("går i sneaks", 5.0, 10.0),
                                new Upgrade("kører på skateboard", 30.0, 20.0),
                                new Upgrade("kører på cykel", 150.0, 40.0),
                                new Upgrade("bruger offentlig transport", 500.0, 80.0),
                                new Upgrade("kører Volkswagen UP", 2500.0, 120.0),
                                new Upgrade("kører Ford Focus", 12500.0, 150.0),
                                new Upgrade("kører Mercedes CLA", 50000.0, 225.0),
                                new Upgrade("kører Ferrari", 300000.0, 300.0),
                                new Upgrade("kører Lamborghini", 1000000.0, 400.0),
                                new Upgrade("kører lastbil", 5000000.0, 500.0),
                                new Upgrade("kører monstertruck", 2500000.0, 600.0)
                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[]{
                                new Upgrade("0 km om uge", 0.0, 0.0),
                                new Upgrade("5 km om ugen", 50.0, 10.0),
                                new Upgrade("10 km om ugen", 200.0, 20.0),
                                new Upgrade("20 km om ugen", 800.0, 30.0),
                                new Upgrade("40 km om ugen", 4000.0, 50.0),
                                new Upgrade("60 km om ugen", 20000.0, 75.0),
                                new Upgrade("80 km om ugen", 60000.0, 100.0),
                                new Upgrade("100 km om ugen", 300000.0, 150.0),
                                new Upgrade("125 km om ugen", 800000.0, 250.0),
                                new Upgrade("150 km om ugen", 2500000.0, 500.0),
                                new Upgrade("175 km om ugen", 7500000.0, 1000.0),
                                new Upgrade("200 km om ugen", 15000000.0, 2000.0),
                                new Upgrade("250 km om ugen", 35000000.0, 4000.0),
                                new Upgrade("300 km om ugen", 70000000.0, 7500.0),
                                new Upgrade("400 km om ugen", 200000000.0, 15000.0)
                        }));

        // Mangler Hvad der skal vaskes.
        laundry = new UpgradeRoom("Vaskeriet",
                "Velkommen til Vaskeriet! Find din smartphone frem og køb en masse syntetisk tøj fra " +
                        "fjerne lande mens du venter på dit vasketøj. Husk ekspreslevering! Vask dit tøj så ofte som " +
                        "overhovedet muligt, så al mikroplastikken kan blive skyllet ud i havet og udslette en masse fisk",
                new UpgradePath("Product",
                        new Upgrade[]{
                                new Upgrade("vasker dine fødder", 0.0, 3.0),
                                new Upgrade("vasker dine sokker", 10.0, 6.0),
                                new Upgrade("vasker dine underbukser", 30.0, 12.0),
                                new Upgrade("vasker din hue", 90.0, 25.0),
                                new Upgrade("vasker dine vanter", 270.0, 50.0),
                                new Upgrade("vasker dit halstørklæde", 810.0, 100.0),
                                new Upgrade("vasker din T-shirt", 2430.0, 150.0),
                                new Upgrade("vasker dine langærmet T-shirt", 7290.0, 300.0),
                                new Upgrade("vasker dine shorts", 21870.0, 500.0),
                                new Upgrade("vasker dine lange bukser", 65610.0, 750.0),
                                new Upgrade("vasker din trøje", 196830.0, 1250.0),
                                new Upgrade("vasker dit kostume", 590490.0, 3000.0),
                                new Upgrade("vasker din jakke", 1771470.0, 6000.0),
                                new Upgrade("vasker dine skibukser", 5314410.0, 10000.0),
                                new Upgrade("vasker din flyverdragt", 15943230.0, 25000.0)
                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[]{
                                new Upgrade("1 gang om året", 0.0, 0.0),
                                new Upgrade("2 gange om året", 10.0, 5.0),
                                new Upgrade("4 gange om året", 20.0, 10.0),
                                new Upgrade("1 gang om måneden", 40.0, 15.0),
                                new Upgrade("2 gange om måneden", 80.0, 20.0),
                                new Upgrade("3 gange om måneden", 160.0, 25.0),
                                new Upgrade("1 gang om ugen", 320.0, 30.0),
                                new Upgrade("2 gange om ugen", 640.0, 40.0),
                                new Upgrade("3 gange om ugen", 1280.0, 50.0),
                                new Upgrade("4 gange om ugen", 2560.0, 75.0),
                                new Upgrade("5 gange om ugen", 5120.0, 100.0),
                                new Upgrade("6 gange om ugen", 10240.0, 125.0),
                                new Upgrade("1 gang om dagen", 20480.0, 175.0),
                                new Upgrade("2 gange om dagen", 40960.0, 250.0),
                                new Upgrade("4 gange om dagen", 81920.0, 300.0)
                        }));

        dock = new UpgradeRoom("Molen",
                "Velkommen ved Molen! Bare smid alt dit plastikaffald direkte i vandet. Bare rolig! I havet " +
                        "bliver det nedbrudt meget langsomt, men når først de store plastikstykker er blevet til små partikler, vil " +
                        "de slå en masse fisk ihjel.",
                new UpgradePath("Product",
                        new Upgrade[]{
                                new Upgrade("kaster brødkrummer i havnen", 0.0, 0.0),
                                new Upgrade("kaster sugerør i havnen", 10.0, 20.0),
                                new Upgrade("kaster slikpapir i havnen", 50.0, 80.0),
                                new Upgrade("kaster plastikflasker i havnen", 300.0, 120.0),
                                new Upgrade("kaster plastikposer i havnen", 1500.0, 200.0),
                                new Upgrade("kaster actionman i havnen", 5000.0, 300.0),
                                new Upgrade("kaster vandkander i havnen", 30000.0, 450.0),
                                new Upgrade("kaster IKEA-kasser i havnen", 80000.0, 600.0),
                                new Upgrade("kaster badeflamingo i havnen", 400000.0, 750.0),
                                new Upgrade("kaster bildæk i havnen", 2000000.0, 900.0),
                                new Upgrade("kaster presenning i havnen", 10000000.0, 1200.0),
                                new Upgrade("kaster rutchebaner i havnen", 50000000.0, 1500.0),
                                new Upgrade("kaster havetrampoliner i havnen", 25000000.0, 1750.0),
                                new Upgrade("kaster kayaker i havnen", 100000000.0, 2000.0),
                                new Upgrade("kaster havepools i havnen", 300000000.0, 2500.0)
                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[]{
                                new Upgrade("1 gang om året", 50.0, 5.0),
                                new Upgrade("2 gange om året", 250.0, 10.0),
                                new Upgrade("1 gang i kvartalet", 1000.0, 20.0),
                                new Upgrade("1 gang om måneden", 4000.0, 30.0),
                                new Upgrade("2 gange om måneden", 16000.0, 40.0),
                                new Upgrade("1 gang om ugen", 64000.0, 60.0),
                                new Upgrade("2 gange om ugen", 256000.0, 90.0),
                                new Upgrade("1 gang om dagen", 1000000.0, 150.0),
                                new Upgrade("2 gange om dagen", 5000000.0, 250.0),
                                new Upgrade("3 gange om dagen", 15000000.0, 400.0),
                                new Upgrade("4 gange om dagen", 45000000.0, 900.0),
                                new Upgrade("6 gange om dagen", 150000000.0, 2700.0),
                                new Upgrade("1 gang i timen", 450000000.0, 3300.0),
                                new Upgrade("1 gang i kvarteret", 1000000000.0, 8000.0),
                                new Upgrade("hele tiden", 0.0, 0.0)
                        }));

        currentRoom = devilheadquater;

    }

    public static String getRoomDescription() {
        return currentRoom.getRoomDescription();
    }

    public static String getRoomName() {
        return currentRoom.getRoomName();

    }


    public void setRoomToMatas() {
        currentRoom = matas;
        //currentUpgradeRoom = matas;
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
        }
    }

    public void setRoomToCardealer() {
        currentRoom = cardealer;
        //currentUpgradeRoom = cardealer;
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
        }
    }

    public void setRoomToLaundry() {
        currentRoom = laundry;
        //currentUpgradeRoom = laundry;
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
        }
    }

    public void setRoomToDock() {
        currentRoom = dock;
        //currentUpgradeRoom = dock;
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
        }
    }

    public void setRoomToDevil() {
        currentRoom = devilheadquater;
        try {
            changeScene("DevilRoom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] getUpdateUpgradeUIInfo() {
        UpgradeRoom UR = (UpgradeRoom) Game.currentRoom;
        double productCurrent = UR.getUpgradePathProducts().getCurrentProduction();
        double productUpgrade = UR.getUpgradePathProducts().getUpgradeProduction();
        double usageCurrent = UR.getUpgradePathUsage().getCurrentProduction();
        double usageUpgrade = UR.getUpgradePathUsage().getUpgradeProduction();

        // production text
        String product1 = "[" + productCurrent + "]" + " * " + usageCurrent + " = " + (productCurrent * usageCurrent);
        String usage1 = productCurrent + " * " + "[" + usageCurrent + "]" + " = " + (productCurrent * usageCurrent);
        String product2 = "", usage2 = "";

        // Check whether upgrade is available for either upgrade path
        if (productUpgrade > 0) {
            product2 = "[" + productUpgrade + " ] " + " * " + usageCurrent + " = " + (productUpgrade * usageCurrent);
        }

        if (usageUpgrade > 0) {
            usage2 = productCurrent + " * " + "[" + usageUpgrade + "]" + " = " + (productCurrent * usageUpgrade);
        }

        // [0] : 1st Upgrade Button Description
        // [1] : 2nd Upgrade Button Description
        // [2] : 1st Upgrade one description
        // [3] : 1st Upgrade two description
        // [4] : 1st upgrade label1 description
        // [5] : 1st upgrade label2 description
        // [6] : 2nd Upgrade one description
        // [7] : 2nd Upgrade two description
        // [8] : 2nd upgrade label description
        // [9] : 2nd upgrade label2 description
        String[] out = new String[]{
                UR.getUpgradePathProducts().getUpgradeButtonDescription(),  // 0
                UR.getUpgradePathUsage().getUpgradeButtonDescription(),     // 1
                UR.getUpgradePathProducts().getUpgradeOneDescription(),     // 2
                UR.getUpgradePathProducts().getUpgradeTwoDescription(),     // 3
                product1,                                                   // 4
                product2,                                                   // 5
                UR.getUpgradePathUsage().getUpgradeOneDescription(),        // 6
                UR.getUpgradePathUsage().getUpgradeTwoDescription(),        // 7
                usage1,                                                     // 8
                usage2,                                                     // 9
        };
        return out;
    }





}