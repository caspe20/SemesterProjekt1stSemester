package com.zuul.presentation;

import com.zuul.application.GameStats;
import com.zuul.application.Game;
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

    /**
     * Set variables
     */

    /**
     * Stores the upgrade room controller as a static object for referencing
     *
     * @param con controller to set as upgrade room controller
     */
    public static void setUpgradeRoomController(UpgradeRoomController con) {
        upgradeRoomController = con;
    }

    /**
     * Stores the start menu controller as a static object for referencing
     *
     * @param con controller to set as start menu controller
     */
    public static void setStartMenuController(StartMenuController con) {
        startMenuController = con;
    }

    /**
     * Stores the devil room controller as a static object for referencing
     *
     * @param con controller to set as devil room controller
     */
    public static void setDevilsRoomController(DevilsRoomController con) {
        devilsRoomController = con;
    }

    /**
     * Updates the static variable for the wrapper class for referencing.
     *
     * @param game the game to be stored
     */
    public static void setGame(Game game) {
        Wrapper.game = game;
    }

    /**
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
     * @param txt text to display in the user description
     */
    public static void setUserDescription(String txt) {
        upgradeRoomController.userDescription.setWrapText(true);
        upgradeRoomController.userDescription.setText(txt);
    }

    /**
     * updates the upgrade UI for the current scene.
     */
    public static void updateUpgradeUI() {
        Game.updateUpgradeUI();
    }


    public static void setUpdateUpgradeUI(String button1, String button2, String label1, String label2,
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
        upgradeRoomController.roomDescription.setWrapText(true);
        upgradeRoomController.roomDescription.setText(game.getRoomDescription());
        upgradeRoomController.roomName.setText(game.getRoomName());
        updateUpgradeUI();
    }

    /**
     * Updates the scene's UI, such that it reflects the games' devil's room
     */

    private static void updateDevilsRoomUI() {
        devilsRoomController.roomDescription.setWrapText(true);
        devilsRoomController.userDescription.setWrapText(true);
        updateDevilsRoomUserDescription();
        updateDevilsRoomStats();
    }


    /**
     * Sets and updates the UI in devils room
     */

    public static void updateDevilsRoomStats() {
        Game.updateDevilsRoomStats();
    }

    public static void setDevilsRoomStats(String label1, String label2, String label3, String label4,
                                          String label5, String label6, String label7, String label8) {

        if (Game.currentRoom instanceof DevilsRoom) {
            devilsRoomController.matasProduction.setText(label1);
            devilsRoomController.matasUsage.setText(label2);
            devilsRoomController.carDealerProduction.setText(label3);
            devilsRoomController.carDealerUsage.setText(label4);
            devilsRoomController.laundryProduction.setText(label5);
            devilsRoomController.laundryUsage.setText(label6);
            devilsRoomController.harbourProduction.setText(label7);
            devilsRoomController.harbourUsage.setText(label8);
        }
    }

    public static void updateDevilsRoomUserDescription() {
        Game.updateDevilsRoomUserDescription();
    }

    public static void setDevilsRoomUserDescription(String userDescription) {
        if (Game.currentRoom instanceof DevilsRoom) {
            devilsRoomController.userDescription.setText(userDescription);
        }
    }







    /**
     * Resets all navigation buttons once they've been pressed
     */
    private static void resetNavigationButtons() {
        upgradeRoomController.goToCarDealer.setMouseTransparent(false);
        // upgradeRoomController.goToCarDealer.setDisable(false);
        upgradeRoomController.goToHarbour.setMouseTransparent(false);
        // upgradeRoomController.goToHarbour.setDisable(false);
        upgradeRoomController.goToLaundry.setMouseTransparent(false);
        // upgradeRoomController.goToLaundry.setDisable(false);
        upgradeRoomController.goToMatas.setMouseTransparent(false);
        // upgradeRoomController.goToMatas.setDisable(false);
        upgradeRoomController.goToDevil.setMouseTransparent(false);
        // upgradeRoomController.goToDevil.setDisable(false);

        upgradeRoomController.goToCarDealer.setStyle(null);
        upgradeRoomController.goToHarbour.setStyle(null);
        upgradeRoomController.goToLaundry.setStyle(null);
        upgradeRoomController.goToMatas.setStyle(null);
        upgradeRoomController.goToDevil.setStyle(null);

    }

    /**
     * Game button functions
     */

    /**
     * Starts the game and starts the game timer.
     */
    public static void startGame() {
        game.changeScene("UpgradeRoom");
        game.setRoomToDevil();
        Wrapper.changeRoomToDevil();
        // upgradeRoomController.goToDevil.setDisable(true);
        Game.StartTimer();
    }

    /**
     * Upgrades the first upgradable item in the current room and updates the UI to
     * reflect this
     */
    public static void upgradeLvlUpdate1() {
        if (Game.currentRoom instanceof UpgradeRoom) {
            UpgradeRoom upgradeRoom = (UpgradeRoom) Game.currentRoom;
            upgradeRoom.upgradePathProducts.performUpgrade();
            upgradeRoom.setCombinedProduction();
            GameStats.UpdatePlasticProduction();
            updateUpgradeUI();
        }
    }

    /**
     * upgrade the second upgradable item in the current room and updates the UI to
     * reflect this
     */
    public static void upgradeLvlUpdate2() {
        if (Game.currentRoom instanceof UpgradeRoom) {
            UpgradeRoom upgradeRoom = (UpgradeRoom) Game.currentRoom;
            upgradeRoom.upgradePathUsage.performUpgrade();
            upgradeRoom.setCombinedProduction();
            GameStats.UpdatePlasticProduction();
            updateUpgradeUI();
        }
    }

    /**
     * Changes the current room to Matas, such that upgrades and other items are
     * available for that room
     */
    public static void changeRoomToMatas() {
        game.setRoomToMatas();
        resetNavigationButtons();
        upgradeRoomController.goToMatas.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToMatas.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to car dealer, such that upgrades and other items
     * are available for that room
     */
    public static void changeRoomToCardealer() {
        game.setRoomToCardealer();
        resetNavigationButtons();
        upgradeRoomController.goToCarDealer.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToCarDealer.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to laundry mat, such that upgrades and other items
     * are available for that room
     */
    public static void changeRoomToLaundry() {
        game.setRoomToLaundry();
        resetNavigationButtons();
        upgradeRoomController.goToLaundry.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToLaundry.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to dock, such that upgrades and other items are
     * available for that room
     */
    public static void changeRoomToDock() {
        game.setRoomToDock();
        resetNavigationButtons();
        upgradeRoomController.goToHarbour.setStyle("-fx-background-color: #17B831;");
        upgradeRoomController.goToHarbour.setMouseTransparent(true);
        updateUpgradeRoomUI();
    }

    /**
     * Changes the current room to devil room, such that upgrades and other items
     * are available for that room
     */
    public static void changeRoomToDevil() {
        game.setRoomToDevil();
        resetNavigationButtons();
        upgradeRoomController.goToDevil.setStyle("-fx-background-color: #9F1515;");
        upgradeRoomController.goToDevil.setMouseTransparent(true);
        updateDevilsRoomUI();
    }
}
