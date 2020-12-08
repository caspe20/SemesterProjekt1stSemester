package com.zuul.application;

public class UpgradePath {

    // Attributes
    private Upgrade[] upgrades;
    private String pathName;
    private int currentLevel;
    public double currentProduction;

    // Constructors
    public UpgradePath(String pathName, Upgrade[] upgrades) {
        this.upgrades = upgrades;
        this.pathName = pathName;
        calculateCurrentProduction();
    }

    public double getCurrentProduction() {
        return currentProduction;
    }

    public double getUpgradeProduction() {
        if (currentLevel < upgrades.length - 1) {
            return upgrades[currentLevel + 1].productionSpeed;
        }
        return 0;
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
        if (currentLevel < upgrades.length - 1) {
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

    public String getUpgradeInfo() {
        if (currentLevel < upgrades.length) {
            String upgradeInfo = upgrades[currentLevel].upgradeName + " >>> " + upgrades[currentLevel + 1].upgradeName + "\n";
            upgradeInfo = upgradeInfo + "Price " + upgrades[currentLevel].upgradePrice + " Fish Souls \n";
            upgradeInfo = upgradeInfo + upgrades[currentLevel].productionSpeed + " plastic/yr >>> "
                    + upgrades[currentLevel + 1].productionSpeed + " plastic/yr\n";
            return upgradeInfo;
        } else {
            String upgradeInfo = upgrades[currentLevel].upgradeName + "\n" + upgrades[currentLevel].productionSpeed
                    + " plastic/yr";
            return upgradeInfo;
        }
    }

    public String getUpgradeName(int offset) {
        if (currentLevel + offset < upgrades.length) {
            return upgrades[currentLevel + offset].upgradeName;
        }
        return "";
    }

    public double getUpgradePrice(int offset) {
        if (currentLevel + offset < upgrades.length - 1) {
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

    public String getUpgradeButtonDescription() {
        if (currentLevel < upgrades.length - 1) {
            return "Opgradér for " + GameStats.convertToVerbal(upgrades[currentLevel + 1].getUpgradePrice()) + " fiskesjæle";
        }
        return "opgradering utilgængelig";
    }

    public String getUpgradeOneDescription() {
        return "Level " + (currentLevel + 1) + " - " + upgrades[currentLevel].getUpgradeName();
    }

    public String getUpgradeTwoDescription() {
        if (currentLevel < upgrades.length - 1) {
            return "Level " + (currentLevel + 2) + " - " + upgrades[currentLevel + 1].getUpgradeName();
        }
        return "Max Opgradering Nået";
    }
}
