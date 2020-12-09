package com.zuul.presentation;

import com.zuul.application.GameStats;
import com.zuul.application.Game;
import com.zuul.application.Upgrade;
import com.zuul.application.rooms.DevilsRoom;
import com.zuul.application.rooms.UpgradeRoom;
import com.zuul.presentation.controllers.DevilsRoomController;
import com.zuul.presentation.controllers.StartMenuController;
import com.zuul.presentation.controllers.UpgradeRoomController;

public class Wrapper {

    private static UpgradeRoomController upgradeRoomController;
    private static StartMenuController startMenuController;
    private static DevilsRoomController devilsRoomController;
    private static Game game;

    public static void setUpgradeRoomController(UpgradeRoomController con) {
        upgradeRoomController = con;
    }

    public static void setStartMenuController(StartMenuController con) {
        startMenuController = con;
    }

    public static void setDevilsRoomController(DevilsRoomController con) {
        devilsRoomController = con;
    }

    public static void setGame(Game game) {
        Wrapper.game = game;
    }

    public static void writeCharacterDescription(String in) {

    }

    public static void upgradeLvlUpdate1() {
        if (Game.currentRoom instanceof UpgradeRoom) {
            UpgradeRoom upgradeRoom = (UpgradeRoom) Game.currentRoom;
            upgradeRoom.upgradePathProducts.performUpgrade();
            upgradeRoom.setCombinedProduction();
            GameStats.UpdatePlasticProduction();
            updateUpgradeUI();
        }
    }

    public static void writeUpgradeTwoToScreen(Upgrade in) {

    }

    public static void upgradeLvlUpdate2() {
        if (Game.currentRoom instanceof UpgradeRoom) {
            UpgradeRoom upgradeRoom = (UpgradeRoom) Game.currentRoom;
            upgradeRoom.upgradePathUsage.performUpgrade();
            upgradeRoom.setCombinedProduction();
            GameStats.UpdatePlasticProduction();
            updateUpgradeUI();
        }
    }

    public static void writeProductionDescription(String in) {

    }

    public static void changeRoomToMatas() {
        game.setRoomToMatas();
        resetNavigationButtons();
        upgradeRoomController.goToMatas.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToMatas.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToCardealer() {
        game.setRoomToCardealer();
        resetNavigationButtons();
        upgradeRoomController.goToCarDealer.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToCarDealer.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }


    public static void changeRoomToLaundry() {
        game.setRoomToLaundry();
        resetNavigationButtons();
        upgradeRoomController.goToLaundry.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToLaundry.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDock() {
        game.setRoomToDock();
        resetNavigationButtons();
        upgradeRoomController.goToHarbour.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToHarbour.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDevil() throws Exception {
        game.setRoomToDevil();
        resetNavigationButtons();
        upgradeRoomController.goToDevil.setStyle("-fx-background-color: #9F1515;");
        upgradeRoomController.goToDevil.setMouseTransparent(true);
    }

    /* [0] Årstal
     * [1] plast pr dag
     * [2] plast i havet
     * [3] fiske sjæle
     */
    public static void writeStatistics(String[] stats) {
        upgradeRoomController.time.setText(stats[0]);
        upgradeRoomController.plastPerDay.setText(stats[1]);
        upgradeRoomController.plastInSea.setText(stats[2]);
        upgradeRoomController.fishSouls.setText(stats[3]);

        devilsRoomController.time.setText(stats[0]);
        devilsRoomController.plastPerDay.setText(stats[1]);
        devilsRoomController.plastInSea.setText(stats[2]);
        devilsRoomController.fishSouls.setText(stats[3]);
    }

    public static void setProgressBar(double progress) {
        upgradeRoomController.progressBar.setProgress(progress);
        devilsRoomController.progressBar.setProgress(progress);
    }

    public static void setProgressBarText(String txt) {
        upgradeRoomController.deadFish.setText(txt);
    }
    public static void setUserDescription(String txt) {
        upgradeRoomController.userDescription.setWrapText(true);
        upgradeRoomController.userDescription.setText(txt);
    }


    public static void updateUpgradeUI() {
        String[] info = Game.getupdateUpgradeUIInfo();
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

        // Formatting buttons
        upgradeRoomController.upgradeProductsButton.setDisable((info[0].equals("opgradering utilgængelig")));
        upgradeRoomController.upgradeUsageButton.setDisable((info[1].equals("opgradering utilgængelig")));

        // Update button text
        upgradeRoomController.upgradeProductsButton.setText(info[0]);
        upgradeRoomController.upgradeUsageButton.setText(info[1]);

        // Update upgrades text
        upgradeRoomController.upgradeProducts1.setText(info[2]);
        upgradeRoomController.upgradeProducts2.setText(info[3]);
        upgradeRoomController.upgradeProducts1Pollution.setText(info[4]);
        upgradeRoomController.upgradeProducts2Pollution.setText(info[5]);
        upgradeRoomController.upgradeUsage1.setText(info[6]);
        upgradeRoomController.upgradeUsage2.setText(info[7]);
        upgradeRoomController.upgradeUsage1Pollution.setText(info[8]);
        upgradeRoomController.upgradeUsage2Pollution.setText(info[9]);
    }

    public static void updateRoomUI() {
        upgradeRoomController.roomDescription.setWrapText(true);
        upgradeRoomController.roomDescription.setText(game.getRoomDescription());
        upgradeRoomController.roomName.setText(game.getRoomName());
    }

    public static void resetNavigationButtons(){
        upgradeRoomController.goToCarDealer.setMouseTransparent(false);
        upgradeRoomController.goToHarbour.setMouseTransparent(false);
        upgradeRoomController.goToLaundry.setMouseTransparent(false);
        upgradeRoomController.goToMatas.setMouseTransparent(false);
        upgradeRoomController.goToDevil.setMouseTransparent(false);
    }

    /**
     * Starts the game and starts the game timer.
     */
    public static void startGame() {
        game.changeScene("UpgradeRoom");
        game.setRoomToDevil();
        //upgradeRoomController.goToDevil.setDisable(true);
        Game.StartTimer();
    }

    public static void setDevilsRoomStats() {
        if (Game.currentRoom instanceof DevilsRoom) {
            devilsRoomController.matasProduction.setText("Production level: " + (Game.matas.upgradePathProducts.getCurrentLevel() + 1));
            devilsRoomController.matasUsage.setText("Usage level: " + (Game.matas.upgradePathUsage.getCurrentLevel() + 1));
            devilsRoomController.carDealerProduction.setText("Production level: " + (Game.cardealer.upgradePathProducts.getCurrentLevel() + 1));
            devilsRoomController.carDealerUsage.setText("Usage level: " + (Game.cardealer.upgradePathUsage.getCurrentLevel() + 1));
            devilsRoomController.laundryProduction.setText("Production level: " + (Game.laundry.upgradePathProducts.getCurrentLevel() + 1));
            devilsRoomController.laundryUsage.setText("Usage level: " + (Game.laundry.upgradePathUsage.getCurrentLevel() + 1));
            devilsRoomController.harbourProduction.setText("Production level: " + (Game.dock.upgradePathProducts.getCurrentLevel() + 1));
            devilsRoomController.harbourUsage.setText("Usage level: " + (Game.dock.upgradePathUsage.getCurrentLevel() + 1));
        }
    }
}
