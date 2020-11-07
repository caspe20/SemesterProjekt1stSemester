package com.zuul.rooms;

import com.zuul.GameStats;

public class DevilsRoom extends Room {

    public DevilsRoom(String description) {
        super(description);
    }
    @Override
    public String getLongDescription() {
        String s = "You are " + description + ".\n";
        s = s + GameStats.getYear() + ".\n";
        s = s + getExitString() + "\n";
        return s;
    }
}
