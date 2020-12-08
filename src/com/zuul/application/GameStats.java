package com.zuul.application;

import com.zuul.application.rooms.UpgradeRoom;

import java.text.DecimalFormat;
import java.util.HashMap;

public class GameStats {
    public static long fishInOcean = 2000000000l;
    public static long fishInOceanBeginning = fishInOcean;
    public static double currentFishSouls = 20000;
    public static double plasticInOcean;
    public static double plasticProduction = 1;
    public static String gameProgress;
    private UpgradeRoom[] upgradeRoom;
    public static double currentTurn = 0;
    public static final int currentYear = 2000;

    public static void SimulateTurn(double yr) {
        currentTurn += yr;
        UpdatePlastic(yr);
        UpdateFish(yr);
    }

    public String ProgressUpdate(String gameProgress) {
        this.gameProgress = gameProgress;
        return gameProgress;
    }

    public static void FetchPlasticProduction(double currentTotalPlasticProduction) {
        plasticProduction = currentTotalPlasticProduction;
    }

    private static void UpdatePlastic(double yr) {
        plasticInOcean += plasticProduction * yr;
    }

    public static void UpdatePlasticProduction() {
        plasticProduction = Game.matas.combinedProduction + Game.laundry.combinedProduction + Game.cardealer.combinedProduction + Game.dock.combinedProduction;
    }

    private static void UpdateFish(double yr) {
        currentFishSouls += plasticInOcean * yr;
        fishInOcean -= plasticInOcean * yr;
        if (fishInOcean <= 0) {
            fishInOcean = 0;
            // [*INSERT YOU WIN FUNCTION HERE*]
        }
    }

    public static String getYear() {
        double date = currentYear + currentTurn;
        double day = (date % 1) * 365;
        String out = "år " + String.valueOf(((int)date)) + " dag " + String.format("%.0f", day);
        return out;
    }

    public static String getFish() {
        return convertToVerbal(currentFishSouls) + " sjæle";
    }

    public static String getPlasticProduction(){
        return convertToVerbal(plasticProduction) + " Tons";
    }

    public static String convertToVerbal(double count) {
        if (count < 1000) {
            return String.format("%.2f", count);
        } else if (count < 1000000) {
            return String.format("%.2f", count / 1000) + "t";
        } else {
            return String.format("%.2f", count/1000000) + "M";
        }
    }

    public static String getPlastic() {
        String out = "";
        if (plasticInOcean < 1) {
            out = String.format("%.2f", plasticInOcean * 1000) + " Kilo";
        } else{
            out = convertToVerbal(plasticInOcean) + " Tons";
        }
        return out;
    }
}
