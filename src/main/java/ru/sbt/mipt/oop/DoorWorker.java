package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorWorker implements Handler {

    public void work(SmartHome smartHome, Room room, SensorEvent event) {

        for (Door door : room.getDoors()) {

            if (door.getId().equals(event.getObjectId())) {

                if (event.getType() == DOOR_OPEN) {
                    printEvrnt(true, " was opened.", door, room);

                } else {
                    printEvrnt(false, " was closed.", door, room);
                    Hall hall = new Hall();
                    hall.compareWithHall(room, smartHome);
                }
            }
        }
    }

    private static void printEvrnt(boolean positivEvent, String message, Door door, Room room) {
        door.setOpen(positivEvent);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + message);
    }
}
