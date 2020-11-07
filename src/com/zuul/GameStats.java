package com.zuul;

import com.zuul.rooms.UpgradeRoom;

public class GameStats {
    private static long fishInOcean = 3500000000l;
    public static double currentFishSouls;
    private static double plasticInOcean;
    private static double plasticProduction;
    private UpgradeRoom[] upgradeRoom;
    public static int CurrentTurn = 0;
    public static final int CurrentYear = 2000;

    public static void SimulateTurn(int yr) {
        CurrentTurn+=yr;
        for (int y = 0; y < yr;y++) {
            UpdatePlastic();
            UpdateFish();
        }
    }
    public static String getYear() {
        return "The Current year is "+(CurrentYear+CurrentTurn);
    }

    public static void FetchPlasticProduction() {

    }
    private static void UpdatePlastic() {
        plasticInOcean += plasticProduction;
    }
    private static void UpdateFish() {
        currentFishSouls += plasticInOcean;
        fishInOcean -= plasticInOcean;
        if (fishInOcean <= 0) {
            fishInOcean = 0;
            // YOU WIN
        }
    }
}
