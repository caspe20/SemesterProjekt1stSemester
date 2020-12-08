package com.zuul.presentation;

import com.zuul.application.GameStats;
import com.zuul.application.Game;
import com.zuul.application.Upgrade;
import com.zuul.application.rooms.DevilsRoom;
import com.zuul.application.rooms.UpgradeRoom;

public class Wrapper {

    private static Controller currCon;
    private static Game game;

    public static void setController(Controller con) {
        currCon = con;
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
        currCon.goToMatas.setStyle("-fx-background-color: #17B831;");
        currCon.goToMatas.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToCardealer() {
        game.setRoomToCardealer();
        resetNavigationButtons();
        currCon.goToCarDealer.setStyle("-fx-background-color: #17B831;");
        currCon.goToCarDealer.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }


    public static void changeRoomToLaundry() {
        game.setRoomToLaundry();
        resetNavigationButtons();
        currCon.goToLaundry.setStyle("-fx-background-color: #17B831;");
        currCon.goToLaundry.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDock() {
        game.setRoomToDock();
        resetNavigationButtons();
        currCon.goToHarbour.setStyle("-fx-background-color: #17B831;");
        currCon.goToHarbour.setMouseTransparent(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDevil() throws Exception {
        game.setRoomToDevil();
        resetNavigationButtons();
        currCon.goToDevil.setStyle("-fx-background-color: #9F1515;");
        currCon.goToDevil.setMouseTransparent(true);
    }

    /* [0] Årstal
     * [1] plast pr dag
     * [2] plast i havet
     * [3] fiske sjæle
     */
    public static void writeStatistics(String[] stats) {
        currCon.time.setText(stats[0]);
        currCon.plastPerDay.setText(stats[1]);
        currCon.plastInSea.setText(stats[2]);
        currCon.fishSouls.setText(stats[3]);
    }

    public static void setProgressBar(double progress) {
        currCon.progressBar.setProgress(progress);
    }

    public static void setProgressBarText(String txt) {
        currCon.deadFish.setText(txt);
    }
    public static void setUserDescription(String txt) {
        currCon.userDescription.setWrapText(true);
        currCon.userDescription.setText(txt);
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
        currCon.upgradeProductsButton.setDisable((info[0].equals("opgradering utilgængelig")));
        currCon.upgradeUsageButton.setDisable((info[1].equals("opgradering utilgængelig")));

        // Update button text
        currCon.upgradeProductsButton.setText(info[0]);
        currCon.upgradeUsageButton.setText(info[1]);

        // Update upgrades text
        currCon.upgradeProducts1.setText(info[2]);
        currCon.upgradeProducts2.setText(info[3]);
        currCon.upgradeProducts1Pollution.setText(info[4]);
        currCon.upgradeProducts2Pollution.setText(info[5]);
        currCon.upgradeUsage1.setText(info[6]);
        currCon.upgradeUsage2.setText(info[7]);
        currCon.upgradeUsage1Pollution.setText(info[8]);
        currCon.upgradeUsage2Pollution.setText(info[9]);
    }

    public static void updateRoomUI() {
        currCon.roomDescription.setWrapText(true);
        currCon.roomDescription.setText(game.getRoomDescription());
        currCon.roomName.setText(game.getRoomName());
    }

    public static void resetNavigationButtons(){
        currCon.goToCarDealer.setMouseTransparent(false);
        currCon.goToHarbour.setMouseTransparent(false);
        currCon.goToLaundry.setMouseTransparent(false);
        currCon.goToMatas.setMouseTransparent(false);
        currCon.goToDevil.setMouseTransparent(false);
    }

    /**
     * Starts the game and starts the game timer.
     */
    public static void startGame() {
        game.setRoomToDevil();
        currCon.goToDevil.setDisable(true);
        Game.StartTimer();
    }
}
