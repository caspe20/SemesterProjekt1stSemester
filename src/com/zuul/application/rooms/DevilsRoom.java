package com.zuul.application.rooms;

import com.zuul.application.GameStats;

public class DevilsRoom extends Room {

    public DevilsRoom(String roomName, String description) {
        super(roomName, description);
    }

    @Override
    public String getRoomDescription() {
        String s = "Du er " + description + ".\n";
        s = s + GameStats.getYear() + ".\n";
        s = s + getExitString() + "\n";
        return s;
    }
}
