package com.zuul.application;

public class UpgradePath {

    private Upgrade[] upgrades;
    private String pathName;
    private int currentLevel;
    private double currentProduction;

    public UpgradePath(String pathName, Upgrade[] upgrades) {
        this.upgrades = upgrades;
        this.pathName = pathName;
        calculateCurrentProduction();
    }

    /**
     * getters and setters
     */

    public Upgrade[] getUpgrades() {
        return upgrades;
    }

    /**
     * gets the current plastic production for the upgrade path
     * 
     * @return returns current plastic production
     */
    public double getCurrentProduction() {
        return currentProduction;
    }

    /**
     * gets the plastic production if the upgrade path was upgraded
     * 
     * @return returns upgraded plastic production
     */
    public double getUpgradeProduction() {
        if (currentLevel < upgrades.length - 1) {
            return upgrades[currentLevel + 1].productionSpeed;
        }
        return 0;
    }

    /**
     * gets the current upgrade level that the path is on
     * 
     * @return current upgrade level
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    public String getUpgradeButtonDescription() {
        if (currentLevel < upgrades.length - 1) {
            return GameStats.convertToVerbal(upgrades[currentLevel + 1].getUpgradePrice()) + " fiskesjæle";
        }
        return "Opgradering utilgængelig";
    }

    public String getUpgradeOneDescription() {
        return "Level " + (currentLevel + 1) + " - " + upgrades[currentLevel].getUpgradeName();
    }

    public String getUpgradeTwoDescription() {
        if (currentLevel < upgrades.length - 1) {
            return "Level " + (currentLevel + 2) + " - " + upgrades[currentLevel + 1].getUpgradeName();
        }
        return "Max opgradering nået";
    }

    /**
     * functional members
     */

    /**
     * Calculates the new currentProduction
     * @return currentProduction
     */
    public double calculateCurrentProduction() {
        currentProduction = upgrades[currentLevel].productionSpeed;
        return currentProduction;
    }

    /**
     * performs an upgrade, and returns true if it was possible to do so.
     * @return whether an upgrade could be made
     */
    public boolean performUpgrade() {
        if (currentLevel < upgrades.length - 1) {
            if (GameStats.getCurrentFishSouls() >= upgrades[currentLevel + 1].upgradePrice) {
                GameStats.setCurrentFishSouls(GameStats.getCurrentFishSouls() - upgrades[currentLevel + 1].upgradePrice);
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
