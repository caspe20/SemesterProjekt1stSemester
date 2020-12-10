package com.zuul.application;

import com.zuul.application.rooms.*;
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
    // Presentation layer's location
    String presentationLocation = "../presentation/";

    // Scene variables
    private static Stage primaryStage;
    public static HashMap<String, Scene> scenes = new HashMap<>();
    public static HashMap<String, Object> controllers = new HashMap<>();

    // Room structure variables
    private static Room currentRoom;
    private Room devilheadquater;
    public static UpgradeRoom matas, laundry, cardealer, dock;
    public static Timeline timeline;

    /*
     * Game creation
     */

    /**
     * Creates rooms and makes the game ready to play
     */
    public Game() {
        createRooms();
    }

    /**
     * Makes the game ready to play. Invokes the launch function from JavaFXM
     * @param args main args
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Game.primaryStage = primaryStage;
    }

    public static Room getCurrentRoom() {
        return currentRoom;
    }

    public static void setCurrentRoom(Room currentRoom) {
        Game.currentRoom = currentRoom;
    }

    /**
     * Overwrites the standard start function for JavaFXML Make the game window and
     * load its assets (scenes and controllers)
     * @param primaryStage FXML application calls start on startup with primary stage as argument.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Make window
        Game.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Fisk til Hades");
        primaryStage.show();
        primaryStage.setResizable(false);
        // update wrapper
        Wrapper.setGame(this);
        // Get loaders for each room
        FXMLLoader[] loader = new FXMLLoader[] {
                new FXMLLoader(getClass().getResource(presentationLocation + "StartMenu.fxml")),
                new FXMLLoader(getClass().getResource(presentationLocation + "DevilRoom.fxml")),
                new FXMLLoader(getClass().getResource(presentationLocation + "UpgradeRoom.fxml")),
                new FXMLLoader(getClass().getResource(presentationLocation + "EndScreen.fxml"))
        };

        // Load scenes into map
        scenes.put("StartMenu", new Scene(loader[0].load()));
        scenes.put("DevilRoom", new Scene(loader[1].load()));
        scenes.put("UpgradeRoom", new Scene(loader[2].load()));
        scenes.put("EndScreen", new Scene(loader[3].load()));

        // load controllers into wrapper
        Wrapper.setControllers(
                loader[0].getController(),
                loader[1].getController(),
                loader[2].getController(),
                loader[3].getController()
        );

        // Change scene to scene 1
        changeScene("StartMenu");
        updateStartScreenDescription();
    }

    /**
     * Function for a game timer, such that the program can run with real-time
     * screeb updates
     */
    public static void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> gameTick())); // Creates tick every 50
                                                                                               // miliseconds or ca. 20
                                                                                               // ticks a second
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void endTimer() {
        timeline.stop();
    }


    /**
     * Calls this function every game tick.
     */
    public static void gameTick() {
        GameStats.simulateTurn(50d / 12000d);
        Wrapper.writeStatistics(GameStats.getTime(), GameStats.getPlasticProduction(), GameStats.getPlastic(),
                GameStats.getFish());
        calculateProgress();
    }

    /**
     * Changes the current scene
     *
     * @param scene String that denotes the scene and controller to change to
     */
    public static void changeScene(String scene) {
        getPrimaryStage().setScene(scenes.get(scene));
    }

    /*
     * UI section
     */

    /**
     * Calculates the progressbar and sends the information to the view
     */
    public static void calculateProgress() {
        double totalProgress = Math
                .sin(0.5 * Math.PI * (1 - ((double) GameStats.getFishInOcean() / GameStats.getFishInOceanBeginning())));
        Wrapper.setProgressBar(totalProgress);
        if (0.001 > (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Nå, hvad har vi så her? Nyt frisk kød der ønsker at tjene underverdenens hersker? Jamen, så velkommen til mit domæne, min trofaste tjener! Jeg tolererer ikke fiasko, så giv mig nu de fiskesjæle, jeg har brug for, for at få et hav uden liv!");
        } else if (0.01 > (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Du synes, du er god, fordi du smed slikindpakning i havnen en gang om året? Tænk igen, lille  tjener. Du er bare en amatør som alle andre! Kom tilbage, når jeg ser nogle ordentlige fremskridt. Du skuffer mig.");
        } else if (1 > (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Jeg kan se, at du har ambitioner, tjener. Ser du også verden som et dødt sted? Nu er det nok med positiv feedback. Spild mere mikroplast, din imbecil!");
        } else if (10 > (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Så du bestræber dig faktisk på at dræbe alle fiskene? Hmm .. Ja .. Det er godt. Ja. Fortsæt, jeg har brug for flere sjæle i min samling. Giv mig flydende bjerge af mikroplast! Jeg tolererer intet mindre.");
        } else if (25 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Jeg kan se, at du er godt på vej med at forurene verdens have! Dine små drys af mikroplast ender som tonsvis af giftig fiskemad. Fortsæt det gode arbejde, min tjener!");
        } else if (35 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Jeg formoder, at du vil bede om en lønforhøjelse på dette tidspunkt? Så længe du ikke går med i forureningernes fagforening, giver jeg dig en forhøjelse på 0,1% og en ged. Du fortjener det! Har vi en aftale? * spytter i hånden og går ind for en shake *");
        } else if (50 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Jamen halløjsa, min helt af giftigt affald! Du gør et godt stykke arbejde, med at give mig sjæle. Køb nu den tandpasta fra Matas og vis fiskene, du mener serious business!");
        } else if (75 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Oh. My. God. Du gør underværker! Halvdelen af fiskene i havet er dræbt, og det er helt din fortjenste. Du spreder mikroplast som en galning med din uansvarlighed.");
        } else if (100 > (int) (totalProgress * 100)) {
            Wrapper.setUserDescription(
                    "Dette er sindssygt. Der er kun 25% fisk tilbage i havet, du er bedre end selv de største af forurenerne. Jeg bøjer mig i støvet, min tjener!");
        } else {
            endTimer();
            changeScene("EndScreen");
            updateEndScreenUI();
        }
    }

    /**
     * Gets the description of the current room
     *
     * @return current room description
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
                                new Upgrade("hele tiden", 600000000.0, 9000.0)
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
                                new Upgrade("400 km om ugen", 200000000.0, 15000.0),
                                new Upgrade("500 km om ugen", 350000000.0, 22500.0)
                        }));

        // Mangler Hvad der skal vaskes.
        laundry = new UpgradeRoom("Vaskeriet",
                "Velkommen til Vaskeriet! Find din smartphone frem og køb en masse syntetisk tøj fra " +
                        "fjerne lande mens du venter på dit vasketøj. Husk ekspreslevering! Vask dit tøj så ofte som " +
                        "overhovedet muligt, så al mikroplastikken kan blive skyllet ud i havet og udslette en masse fisk",
                new UpgradePath("Product",
                        new Upgrade[]{
                                new Upgrade("vasker fødder", 0.0, 3.0),
                                new Upgrade("vasker sokker", 10.0, 6.0),
                                new Upgrade("vasker underbukser", 30.0, 12.0),
                                new Upgrade("vasker hue", 90.0, 25.0),
                                new Upgrade("vasker vanter", 270.0, 50.0),
                                new Upgrade("vasker halstørklæde", 810.0, 100.0),
                                new Upgrade("vasker T-shirt", 2430.0, 150.0),
                                new Upgrade("vasker langærmet T-shirt", 7290.0, 300.0),
                                new Upgrade("vasker shorts", 21870.0, 500.0),
                                new Upgrade("vasker lange bukser", 65610.0, 750.0),
                                new Upgrade("vasker trøje", 196830.0, 1250.0),
                                new Upgrade("vasker kostume", 590490.0, 3000.0),
                                new Upgrade("vasker jakke", 1771470.0, 5000.0),
                                new Upgrade("vasker skibukser", 5314410.0, 9000.0),
                                new Upgrade("vasker flyverdragt", 15943230.0, 13500.0)
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
                                new Upgrade("4 gange om dagen", 81920.0, 300.0),
                                new Upgrade("5 gange om dagen", 163840.0, 350.0),
                                new Upgrade("hver anden time", 327680.0, 400.0),
                                new Upgrade("hver time", 655360.0, 500.0)
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
                                new Upgrade("1 gang i timen", 350000000.0, 3300.0),
                                new Upgrade("1 gang i kvarteret", 800000000.0, 8000.0),
                                new Upgrade("hele tiden", 1234567890.0, 17500.0)
                        }));
    }

    public static String getRoomDescription() {
        return getCurrentRoom().getRoomDescription();
    }

    /**
     * gets the room name of the current room
     *
     * @return current room name
     */
    public static String getRoomName() {
        return getCurrentRoom().getRoomName();

    }

    /**
     * Sets the current room to matas and updates rooms to reflect it
     */
    public void setRoomToMatas() {
        setCurrentRoom(matas);
        // currentUpgradeRoom = matas;
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the current room to car dealer and updates rooms to reflect it
     */
    public void setRoomToCardealer() {
        setCurrentRoom(cardealer);
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the current room to laundry and updates rooms to reflect it
     */
    public void setRoomToLaundry() {
        setCurrentRoom(laundry);
        // currentUpgradeRoom = laundry;
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the current room to dock and updates rooms to reflect it
     */
    public void setRoomToDock() {
        setCurrentRoom(dock);
        // currentUpgradeRoom = dock;
        try {
            changeScene("UpgradeRoom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the current room to devil and updates rooms to reflect it
     */
    public void setRoomToDevil() {
        setCurrentRoom(devilheadquater);
        try {
            changeScene("DevilRoom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * function for updating the upgrade UI.
     */
    public static void updateUpgradePanelUI() {
        UpgradeRoom UR = (UpgradeRoom) Game.getCurrentRoom();
        double productCurrent = UR.getUpgradePathProducts().getCurrentProduction();
        double productUpgrade = UR.getUpgradePathProducts().getUpgradeProduction();
        double usageCurrent = UR.getUpgradePathUsage().getCurrentProduction();
        double usageUpgrade = UR.getUpgradePathUsage().getUpgradeProduction();
        String upgradeProductsPollution = "";
        String upgradeUsagePollution = "";

        // Check whether upgrade is available for either upgrade path
        if (productUpgrade > 0) {
            upgradeProductsPollution = "+ " + String.format("%.0f", (productUpgrade * usageCurrent)-(productCurrent * usageCurrent)) + " tons mikroplastik";
        }
        if (usageUpgrade > 0) {
            upgradeUsagePollution = "+ " + String.format("%.0f", (productCurrent * usageUpgrade)-(productCurrent * usageCurrent)) + " tons mikroplastik";
        }

        String button1 = UR.getUpgradePathProducts().getUpgradeButtonDescription();
        String button2 = UR.getUpgradePathUsage().getUpgradeButtonDescription();
        String label1 = UR.getUpgradePathProducts().getUpgradeOneDescription();
        String label2 = UR.getUpgradePathProducts().getUpgradeTwoDescription();
        String label3 = upgradeProductsPollution;
        String label4 = UR.getUpgradePathUsage().getUpgradeOneDescription();
        String label5 = UR.getUpgradePathUsage().getUpgradeTwoDescription();
        String label6 = upgradeUsagePollution;

        Wrapper.setUpgradePanelUI(button1, button2, label1, label2, label3, label4, label5, label6);
    }


    public static void updateDevilsRoomStats() {
        String label1 = "Production level: " + (Game.matas.upgradePathProducts.getCurrentLevel() + 1);
        String label2 = "Usage level: " + (Game.matas.upgradePathUsage.getCurrentLevel() + 1);
        String label3 = "Production level: " + (Game.cardealer.upgradePathProducts.getCurrentLevel() + 1);
        String label4 = "Usage level: " + (Game.cardealer.upgradePathUsage.getCurrentLevel() + 1);
        String label5 = "Production level: " + (Game.laundry.upgradePathProducts.getCurrentLevel() + 1);
        String label6 = "Usage level: " + (Game.laundry.upgradePathUsage.getCurrentLevel() + 1);
        String label7 = "Production level: " + (Game.dock.upgradePathProducts.getCurrentLevel() + 1);
        String label8 = "Usage level: " + (Game.dock.upgradePathUsage.getCurrentLevel() + 1);

        Wrapper.setDevilsRoomStats(label1, label2, label3, label4, label5, label6, label7, label8);
    }

    public static void updateDevilsRoomUserDescription() {
        String currentProductMatas = Game.matas.upgradePathProducts.getUpgrades()[Game.matas.upgradePathProducts.getCurrentLevel()].getUpgradeName();
        String currentProductCardealer = Game.cardealer.upgradePathProducts.getUpgrades()[Game.cardealer.upgradePathProducts.getCurrentLevel()].getUpgradeName();
        String currentProductLaundry = Game.laundry.upgradePathProducts.getUpgrades()[Game.laundry.upgradePathProducts.getCurrentLevel()].getUpgradeName();
        String currentProductDock = Game.dock.upgradePathProducts.getUpgrades()[Game.dock.upgradePathProducts.getCurrentLevel()].getUpgradeName();

        String currentUsageMatas = Game.matas.upgradePathUsage.getUpgrades()[Game.matas.upgradePathUsage.getCurrentLevel()].getUpgradeName();
        String currentUsageCardealer = Game.cardealer.upgradePathUsage.getUpgrades()[Game.cardealer.upgradePathUsage.getCurrentLevel()].getUpgradeName();
        String currentUsageLaundry = Game.laundry.upgradePathUsage.getUpgrades()[Game.laundry.upgradePathUsage.getCurrentLevel()].getUpgradeName();
        String currentUsageDock = Game.dock.upgradePathUsage.getUpgrades()[Game.dock.upgradePathUsage.getCurrentLevel()].getUpgradeName();
        
        String userDescription = ("➼ Vi bruger " + currentProductMatas + " " + currentUsageMatas + "\n" +
                                    "➼ Vi " + currentProductCardealer + " " + currentUsageCardealer + "\n" +
                                    "➼ Vi " + currentProductLaundry + " " + currentUsageLaundry + "\n" +
                                    "➼ Vi " + currentProductDock + " " + currentUsageDock);

        Wrapper.setDevilsRoomUserDescription(userDescription);
    }


    public static void updateEndScreenUI() {
        String currentProductMatas = Game.matas.upgradePathProducts.getUpgrades()[Game.matas.upgradePathProducts.getCurrentLevel()].getUpgradeName();
        String currentProductCardealer = Game.cardealer.upgradePathProducts.getUpgrades()[Game.cardealer.upgradePathProducts.getCurrentLevel()].getUpgradeName();
        String currentProductLaundry = Game.laundry.upgradePathProducts.getUpgrades()[Game.laundry.upgradePathProducts.getCurrentLevel()].getUpgradeName();
        String currentProductDock = Game.dock.upgradePathProducts.getUpgrades()[Game.dock.upgradePathProducts.getCurrentLevel()].getUpgradeName();

        String currentUsageMatas = Game.matas.upgradePathUsage.getUpgrades()[Game.matas.upgradePathUsage.getCurrentLevel()].getUpgradeName();
        String currentUsageCardealer = Game.cardealer.upgradePathUsage.getUpgrades()[Game.cardealer.upgradePathUsage.getCurrentLevel()].getUpgradeName();
        String currentUsageLaundry = Game.laundry.upgradePathUsage.getUpgrades()[Game.laundry.upgradePathUsage.getCurrentLevel()].getUpgradeName();
        String currentUsageDock = Game.dock.upgradePathUsage.getUpgrades()[Game.dock.upgradePathUsage.getCurrentLevel()].getUpgradeName();

        int yearsPlayed = GameStats.getYearsPlayed();
        int daysPlayed = GameStats.getDaysPlayed();

        String userDescription = ("Tillykke! Vi brugte " + yearsPlayed + " år og " + daysPlayed + " dage " +
                "på at slå alle fiskene ihjel med vores mikroplast" + "\n\n" +
                "Alle os mennesker på jorden... " + "\n" +
                "... bruger " + currentProductMatas + " " + currentUsageMatas + "\n" +
                "... " + currentProductCardealer + " " + currentUsageCardealer + "\n" +
                "... " + currentProductLaundry + " " + currentUsageLaundry + "\n" +
                "... " + currentProductDock + " " + currentUsageDock);

        Wrapper.setEndScreenUI(userDescription);
    }

     public static void updateUpgradeRoomDescription() {
         String roomDescription = getRoomDescription();
         String roomName = getRoomName();

         Wrapper.setUpgradeRoomDescription(roomName, roomDescription);
     }

    public static void updateStartScreenDescription() {
        String startDescription = "Velkommen til Djævlens' hovedkvarter. Djævlen lever af fiskesjæle. " +
                "En af de mest effektive måder at slå fisk ihjel, er ved at forurene havene " +
                "med mikroplast. De små plastikpartikler bliver optaget i havets fisk og " +
                "lægger hele økosystemer øde. Djævlen mæsker sig på sit kontor og grådig som han er, " +
                "har han udtænkt en plan, så han snart kan holde gilde for hele underverdenen. " +
                "Han har nemlig opdaget, at mennesker opfører sig meget forudsigeligt. De vil altid gøre det " +
                "som andre mennesker gør og de vil altid have det som andre mennesker har.\n\n" +
                "Du er i ledtog med djævlen. Din opgave er at bidrage med så meget mikroplastforurening " +
                "som overhovedet muligt. De andre mennesker vil gøre ligesom dig. For sådan er mennesker. " +
                "Skynd dig at vask en masse syntetisk tøj, smid plastik i havnen, brænd gummi af i din store bil " +
                "og brug en masser glimmer foran spejlet!";

        Wrapper.setStartScreenDescription(startDescription);
    }
}
