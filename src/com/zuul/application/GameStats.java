package com.zuul.application;

import com.zuul.application.rooms.UpgradeRoom;

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
        return String.valueOf(currentYear + currentTurn);
    }

    public static void printStats() {
        ScreenWriter.print(getYear());
        ScreenWriter.print(ScreenWriter.getLeftRight("Nuværende fiske sjæle:", String.valueOf(currentFishSouls)));
        ScreenWriter.print(ScreenWriter.getLeftRight("Nuværende plastik i havet", String.valueOf(plasticInOcean)));
        ScreenWriter.print(ScreenWriter.getLeftRight("Nuværende fisk i havet:", String.valueOf(fishInOcean)));
        ScreenWriter.print(ScreenWriter.getLeftRight("Nuværende plastik produktion: ", String.valueOf(plasticProduction)));
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
            ScreenWriter.printCenter("\nDu har vundet spillet! Tusind tak for at spille med :)");
        }
    }
}
