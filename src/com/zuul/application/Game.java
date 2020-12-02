package com.zuul.application;

import com.zuul.application.rooms.*;
import com.zuul.presentation.Controller;
import com.zuul.presentation.Wrapper;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {
    String presentationLocation = "../presentation/";
    public static void main(String[] args) {
        launch(args);
    }

    public static Controller con;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(presentationLocation + "Martins UI2.fxml"));
        Parent root = loader.load();
        Wrapper.setController(((Controller)loader.getController()));
        Wrapper.setGame(this);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        StartTimer();

    }

    public static void StartTimer() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(50),
                ae -> GameTick()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void GameTick() {
        GameStats.SimulateTurn(50d/12000d);
        GameStats.getPlastic();
        Wrapper.writeStatistics(new String[]{GameStats.getYear(), String.valueOf(GameStats.plasticProduction) + " tons",GameStats.getPlastic(), GameStats.getFish()});
    }

    // Rest of code

    private static Room currentRoom;
    private Room devilheadquater;
    private UpgradeRoom matas, laundry, cardealer, dock;
    private double CurrentFishSouls = 0d;
    private boolean wantToQuit = false;
    private final String gameName = "Hades' Manglende Fisk";

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
//        ScreenWriter.printCenter("Skriv '" + CommandWord.HELP + "' hvis du har brug for hjælp");
        ScreenWriter.printCenterSpecial("Dag/uge/år/halvår/etc. " + GameStats.currentTurn, '-');
        ScreenWriter.print(currentRoom.getLongDescription());
    }

    public Game() {
        createRooms();
    }

    /**
     * Creates the world in the game
     */
    private void createRooms() {
        devilheadquater = new DevilsRoom("i Djævlens' hovedkvarter");

        matas = new UpgradeRoom("i Matas",
                new UpgradePath("Product",
                        new Upgrade[]{new Upgrade("Svanemærket", 0.0, 1.0), new Upgrade("Håndsæbe", 1.0, 2.0),
                                new Upgrade("Shampoo", 2.0, 3.0), new Upgrade("Balsam", 3.0, 4.0),
                                new Upgrade("Face Scrub Cream", 4.0, 5.0), new Upgrade("Barberskum", 5.0, 6.0),
                                new Upgrade("Mascara", 6.0, 7.0), new Upgrade("Foundation", 7.0, 8.0),
                                new Upgrade("Lip Gloss", 8.0, 9.0), new Upgrade("Clean Laundry bod", 9.0, 10.0),
                                new Upgrade("Concealer", 10.0, 11.0), new Upgrade("Footscrub", 11.0, 12.0),
                                new Upgrade("Self Tan Bronzing Cream", 12.0, 13.0), new Upgrade("Glimmer", 13.0, 14.0),
                                new Upgrade("Tandpasta", 14.0, 15.0)

                        }),
                new UpgradePath("Forbrug", new Upgrade[]{new Upgrade("Aldrig", 0.0, 1.0),
                        new Upgrade("1 gang om året", 1.0, 2.0), new Upgrade("2 gange om året", 2.0, 3.0),
                        new Upgrade("1 gang i kvartalet", 3.0, 4.0), new Upgrade("1 gang om måneden", 4.0, 5.0),
                        new Upgrade("2 gange om måneden", 5.0, 6.0), new Upgrade("1 gang om ugen", 6.0, 7.0),
                        new Upgrade("2 gange om ugen", 7.0, 8.0), new Upgrade("1 gang om dagen", 8.0, 9.0),
                        new Upgrade("2 gange om dagen", 9.0, 10.0), new Upgrade("3 gange om dagen", 10.0, 11.0),
                        new Upgrade("4 gange om dagen", 11.0, 12.0), new Upgrade("6 gange om dagen", 12.0, 13.0),
                        new Upgrade("1 gang i timen", 13.0, 14.0), new Upgrade("1 gang i kvarteret", 14.0, 15.0)

                }));
        // Mangler Hvad der skal vaskes.
        laundry = new UpgradeRoom("ved Vaskeriet",
                new UpgradePath("Product",
                        new Upgrade[]{new Upgrade("Bare fødder", 0.0, 1.0), new Upgrade("Sokker", 1.0, 2.0),
                                new Upgrade("Underbukser", 2.0, 3.0), new Upgrade("Hue", 3.0, 4.0),
                                new Upgrade("Vanter", 4.0, 5.0), new Upgrade("Halstørklæde", 5.0, 6.0),
                                new Upgrade("T-shirt", 6.0, 7.0), new Upgrade("Langærmet T-shirt", 7.0, 8.0),
                                new Upgrade("Shorts", 8.0, 9.0), new Upgrade("Lange Bukser", 9.0, 10.0),
                                new Upgrade("Trøje", 10.0, 11.0), new Upgrade("Kostume", 11.0, 12.0),
                                new Upgrade("Jakke", 12.0, 13.0), new Upgrade("Skibukser", 13.0, 14.0),
                                new Upgrade("Flyverdrakt", 14.0, 15.0)

                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[]{new Upgrade("Aldrig", 0.0, 1.0), new Upgrade("2 gange om året", 1.0, 2.0),
                                new Upgrade("4 gange om året", 2.0, 3.0), new Upgrade("1 gang om måneden", 3.0, 4.0),
                                new Upgrade("2 gange om måneden", 4.0, 5.0),
                                new Upgrade("3 gange om måneden", 5.0, 6.0), new Upgrade("1 gang om ugen", 6.0, 7.0),
                                new Upgrade("2 gange om ugen", 7.0, 8.0), new Upgrade("3 gange om ugen", 8.0, 9.0),
                                new Upgrade("4 gange om ugen", 9.0, 10.0), new Upgrade("5 gange om ugen", 10.0, 11.0),
                                new Upgrade("6 gange om ugen", 11.0, 12.0), new Upgrade("1 gang om dagen", 12.0, 13.0),
                                new Upgrade("2 gange om dagen", 13.0, 14.0), new Upgrade("4 gange om dagen", 14.0, 15.0)

                        }));

        cardealer = new UpgradeRoom("ved Bilforhandleren",
                new UpgradePath("Product",
                        new Upgrade[]{new Upgrade("Bare fødder", 0.0, 1.0), new Upgrade("Sneaks", 1.0, 2.0),
                                new Upgrade("Skateboard", 2.0, 3.0), new Upgrade("Cykel", 3.0, 4.0),
                                new Upgrade("Offentlig Transport", 4.0, 5.0), new Upgrade("Volkswagen UP", 5.0, 6.0),
                                new Upgrade("Ford Focus", 6.0, 7.0), new Upgrade("Mercedes CLA", 7.0, 8.0),
                                new Upgrade("Ferrari", 8.0, 9.0), new Upgrade("Formel 1", 9.0, 10.0),
                                new Upgrade("Lastbil", 10.0, 11.0), new Upgrade("MonsterTruck", 11.0, 12.0)

                        }),
                new UpgradePath("Forbrug",
                        new Upgrade[]{new Upgrade("0 km om uge", 0.0, 1.0), new Upgrade("5 km om ugen", 1.0, 2.0),
                                new Upgrade("10 km om ugen", 2.0, 3.0), new Upgrade("20 km om ugen", 3.0, 4.0),
                                new Upgrade("40 km om ugen", 4.0, 5.0), new Upgrade("60 km om ugen", 5.0, 6.0),
                                new Upgrade("80 km om ugen", 6.0, 7.0), new Upgrade("100 km om ugen", 7.0, 8.0),
                                new Upgrade("125 km om ugen", 8.0, 9.0), new Upgrade("150 km om ugen", 9.0, 10.0),
                                new Upgrade("175 km om ugen", 10.0, 11.0), new Upgrade("200 km om ugen", 11.0, 12.0),
                                new Upgrade("250 km om ugen", 12.0, 13.0), new Upgrade("300 km om ugen", 13.0, 14.0),
                                new Upgrade("400 km om ugen", 14.0, 15.0)

                        }));

        dock = new UpgradeRoom("ved Molen",
                new UpgradePath("Product",
                        new Upgrade[]{new Upgrade("Brødkrummer", 0.0, 1.0), new Upgrade("Sugerør", 1.0, 2.0),
                                new Upgrade("Slikpapir", 2.0, 3.0), new Upgrade("Plastikflaske", 3.0, 4.0),
                                new Upgrade("Plastikpose", 4.0, 5.0), new Upgrade("Actionman", 5.0, 6.0),
                                new Upgrade("Vandkande", 6.0, 7.0), new Upgrade("IKEA-kasse", 7.0, 8.0),
                                new Upgrade("Badeflamingo", 8.0, 9.0), new Upgrade("Bildæk", 9.0, 10.0),
                                new Upgrade("Presenning", 10.0, 11.0), new Upgrade("Rutchebane", 11.0, 12.0),
                                new Upgrade("Havetrampolin", 12.0, 13.0), new Upgrade("Kayak", 13.0, 14.0),
                                new Upgrade("Havepool", 14.0, 15.0)

                        }),
                new UpgradePath("Forbrug", new Upgrade[]{new Upgrade("Aldrig", 0.0, 1.0),
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

    public static String getRoomDescription() {
        return currentRoom.getLongDescription();
    }


//    public void goTurn(Command command) {
//        matas.setCombinedProduction();
//        laundry.setCombinedProduction();
//        cardealer.setCombinedProduction();
//        dock.setCombinedProduction();
//
//        double currentTotalPlasticProduction = matas.combinedProduction + laundry.combinedProduction
//                + cardealer.combinedProduction + dock.combinedProduction;
//
//        GameStats.SimulateTurn(1, currentTotalPlasticProduction);
//
//        if (GameStats.fishInOcean <= 0) {
//            wantToQuit = true;
//        } else {
//            GameStats.printStats();
//        }
//    }
}
