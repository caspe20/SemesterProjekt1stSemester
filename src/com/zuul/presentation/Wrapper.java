package com.zuul.presentation;

import com.zuul.application.GameStats;
import com.zuul.application.Game;
import com.zuul.application.Upgrade;
import com.zuul.application.rooms.DevilsRoom;
import com.zuul.application.rooms.UpgradeRoom;

public class Wrapper {

    private static UpgradeRoomController upgradeRoomController;
    private static DevilsRoomController devilsRoomController;
    private static Game game;

    public static void setController(UpgradeRoomController con) {
        upgradeRoomController = con;
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
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToCardealer() {
        game.setRoomToCardealer();
        resetNavigationButtons();
        upgradeRoomController.goToCarDealer.setStyle("-fx-background-color: #17B831;");
        updateUpgradeUI();
        updateRoomUI();
    }


    public static void changeRoomToLaundry() {
        game.setRoomToLaundry();
        resetNavigationButtons();
        upgradeRoomController.goToLaundry.setStyle("-fx-background-color: #17B831;");
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDock() {
        game.setRoomToDock();
        resetNavigationButtons();
        upgradeRoomController.goToHarbour.setStyle("-fx-background-color: #17B831;");
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDevil() throws Exception {
        game.setRoomToDevil();
        resetNavigationButtons();
        upgradeRoomController.goToDevil.setStyle("-fx-background-color: #9F1515;");
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


    }

    public static void setProgressBar(double progress) {
        upgradeRoomController.progressBar.setProgress(progress);
    }

    public static void setProgressBarText(String txt) {
        upgradeRoomController.deadFish.setText(txt);
    }
    public static void setUserDescription(String txt) {
        upgradeRoomController.userDescription.setWrapText(true);
        upgradeRoomController.userDescription.setText(txt);
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
            upgradeRoomController.UpgradeProductArrow.setVisible(false);
            // Labels
            // current
            upgradeRoomController.upgradeProducts1.setText(UR.getProductsUpgradeOneDescription());
            upgradeRoomController.upgradeProducts1Pollution.setText("[" + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            upgradeRoomController.upgradeProducts2.setText("Max opgradering nået!");
            upgradeRoomController.upgradeProducts2Pollution.setText("");
            // Button
            upgradeRoomController.upgradeProductsButton.setText("opgradering utilgængelig");
            upgradeRoomController.upgradeProductsButton.setDisable(true);
        } else {
            // If ugrade is available
            // Arrow
            upgradeRoomController.UpgradeProductArrow.setVisible(true);
            // Labels
            // current
            upgradeRoomController.upgradeProducts1.setText(UR.getProductsUpgradeOneDescription());
            upgradeRoomController.upgradeProducts1Pollution.setText("[" + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            upgradeRoomController.upgradeProducts2.setText(UR.getProductsUpgradeTwoDescription());
            upgradeRoomController.upgradeProducts2Pollution.setText("[" + String.valueOf(upgradeProduct[currProductUpgrade + 1].productionSpeed) + "] * " + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade + 1].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // Button
            upgradeRoomController.upgradeProductsButton.setDisable(false);
            upgradeRoomController.upgradeProductsButton.setText(UR.getProductsUpgradeButtonDescription());
        }

        // upgrade usage panel
        if (upgradeUsage.length - 1 <= UR.upgradePathUsage.getCurrentLevel()) {
            // If upgrade is unavailable
            // Arrow
            upgradeRoomController.UpgradeUsageArrow.setVisible(false);
            // Labels
            // current
            upgradeRoomController.upgradeUsage1.setText(UR.getUsageUpgradeOneDescription());
            upgradeRoomController.upgradeUsage1Pollution.setText("[" + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            upgradeRoomController.upgradeUsage2.setText("Max opgradering nået!");
            upgradeRoomController.upgradeUsage2Pollution.setText("");
            // Button
            upgradeRoomController.upgradeUsageButton.setText("opgradering utilgængelig");
            upgradeRoomController.upgradeUsageButton.setDisable(true);
        } else {
            // If ugrade is available
            // Arrow
            upgradeRoomController.UpgradeUsageArrow.setVisible(true);
            // Labels
            // current
            upgradeRoomController.upgradeUsage1.setText(UR.getUsageUpgradeOneDescription());
            upgradeRoomController.upgradeUsage1Pollution.setText("[" + String.valueOf(upgradeUsage[currUsageUpgrade].productionSpeed) + "] * " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade].productionSpeed) + " Tons pr. år");
            // next
            upgradeRoomController.upgradeUsage2.setText(UR.getUsageUpgradeTwoDescription());
            upgradeRoomController.upgradeUsage2Pollution.setText("[" + String.valueOf(upgradeUsage[currUsageUpgrade + 1].productionSpeed) + "] * " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed) + " = " + String.valueOf(upgradeProduct[currProductUpgrade].productionSpeed * upgradeUsage[currUsageUpgrade + 1].productionSpeed) + " Tons pr. år");
            // Button
            upgradeRoomController.upgradeUsageButton.setDisable(false);
            upgradeRoomController.upgradeUsageButton.setText(UR.getUsageUpgradeButtonDescription());
        }
    }

    public static void updateRoomUI() {
        upgradeRoomController.roomDescription.setWrapText(true);
        upgradeRoomController.roomDescription.setText(game.getRoomDescription());
        upgradeRoomController.roomName.setText(game.getRoomName());
    }

    public static void resetNavigationButtons(){
        upgradeRoomController.goToCarDealer.setDisable(false);
        upgradeRoomController.goToHarbour.setDisable(false);
        upgradeRoomController.goToLaundry.setDisable(false);
        upgradeRoomController.goToMatas.setDisable(false);
        upgradeRoomController.goToDevil.setDisable(false);
    }

    /*
     * Starts the game and starts the game timer.
     */
    public static void startGame() {
        game.setRoomToDevil();
        upgradeRoomController.goToDevil.setDisable(true);
        Game.StartTimer();
    }

    public static void setStats() {
        if (Game.currentRoom instanceof DevilsRoom) {
            DevilsRoomController.matasProduction.setText("Production level: " + (Game.matas.upgradePathProducts.getCurrentLevel() + 1));
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
