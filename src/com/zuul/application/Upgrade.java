package com.zuul.application;

public class Upgrade {

    public String upgradeName;
    public double upgradePrice;
    public double productionSpeed;

    public Upgrade(String upgradeName, double upgradePrice, double productionSpeed) {
        this.upgradeName = upgradeName;
        this.upgradePrice = upgradePrice;
        this.productionSpeed = productionSpeed;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

    public double getUpgradePrice() {
        return upgradePrice;
    }

}


