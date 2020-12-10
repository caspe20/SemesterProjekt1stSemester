package com.zuul.application.rooms;

import java.util.Set;
import java.util.HashMap;

//Vi benytter en abstrakt klasse, da vi aldrig er interesseret
// i at ville lave et objekt direkte af Room.
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
