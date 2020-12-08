package com.zuul.presentation;

import com.zuul.application.Game;
import com.zuul.application.rooms.DevilsRoom;

public class DevilsRoomController extends Controller {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setStats() {
        if (Game.currentRoom instanceof DevilsRoom) {
            controller.matasProduction.setText("Production level: " + (Game.matas.upgradePathProducts.getCurrentLevel() + 1));
            controller.matasUsage.setText("Usage level: " + (Game.matas.upgradePathUsage.getCurrentLevel() + 1));
            controller.carDealerProduction.setText("Production level: " + (Game.cardealer.upgradePathProducts.getCurrentLevel() + 1));
            controller.carDealerUsage.setText("Usage level: " + (Game.cardealer.upgradePathUsage.getCurrentLevel() + 1));
            controller.laundryProduction.setText("Production level: " + (Game.laundry.upgradePathProducts.getCurrentLevel() + 1));
            controller.laundryUsage.setText("Usage level: " + (Game.laundry.upgradePathUsage.getCurrentLevel() + 1));
            controller.harbourProduction.setText("Production level: " + (Game.dock.upgradePathProducts.getCurrentLevel() + 1));
            controller.harbourUsage.setText("Usage level: " + (Game.dock.upgradePathUsage.getCurrentLevel() + 1));
        }
    }
}
