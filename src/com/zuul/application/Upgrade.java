package com.zuul.application;

public class Upgrade {

    // Attributes
    public String upgradeName;
    public long upgradePrice;
    public long productionSpeed;

    // Constructors
    public Upgrade(String upgradeName, long upgradePrice, long productionSpeed) {
        this.upgradeName = upgradeName;
        this.upgradePrice = upgradePrice;
        this.productionSpeed = productionSpeed;
    }
    public Upgrade(String upgradeName, double upgradePrice, double productionSpeed) {
        this.upgradeName = upgradeName;
        this.upgradePrice = (long)upgradePrice;
        this.productionSpeed = (long)productionSpeed;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

    public long getUpgradePrice() {
        return upgradePrice;
    }


}


