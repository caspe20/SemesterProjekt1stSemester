package com.zuul.presentation;

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

    public static void writeRoomDescription() {
        currCon.roomDescription.setText(g.getRoomDescription());
    }

    public static void writeCharacterDescription(String in) {

    }

    // upgrades - alternatively make single method.
    public static void writeUpgradeOneToScreen(Upgrade in) {

    }

    public static void upgradeLvlUpdate1() {
        UpgradeRoom UR = (UpgradeRoom)Game.currentRoom;
        UR.upgradePathProducts.performUpgrade();
        UR.setCombinedProduction();
    }

    public static void writeUpgradeTwoToScreen(Upgrade in) {

    }
    public static void upgradeLvlUpdate2() {
        UpgradeRoom UR = (UpgradeRoom)Game.currentRoom;
        UR.upgradePathUsage.performUpgrade();
        UR.setCombinedProduction();
    }

    public static void writeProductionDescription(String in) {

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

    }

}
