package com.zuul.presentation;

import com.zuul.application.Game;
import com.zuul.presentation.controllers.*;

public class Wrapper {

    private static UpgradeRoomController upgradeRoomController;
    private static StartMenuController startMenuController;
    private static DevilsRoomController devilsRoomController;
    private static EndScreenController endScreenController;

    /*
     * Set variables
     */

    /**
     * Sets all the controllers from the different FXML documents to their equal controller variables in the Wrapper
     *
     * @param startMenu   Sets startMenuController
     * @param devilsRoom  Sets devilsRoomController
     * @param upgradeRoom Sets upgradeRoomController
     * @param endScreen   Sets endScreenController
     */
    public static void setControllers(StartMenuController startMenu, DevilsRoomController devilsRoom, UpgradeRoomController upgradeRoom, EndScreenController endScreen) {
        startMenuController = startMenu;
        upgradeRoomController = upgradeRoom;
        devilsRoomController = devilsRoom;
        endScreenController = endScreen;
    }

    /*
     * update UI
     */

    /**
     * Writes year, plastic production, plastic in ocean, and fish souls to screen
     *
     * @param year         Formatted string for displaying year
     * @param plast        Formatted string for displaying plastic production
     * @param plastInOcean Formatted string for displaying plastic in ocean
     * @param fishSouls    Formatted string for displaying fish souls
     */
    public static void writeStatistics(String year, String plast, String plastInOcean, String fishSouls) {
        upgradeRoomController.time.setText(year);
        upgradeRoomController.plastPerDay.setText(plast);
        upgradeRoomController.plastInSea.setText(plastInOcean);
        upgradeRoomController.fishSouls.setText(fishSouls);

        devilsRoomController.time.setText(year);
        devilsRoomController.plastPerDay.setText(plast);
        devilsRoomController.plastInSea.setText(plastInOcean);
        devilsRoomController.fishSouls.setText(fishSouls);
    }

    /**
     * Updates the progress bar in the upgradeRoom- and devilRoom scene, and cuts
     * decimals off based on progress
     *
     * @param progress Progress in percent [0.0 .. 1.0]
     */
    public static void setProgressBar(double progress) {
        upgradeRoomController.progressBar.setProgress(progress);
        devilsRoomController.progressBar.setProgress(progress);
        if (progress * 100 < 0.001) {
            upgradeRoomController.deadFish.setText(String.format("%.6f", progress * 100) + "% af fiskene er døde.");
            devilsRoomController.deadFish.setText(String.format("%.6f", progress * 100) + "% af fiskene er døde.");
        } else if (progress * 100 < 0.01) {
            upgradeRoomController.deadFish.setText(String.format("%.4f", progress * 100) + "% af fiskene er døde.");
            devilsRoomController.deadFish.setText(String.format("%.4f", progress * 100) + "% af fiskene er døde.");
        } else if (progress * 100 < 0.1) {
            upgradeRoomController.deadFish.setText(String.format("%.3f", progress * 100) + "% af fiskene er døde.");
            devilsRoomController.deadFish.setText(String.format("%.3f", progress * 100) + "% af fiskene er døde.");
        } else if (progress * 100 < 1) {
            upgradeRoomController.deadFish.setText(String.format("%.3f", progress * 100) + "% af fiskene er døde.");
            devilsRoomController.deadFish.setText(String.format("%.3f", progress * 100) + "% af fiskene er døde.");
        } else if (progress * 100 < 10) {
            upgradeRoomController.deadFish.setText(String.format("%.2f", progress * 100) + "% af fiskene er døde.");
            devilsRoomController.deadFish.setText(String.format("%.2f", progress * 100) + "% af fiskene er døde.");
        } else {
            upgradeRoomController.deadFish.setText(String.format("%.1f", progress * 100) + "% af fiskene er døde.");
            devilsRoomController.deadFish.setText(String.format("%.1f", progress * 100) + "% af fiskene er døde.");
        }
    }

    /**
     * Function setting the description of the users of the current room
     *
     * @param userDescription text to display in the user description
     */
    public static void setUserDescription(String userDescription) {
        upgradeRoomController.userDescription.setWrapText(true);
        upgradeRoomController.userDescription.setText(userDescription);
    }

    /**
     * Updates the upgrade UI for the current scene.
     */

    public static void setUpgradeRoomDescription(String roomName, String roomDescription) {
        upgradeRoomController.roomDescription.setWrapText(true);
        upgradeRoomController.roomName.setText(roomName);
        upgradeRoomController.roomDescription.setText(roomDescription);
    }


    public static void setUpgradePanelUI(String button1, String button2, String label1, String label2,
                                         String label3, String label4, String label5, String label6) {

        // Formatting buttons
        upgradeRoomController.upgradeProductsButton.setDisable((button1.equals("Opgradering utilgængelig")));
        upgradeRoomController.upgradeUsageButton.setDisable((button2.equals("Opgradering utilgængelig")));

        // Update button text
        upgradeRoomController.upgradeProductsButton.setText(button1);
        upgradeRoomController.upgradeUsageButton.setText(button2);

        // Update upgrades text
        upgradeRoomController.upgradeProducts1.setText(label1);
        upgradeRoomController.upgradeProducts2.setText(label2);
        upgradeRoomController.upgradeProducts2Pollution.setText(label3);
        upgradeRoomController.upgradeUsage1.setText(label4);
        upgradeRoomController.upgradeUsage2.setText(label5);
        upgradeRoomController.upgradeUsage2Pollution.setText(label6);
    }

    /**
     * Updates the scene's UI, such that it reflects the games' current upgrade room
     */
    private static void updateUpgradeRoomUI() {
        Game.updateUpgradePanelUI();
        Game.updateUpgradeRoomDescription();
    }

    /**
     * Updates the scene's UI, such that it reflects the games' devil's room
     */

    private static void updateDevilsRoomUI() {
        Game.updateDevilsRoomUserDescription();
        Game.updateDevilsRoomStats();
        Game.updateDevilsRoomDescription();
    }


    /**
     * Sets the UI in devils room
     */

    public static void setDevilsRoomStats(String label1, String label2, String label3, String label4,
                                          String label5, String label6, String label7, String label8) {
        devilsRoomController.matasProduction.setText(label1);
        devilsRoomController.matasUsage.setText(label2);
        devilsRoomController.carDealerProduction.setText(label3);
        devilsRoomController.carDealerUsage.setText(label4);
        devilsRoomController.laundryProduction.setText(label5);
        devilsRoomController.laundryUsage.setText(label6);
        devilsRoomController.harbourProduction.setText(label7);
        devilsRoomController.harbourUsage.setText(label8);

    }

    public static void setDevilsRoomUserDescription(String userDescription) {
        devilsRoomController.userDescription.setWrapText(true);
        devilsRoomController.userDescription.setText(userDescription);

    }

    public static void setDevilsRoomDescription(String startDescription) {
        devilsRoomController.roomDescription.setWrapText(true);
        devilsRoomController.roomDescription.setText(startDescription);
    }


    /**
     * Sets the UI for the start screen
     */

    public static void setStartScreenDescription(String startDescription) {
        startMenuController.roomDescription.setWrapText(true);
        startMenuController.roomDescription.setText(startDescription);
    }

    /**
     * Sets the UI for the end screen
     */

    public static void setEndScreenUI(String userDescription) {
        endScreenController.userDescription.setWrapText(true);
        endScreenController.userDescription.setText(userDescription);
    }

    /**
     * Resets all navigation buttons once they've been pressed
     */
    private static void resetNavigationButtons() {
        upgradeRoomController.goToCarDealer.setMouseTransparent(false);
        upgradeRoomController.goToHarbour.setMouseTransparent(false);
        upgradeRoomController.goToLaundry.setMouseTransparent(false);
        upgradeRoomController.goToMatas.setMouseTransparent(false);
        upgradeRoomController.goToDevil.setMouseTransparent(false);

        upgradeRoomController.goToCarDealer.setStyle(null);
        upgradeRoomController.goToHarbour.setStyle(null);
        upgradeRoomController.goToLaundry.setStyle(null);
        upgradeRoomController.goToMatas.setStyle(null);
        upgradeRoomController.goToDevil.setStyle(null);
    }

    /*
     * Game button functions
     */

    /**
     * Starts the game and starts the game timer.
     */
    public static void startGame() {
        changeRoomToDevil();
        Game.startTimer();
    }

    /**
     * Upgrades the first upgradable item in the current room and updates the UI to
     * reflect this
     */
    public static void upgradeLvlUpdate1() {
        Game.upgradeLvlUpdate1();
    }

    /**
     * upgrade the second upgradable item in the current room and updates the UI to
     * reflect this
     */
    public static void upgradeLvlUpdate2() {
        Game.upgradeLvlUpdate2();
    }

    /**
     * Changes the current room to Matas, such that upgrades and other items are
     * available for that room
     */
    public static void changeRoomToMatas() {
        Game.setRoomToMatas();
        resetNavigationButtons();
        upgradeRoomController.goToMatas.setStyle("-fx-background-color: #ffbfa1;");
        upgradeRoomController.goToMatas.setStyle("-fx-color: #ffe1d4;");
        upgradeRoomController.goToMatas.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to car dealer, such that upgrades and other items
     * are available for that room
     */
    public static void changeRoomToCardealer() {
        Game.setRoomToCardealer();
        resetNavigationButtons();
        upgradeRoomController.goToCarDealer.setStyle("-fx-background-color: #ffbfa1;");
        upgradeRoomController.goToCarDealer.setStyle("-fx-color: #ffe1d4;");
        upgradeRoomController.goToCarDealer.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to laundry mat, such that upgrades and other items
     * are available for that room
     */
    public static void changeRoomToLaundry() {
        Game.setRoomToLaundry();
        resetNavigationButtons();
        upgradeRoomController.goToLaundry.setStyle("-fx-background-color: #ffbfa1;");
        upgradeRoomController.goToLaundry.setStyle("-fx-color: #ffe1d4;");
        upgradeRoomController.goToLaundry.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to dock, such that upgrades and other items are
     * available for that room
     */
    public static void changeRoomToDock() {
        Game.setRoomToDock();
        resetNavigationButtons();
        upgradeRoomController.goToHarbour.setStyle("-fx-background-color: #ffbfa1;");
        upgradeRoomController.goToHarbour.setStyle("-fx-color: #ffe1d4;");
        upgradeRoomController.goToHarbour.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to devil room, such that upgrades and other items
     * are available for that room
     */
    public static void changeRoomToDevil() {
        Game.setRoomToDevil();
        resetNavigationButtons();
        devilsRoomController.goToDevil.setStyle("-fx-background-color: #ffbfa1;");
        devilsRoomController.goToDevil.setStyle("-fx-color: #ffe1d4;");
        devilsRoomController.goToDevil.setMouseTransparent(true);
        updateDevilsRoomUI();
    }
}
