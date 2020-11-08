package com.zuul;

import com.zuul.rooms.UpgradeRoom;

public class GameStats {
    public static long fishInOcean = 3500l;
    public static double currentFishSouls;
    public static double plasticInOcean;
    private static double plasticProduction;
    private UpgradeRoom[] upgradeRoom;
    public static int currentTurn = 0;
    public static final int currentYear = 2000;

    public static void SimulateTurn(int yr, double currentTotalPlasticProduction) {
        currentTurn += yr;
        for (int y = 0; y < yr;y++) {
            FetchPlasticProduction(currentTotalPlasticProduction);
            UpdatePlastic();
            UpdateFish();
        }
    }

    public static String getYear() {
        return "The Current year is "+(currentYear + currentTurn);
    }

    public static void printStats() {
        System.out.println(getYear());
        System.out.println("Current fish souls: " + currentFishSouls);
        System.out.println("Current plastic in ocean: " + plasticInOcean);
        System.out.println("Current fish in ocean: " + fishInOcean);
        System.out.println("Current plastic production: " + plasticProduction);
    }

    public static void FetchPlasticProduction(double currentTotalPlasticProduction) {
        plasticProduction = currentTotalPlasticProduction;
    }

    private static void UpdatePlastic() {
        plasticInOcean += plasticProduction;
    }

    private static void UpdateFish() {
        currentFishSouls += plasticInOcean;
        fishInOcean -= plasticInOcean;
        if (fishInOcean <= 0) {
            fishInOcean = 0;
            System.out.println("\nYou won the game!! gg");
        }
    }
}
