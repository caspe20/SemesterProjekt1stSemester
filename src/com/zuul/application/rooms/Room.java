package com.zuul.application.rooms;

import java.util.HashMap;

public abstract class Room {

    protected String description;
    protected String roomName;
    private HashMap<String, Room> exits;

    public Room(String roomName, String description) {
        this.description = description;
        this.roomName = roomName;
        exits = new HashMap<>();
    }

    public String getRoomDescription() {
        return description;
    }

    public String getRoomName() {
        return roomName;
    }

}
