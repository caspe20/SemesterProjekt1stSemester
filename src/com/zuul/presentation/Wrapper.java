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
        currCon.goToMatas.setDisable(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToCardealer() {
        game.setRoomToCardealer();
        resetNavigationButtons();
        currCon.goToCarDealer.setDisable(true);
        updateUpgradeUI();
        updateRoomUI();
    }


    public static void changeRoomToLaundry() {
        game.setRoomToLaundry();
        resetNavigationButtons();
        currCon.goToLaundry.setDisable(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDock() {
        game.setRoomToDock();
        resetNavigationButtons();
        currCon.goToHarbour.setDisable(true);
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDevil() throws Exception {
        game.setRoomToDevil();
        resetNavigationButtons();
        currCon.goToDevil.setDisable(true);
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

    public static void updateUpgradeUI() {
        UpgradeRoom UR = (UpgradeRoom) Game.currentRoom;
        Upgrade[] upgradeProduct = UR.upgradePathProducts.getUpgrades();
        Upgrade[] upgradeUsage = UR.upgradePathUsage.getUpgrades();
        int currProductUpgrade = UR.upgradePathProducts.getCurrentLevel();
        int currUsageUpgrade = UR.upgradePathUsage.getCurrentLevel();

        // upgrade prduction panel
        if (upgradeProduct.length - 1 <= UR.upgradePathProducts.getCurrentLevel()) {
            // If upgrade is unavailable
            // Arrow
            currCon.UpgradeProductArrow.setVisible(false);
            // Labels
            // current
            currCon.upgradeProducts1.setText(game.setProductsUpgradeOneDescription());
            currCon.upgradeProducts1Pollution.setText("[" + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            currCon.upgradeProducts2.setText("Max opgradering nået!");
            currCon.upgradeProducts2Pollution.setText("");
            // Button
            currCon.upgradeProductsButton.setText("opgradering utilgængelig");
            currCon.upgradeProductsButton.setDisable(true);
        } else {
            // If ugrade is available
            // Arrow
            currCon.UpgradeProductArrow.setVisible(true);
            // Labels
            // current
            currCon.upgradeProducts1.setText(game.setProductsUpgradeOneDescription());
            currCon.upgradeProducts1Pollution.setText("[" + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            currCon.upgradeProducts2.setText(game.setProductsUpgradeTwoDescription());
            currCon.upgradeProducts2Pollution.setText("[" + String.valueOf(upgradeProduct[currProductUpgrade + 1].productionSpeed) + "] * " + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade + 1].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // Button
            currCon.upgradeProductsButton.setDisable(false);
            currCon.upgradeProductsButton.setText(Game.setProductsUpgradeButtonDescription());
        }

        // upgrade usage panel
        if (upgradeUsage.length - 1 <= UR.upgradePathUsage.getCurrentLevel()) {
            // If upgrade is unavailable
            // Arrow
            currCon.UpgradeUsageArrow.setVisible(false);
            // Labels
            // current
            currCon.upgradeUsage1.setText(game.setUsageUpgradeOneDescription());
            currCon.upgradeUsage1Pollution.setText("[" + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            currCon.upgradeUsage2.setText("Max opgradering nået!");
            currCon.upgradeUsage2Pollution.setText("");
            // Button
            currCon.upgradeUsageButton.setText("opgradering utilgængelig");
            currCon.upgradeUsageButton.setDisable(true);
        } else {
            // If ugrade is available
            // Arrow
            currCon.UpgradeUsageArrow.setVisible(true);
            // Labels
            // current
            currCon.upgradeUsage1.setText(game.setUsageUpgradeOneDescription());
            currCon.upgradeUsage1Pollution.setText("[" + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            currCon.upgradeUsage2.setText(game.setUsageUpgradeTwoDescription());
            currCon.upgradeUsage2Pollution.setText("[" + String.valueOf(upgradeUsage[currUsageUpgrade + 1].productionSpeed) + "] * " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade + 1].productionSpeed) + " Tons pr. år");
            // Button
            currCon.upgradeUsageButton.setDisable(false);
            currCon.upgradeUsageButton.setText(game.setUsageUpgradeButtonDescription());
        }
    }

    public static void updateRoomUI() {
        currCon.roomDescription.setWrapText(true);
        currCon.roomDescription.setText(game.getRoomDescription());
        currCon.roomName.setText(game.getRoomName());
    }

    public static void resetNavigationButtons(){
        currCon.goToCarDealer.setDisable(false);
        currCon.goToHarbour.setDisable(false);
        currCon.goToLaundry.setDisable(false);
        currCon.goToMatas.setDisable(false);
        currCon.goToDevil.setDisable(false);
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
