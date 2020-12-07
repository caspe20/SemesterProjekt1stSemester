package com.zuul.application;

import com.zuul.application.rooms.UpgradeRoom;

import java.text.DecimalFormat;

public class GameStats {
    public static long fishInOcean = 35000l;
    public static long fishInOceanBeginning = fishInOcean;
    public static double currentFishSouls;
    public static double plasticInOcean;
    public static double plasticProduction = 1;
    private UpgradeRoom[] upgradeRoom;
    public static double currentTurn = 0;
    public static final int currentYear = 2000;

    public static void SimulateTurn(double yr) {
        currentTurn += yr;
        UpdatePlastic(yr);
        UpdateFish(yr);
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

    private static void UpdatePlastic(double yr) {
        plasticInOcean += plasticProduction * yr;
    }

    public static void UpdatePlasticProduction() {
        plasticProduction = Game.matas.combinedProduction + Game.laundry.combinedProduction + Game.cardealer.combinedProduction + Game.dock.combinedProduction;
    }

    private static void UpdateFish(double yr) {
        currentFishSouls += plasticInOcean * yr;
        fishInOcean -= plasticInOcean* yr;
        if (fishInOcean <= 0) {
            fishInOcean = 0;
            ScreenWriter.printCenter("\nDu har vundet spillet! Tusind tak for at spille med :)");
        }
    }

    public static String getYear() {
        double date = currentYear + currentTurn;
        double day = (date % 1) * 365;
        String out = "år " + String.format("%.0f",date) + " dag " + String.format("%.0f",day);
        return out;
    }

    public static String getFish(){
        String out = String.format("%.2f",(currentFishSouls)) + " sjæle";
        return out;
    }

    public static String getPlastic(){
        String out = "";
        if(plasticInOcean < 0.9){
            out = String.format("%.2f",plasticInOcean*1000) + " Kilo";
        }else {
            out = String.format("%.2f",plasticInOcean) + " Tons";
        }
        return out;
    }
}
