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
        }
        return false;
    }
}
