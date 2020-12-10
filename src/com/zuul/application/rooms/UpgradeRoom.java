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
        combinedProduction = upgradePathProducts.getCurrentProduction() * upgradePathUsage.getCurrentProduction();
    }





    // This function returns what the estimated production will be if you upgrade a
    // certain path a certain amount;

    @Override
    public String getRoomDescription() {
        return description;
    }
}
