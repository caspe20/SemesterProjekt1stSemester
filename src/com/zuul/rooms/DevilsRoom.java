package com.zuul.rooms;

import com.zuul.GameStats;

public class DevilsRoom extends Room {

    public DevilsRoom(String description) {
        super(description);
    }

    @Override
    public String getLongDescription() {
        String s = "Du er " + description + ".\n";
        s = s + GameStats.getYear() + ".\n";
        s = s + GameStats.ShowResourceStats() + "\n";
        s = s + getExitString() + "\n";
        return s;
    }
}
