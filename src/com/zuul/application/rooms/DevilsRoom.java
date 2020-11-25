package com.zuul.application.rooms;

import com.zuul.application.GameStats;

public class DevilsRoom extends Room {

    public DevilsRoom(String description) {
        super(description);
    }

    @Override
    public String getLongDescription() {
        String s = "Du er " + description + ".\n";
        s = s + GameStats.getYear() + ".\n";
        s = s + getExitString() + "\n";
        return s;
    }
}
