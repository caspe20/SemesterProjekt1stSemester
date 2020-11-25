package com.zuul.application.rooms;

import com.zuul.application.UpgradePath;

public class Dock extends UpgradeRoom {
    public Dock(String description, UpgradePath upgradePathSpeed, UpgradePath upgradePathQuantity) {
        super(description, upgradePathSpeed, upgradePathQuantity);
    }
}
