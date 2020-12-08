package com.zuul.application.rooms;

import com.zuul.application.UpgradePath;

public class UpgradeRoom extends Room {

    // Attributes
    public UpgradePath upgradePathProducts;
    public UpgradePath upgradePathUsage;
    public double combinedProduction;

    // Constructors
    public UpgradeRoom(String roomName, String description, UpgradePath upgradePathProducts, UpgradePath upgradePathUsage) {
        super(roomName, description);
        this.upgradePathProducts = upgradePathProducts;
        this.upgradePathUsage = upgradePathUsage;
    }

    public UpgradePath getUpgradePathProducts() {
        return upgradePathProducts;
    }

    public UpgradePath getUpgradePathUsage() {
        return upgradePathUsage;
    }

    public void setCombinedProduction() {
        combinedProduction = upgradePathProducts.currentProduction * upgradePathUsage.currentProduction;
    }

    // This function returns what the estimated production will be if you upgrade a
    // certain path a certain amount;
    public double estimateSpeedIfUpgrade(int speed, int quantity) {
        return upgradePathProducts.upgrades[upgradePathProducts.getCurrentLevel() + speed].productionSpeed
                * upgradePathUsage.upgrades[upgradePathProducts.getCurrentLevel() + quantity].productionSpeed;
    }


    public String getProductsUpgradeOneDescription() {
        return "Level " + (getUpgradePathProducts().getCurrentLevel()+1) + " - " + getUpgradePathProducts().getUpgrades()[getUpgradePathProducts().getCurrentLevel()].getUpgradeName();
    }

    public String getProductsUpgradeTwoDescription() {
        return "Level " + (getUpgradePathProducts().getCurrentLevel()+2) + " - " + getUpgradePathProducts().getUpgrades()[getUpgradePathProducts().getCurrentLevel()+1].getUpgradeName();
    }

    public String getProductsUpgradeButtonDescription() {
        return "Opgradér for " + getUpgradePathProducts().getUpgrades()[getUpgradePathProducts().getCurrentLevel()+1].getUpgradePrice() + " fiskesjæle";
    }

    public String getUsageUpgradeOneDescription() {
        return "Level " + (getUpgradePathUsage().getCurrentLevel()+1) + " - " + getUpgradePathUsage().getUpgrades()[getUpgradePathUsage().getCurrentLevel()].getUpgradeName();
    }

    public String getUsageUpgradeTwoDescription() {
        return "Level " + (getUpgradePathUsage().getCurrentLevel()+2) + " - " + getUpgradePathUsage().getUpgrades()[getUpgradePathUsage().getCurrentLevel()+1].getUpgradeName();
    }

    public String getUsageUpgradeButtonDescription() {
        return "Opgradér for " + getUpgradePathUsage().getUpgrades()[getUpgradePathUsage().getCurrentLevel()+1].getUpgradePrice() + " fiskesjæle";
    }


    @Override
    public String getRoomDescription() {
        return description;

        /* Jeg tror ikke at vi har brug for en ScreenWriter længere. Vi må sørge for at vise den
            i implementationen i 1. iteration.

        s = s + ScreenWriter.getCenter("Upgrade #1  [" + upgradePathProducts.getPathName() + "]\n");
        s = s + ScreenWriter.getLeftRight(upgradePathProducts.getUpgradeName(0), " --> " + upgradePathProducts.getUpgradeName(1) + "\n");
        s = s + ScreenWriter.getLeftRight(String.valueOf(upgradePathProducts.getUpgradeCoefficient(0)), " --> " + upgradePathProducts.getUpgradeCoefficient(1) + "\n");
        s = s + ScreenWriter.getLeftRight("Upgrade price: ", upgradePathProducts.getUpgradePrice(1) + " Fish souls\n\n");
        s = s + ScreenWriter.getCenter("Upgrade #2 [" + upgradePathUsage.getPathName() + "]\n");
        s = s + ScreenWriter.getLeftRight(upgradePathUsage.getUpgradeName(0), " --> " + upgradePathUsage.getUpgradeName(1) + "\n");
        s = s + ScreenWriter.getLeftRight(String.valueOf(upgradePathUsage.getUpgradeCoefficient(0))," --> " + upgradePathUsage.getUpgradeCoefficient(1) + "\n");
        s = s + ScreenWriter.getLeftRight("Upgrade price: ", upgradePathUsage.getUpgradePrice(1) + " Fish souls\n");

        return s;
        */
    }
}
