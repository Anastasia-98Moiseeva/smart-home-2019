package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.room.Room;
import ru.sbt.mipt.oop.signaling.Signaling;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    Collection<Room> rooms;

    Signaling signaling;

    public SmartHome() {
        rooms = new ArrayList<>();
        signaling = new Signaling();
    }

    public SmartHome(String code) {
        rooms = new ArrayList<>();
        signaling = new Signaling(code);
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        signaling = new Signaling();
    }

    public SmartHome(Collection<Room> rooms, String code) {
        this.rooms = rooms;
        signaling = new Signaling(code);
    }

    public Signaling getSignaling() { return signaling; }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void execute (Action action, String message){
        for (Room room: rooms) {
            message += room.getName();
            room.execute(action, message);
            message = " in room ";
        }
    }
}
