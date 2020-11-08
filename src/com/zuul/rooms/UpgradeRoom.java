package com.zuul.rooms;

import com.zuul.UpgradePath;

public class UpgradeRoom extends Room {

    // Attributes
    public UpgradePath upgradePathProducts;
    public UpgradePath upgradePathUsage;
    public double combinedProduction;

    // Constructors
    public UpgradeRoom(String description, UpgradePath upgradePathProducts, UpgradePath upgradePathUsage) {
        super(description);
        this.upgradePathProducts = upgradePathProducts;
        this.upgradePathUsage = upgradePathUsage;
    }

    public void setCombinedProduction() {
        combinedProduction = upgradePathProducts.currentProduction * upgradePathUsage.currentProduction;
    }

    // This function returns what the estimated production will be if you upgrade a
    // certain path a certain amount;
    public double estimateSpeedIfUpgrade(int speed, int quantity) {
        return upgradePathProducts.upgrades[upgradePathProducts.getLevel() + speed].productionSpeed
                * upgradePathUsage.upgrades[upgradePathProducts.getLevel() + quantity].productionSpeed;
    }

    @Override
    public String getLongDescription() {
        String s = "You are " + description + ".\n";
        s = s + "--- Upgrade 1 ( " + upgradePathProducts.getPathName() + ") --- \n";
        s = s + upgradePathProducts.getUpgradeName(0) + " --> " + upgradePathProducts.getUpgradeName(1) + "\n";
        s = s + upgradePathProducts.getUpgradeCoefficient(0) + " --> " + upgradePathProducts.getUpgradeCoefficient(1) + "\n";
        s = s + "Upgrade price: " + upgradePathProducts.getUpgradePrice(1) + " Fish souls\n";
        s = s + "--- Upgrade 2 ( " + upgradePathUsage.getPathName() + ") --- \n";
        s = s + upgradePathUsage.getUpgradeName(0) + " --> " + upgradePathUsage.getUpgradeName(1) + "\n";
        s = s + upgradePathUsage.getUpgradeCoefficient(0) + " --> " + upgradePathUsage.getUpgradeCoefficient(1)
                + "\n";
        s = s + "Upgrade price: " + upgradePathUsage.getUpgradePrice(1) + " Fish souls\n";
        return s;
    }
}
