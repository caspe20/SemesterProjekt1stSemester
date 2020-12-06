package com.zuul.application;

public class UpgradePath {

    // Attributes
    public Upgrade[] upgrades;
    private String pathName;
    private int currentLevel;
    public double currentProduction;

    // Constructors
    public UpgradePath(String pathName, Upgrade[] upgrades) {
        this.upgrades = upgrades;
        this.pathName = pathName;
        calculateCurrentProduction();
    }

    public String getPathName() {
        return pathName;
    }



    // SIMON OG PERNILLES OPGAVE //

    public Upgrade[] getUpgrades() {
        return upgrades;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public double calculateCurrentProduction() {
        currentProduction = upgrades[currentLevel].productionSpeed;
        return currentProduction;
    }

    public boolean performUpgrade() {
        if (currentLevel < upgrades.length-1) {
            if (GameStats.currentFishSouls >= upgrades[currentLevel + 1].upgradePrice) {
                GameStats.currentFishSouls -= upgrades[currentLevel + 1].upgradePrice;
                currentLevel++;
                calculateCurrentProduction();
                return true;
            } else {
                return false;
            }
        } else {
            ScreenWriter.print("Der er ikke flere mulige opgraderinger!");
            return false;
        }
    }

    public String getUpgradeInfo() {
        if (currentLevel < upgrades.length) {
            String s = upgrades[currentLevel].upgradeName + " >>> " + upgrades[currentLevel + 1].upgradeName + "\n";
            s = s + "Price " + upgrades[currentLevel].upgradePrice + " Fish Souls \n";
            s = s + upgrades[currentLevel].productionSpeed + " plastic/yr >>> "
                    + upgrades[currentLevel + 1].productionSpeed + " plastic/yr\n";
            return s;
        } else {
            String s = upgrades[currentLevel].upgradeName + "\n" + upgrades[currentLevel].productionSpeed
                    + " plastic/yr";
            return s;
        }
    }

    public String getUpgradeName(int offset) {
        if (currentLevel + offset < upgrades.length) {
            return upgrades[currentLevel + offset].upgradeName;
        }
        return "";
    }

    public double getUpgradePrice(int offset) {
        if (currentLevel + offset < upgrades.length-1) {
            return upgrades[currentLevel + offset].upgradePrice;
        }
        return -1;
    }

    public double getUpgradeCoefficient(int offset) {
        if (currentLevel + offset < upgrades.length) {
            return upgrades[currentLevel + offset].productionSpeed;
        }
        return -1;
    }

    public int getLevel() {
        return currentLevel;
    }

}
