package com.zuul.application;

import com.zuul.application.rooms.UpgradeRoom;

public class GameStats {
    private static long fishInOcean = 2000000000l;
    private static long fishInOceanBeginning = getFishInOcean();
    private static double currentFishSouls = 0;
    private static double plasticInOcean;
    public static double plasticProduction = 5;
    private static String gameProgress;
    private UpgradeRoom[] upgradeRoom;
    private static double currentTurn = 0;
    private static final int currentYear = 2000;

    public static void SimulateTurn(double yr) {
        setCurrentTurn(getCurrentTurn() + yr);
        UpdatePlastic(yr);
        UpdateFish(yr);
    }

    public static long getFishInOcean() {
        return fishInOcean;
    }

    public static void setFishInOcean(long fishInOcean) {
        GameStats.fishInOcean = fishInOcean;
    }

    public static long getFishInOceanBeginning() {
        return fishInOceanBeginning;
    }

    public static double getCurrentFishSouls() {
        return currentFishSouls;
    }

    public static void setCurrentFishSouls(double currentFishSouls) {
        GameStats.currentFishSouls = currentFishSouls;
    }

    public static double getPlasticInOcean() {
        return plasticInOcean;
    }

    public static void setPlasticInOcean(double plasticInOcean) {
        GameStats.plasticInOcean = plasticInOcean;
    }

    public static String getGameProgress() {
        return gameProgress;
    }

    public static void setGameProgress(String gameProgress) {
        GameStats.gameProgress = gameProgress;
    }

    public static double getCurrentTurn() {
        return currentTurn;
    }

    public static void setCurrentTurn(double currentTurn) {
        GameStats.currentTurn = currentTurn;
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    public String ProgressUpdate(String gameProgress) {
        this.setGameProgress(gameProgress);
        return gameProgress;
    }

    public static void FetchPlasticProduction(double currentTotalPlasticProduction) {
        plasticProduction = currentTotalPlasticProduction;
    }

    private static void UpdatePlastic(double yr) {
        setPlasticInOcean(getPlasticInOcean() + plasticProduction * yr);
    }

    public static void UpdatePlasticProduction() {
        plasticProduction = Game.matas.combinedProduction + Game.laundry.combinedProduction + Game.cardealer.combinedProduction + Game.dock.combinedProduction + 5;
    }

    private static void UpdateFish(double yr) {
        setCurrentFishSouls(getCurrentFishSouls() + getPlasticInOcean() * yr);
        setFishInOcean((long)getFishInOcean() - (long)getPlasticInOcean() * (long)yr);
        if (getFishInOcean() <= 0) {
            setFishInOcean(0);
        }
    }


    public static String getTime() {
        double year = currentYear + currentTurn;
        double day = (year % 1) * 365;
        String out = "år " + (int)Math.floor(year) + " dag " + String.format("%.0f",day);
        return out;
    }

    public static int getYearsPlayed() {
        return (int)currentTurn;
    }

    public static int getDaysPlayed() {
        double year = currentYear + currentTurn;
        double day = (year % 1) * 365;
        return (int)day;
    }



    public static String getFish() {
        return convertToVerbal(getCurrentFishSouls()) + " sjæle";
    }

    public static String getPlasticProduction(){
        return convertToVerbal(plasticProduction) + " Tons";
    }

    public static String convertToVerbal(double count) {
        if (count < 1000) {
            return String.format("%.2f", count);
        } else if (count < 1000000) {
            return String.format("%.2f", count / 1000) + "K";
        } else {
            return String.format("%.2f", count/1000000) + "M";
        }
    }

    public static String getPlastic() {
        String out = "";
        if (getPlasticInOcean() < 1) {
            out = String.format("%.2f", getPlasticInOcean() * 1000) + " Kilo";
        } else{
            out = convertToVerbal(getPlasticInOcean()) + " Tons";
        }
        return out;
    }
}
