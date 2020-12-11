package com.zuul.application.rooms;

import com.zuul.application.UpgradePath;

public class UpgradeRoom extends Room {

    public UpgradePath upgradePathProducts;
    public UpgradePath upgradePathUsage;
    public double combinedProduction;

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
        combinedProduction = upgradePathProducts.getCurrentProduction() * upgradePathUsage.getCurrentProduction();
    }

}
