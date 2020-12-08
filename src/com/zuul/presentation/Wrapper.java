package com.zuul.presentation;

import com.zuul.application.GameStats;
import com.zuul.application.Game;
import com.zuul.application.Upgrade;
import com.zuul.application.rooms.UpgradeRoom;

public class Wrapper {

    private static Controller currCon;
    private static Game g;

    public static void setController(Controller con){
        currCon = con;
    }
    public static void setGame(Game game){
        g = game;
    }

    public static void writeCharacterDescription(String in) {

    }

    public static void upgradeLvlUpdate1() {
        if (Game.currentRoom instanceof UpgradeRoom) {
            UpgradeRoom UR = (UpgradeRoom)Game.currentRoom;
            UR.upgradePathProducts.performUpgrade();
            UR.setCombinedProduction();
            GameStats.UpdatePlasticProduction();
            updateUpgradeUI();
        }
    }

    public static void writeUpgradeTwoToScreen(Upgrade in) {

    }
    public static void upgradeLvlUpdate2() {
        if (Game.currentRoom instanceof UpgradeRoom) {
            UpgradeRoom UR = (UpgradeRoom)Game.currentRoom;
            UR.upgradePathUsage.performUpgrade();
            UR.setCombinedProduction();
            GameStats.UpdatePlasticProduction();
            updateUpgradeUI();
        }
    }

    public static void writeProductionDescription(String in) {

    }

    public static void changeRoomToMatas() {
        g.setRoomToMatas();
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToCardealer() {
        g.setRoomToCardealer();
        updateUpgradeUI();
        updateRoomUI();
    }

    
    public static void changeRoomToLaundry() {
        g.setRoomToLaundry();
        updateUpgradeUI();
        updateRoomUI();
    }

    public static void changeRoomToDock() {
        g.setRoomToDock();
        updateUpgradeUI();
        updateRoomUI();
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
        currCon.upgradeProducts1.setText(g.setProductsUpgradeOneDescription());
        currCon.upgradeProducts2.setText(g.setProductsUpgradeTwoDescription());
        currCon.upgradeProductsButton.setText(g.setProductsUpgradeButtonDescription());
        currCon.upgradeUsage1.setText(g.setUsageUpgradeOneDescription());
        currCon.upgradeUsage2.setText(g.setUsageUpgradeTwoDescription());
        currCon.upgradeUsageButton.setText(g.setUsageUpgradeButtonDescription());
    }

    public static void updateRoomUI() {
        currCon.roomDescription.setWrapText(true);
        currCon.roomDescription.setText(g.getRoomDescription());
        currCon.roomName.setText(g.getRoomName());
    }
}
