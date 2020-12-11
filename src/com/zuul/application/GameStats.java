package com.zuul.application;

public class GameStats {
    private static double fishInOcean = 2000000000d;
    private static double fishInOceanBeginning = fishInOcean;
    private static double currentFishSouls = 2000000000;
    private static double plasticInOcean;
    private static double plasticProduction = 5;
    private static double currentTurn = 0;
    private static final int currentYear = 2000;

    public static void simulateTurn(double yr) {
        setCurrentTurn(getCurrentTurn() + yr);
        updatePlastic(yr);
        updateFish(yr);
    }

    public static double getFishInOcean() {
        return fishInOcean;
    }

    public static void setFishInOcean(double fishInOcean) {
        GameStats.fishInOcean = fishInOcean;
    }

    public static double getFishInOceanBeginning() {
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

    public static double getCurrentTurn() {
        return currentTurn;
    }

    public static void setCurrentTurn(double currentTurn) {
        GameStats.currentTurn = currentTurn;
    }

    private static void updatePlastic(double yr) {
        setPlasticInOcean(getPlasticInOcean() + plasticProduction * yr);
    }

    public static void updatePlasticProduction() {
        plasticProduction = Game.matas.combinedProduction + Game.laundry.combinedProduction + Game.cardealer.combinedProduction + Game.dock.combinedProduction + 5;
    }

    private static void updateFish(double yr) {
        setCurrentFishSouls(currentFishSouls + plasticInOcean * yr);
        setFishInOcean(fishInOcean - plasticInOcean * yr);
        if (getFishInOcean() <= 0) {
            setFishInOcean(0);
        }
    }


    public static String getTime() {
        double year = currentYear + currentTurn;
        double day = (year % 1) * 365;
        String out = "år " + (int) Math.floor(year) + " dag " + String.format("%.0f", day);
        return out;
    }

    public static int getYearsPlayed() {
        return (int) currentTurn;
    }

    public static int getDaysPlayed() {
        double year = currentYear + currentTurn;
        double day = (year % 1) * 365;
        return (int) day;
    }


    public static String getFish() {
        return convertToVerbal(currentFishSouls) + " sjæle";
    }

    public static String getPlasticProduction() {
        return convertToVerbal(plasticProduction) + " Tons";
    }

    public static String convertToVerbal(double count) {
        if (count < 1000) {
            return String.format("%.2f", count);
        } else if (count < 1000000) {
            return String.format("%.2f", count / 1000) + "K";
        } else {
            return String.format("%.2f", count / 1000000) + "M";
        }
    }

    public static String getPlastic() {
        String out = "";
        if (getPlasticInOcean() < 1) {
            out = String.format("%.2f", plasticInOcean * 1000) + " Kilo";
        } else {
            out = convertToVerbal(plasticInOcean) + " Tons";
        }
        return out;
    }
}
